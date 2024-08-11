package de.pnku.mcbv.block;

import com.mojang.logging.LogUtils;
import de.pnku.mcbv.init.McbvBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Objects;
import java.util.function.Predicate;

public class MoreChiseledBookShelfBlockEntity extends BlockEntity implements Container {
    public static final int MAX_BOOKS_IN_STORAGE = 6;
    private static final Logger LOGGER = LogUtils.getLogger();
    private final NonNullList<ItemStack> items;
    private int lastInteractedSlot;

    public MoreChiseledBookShelfBlockEntity(BlockPos pos, BlockState state) {
        super(McbvBlockInit.MORE_CHISELED_BOOKSHELF_BLOCK_ENTITY, pos, state);
        this.items = NonNullList.withSize(6, ItemStack.EMPTY);
        this.lastInteractedSlot = -1;
    }

    private void updateState(int slot) {
        if (slot >= 0 && slot < 6) {
            this.lastInteractedSlot = slot;
            BlockState blockState = this.getBlockState();

            for(int i = 0; i < MoreChiseledBookShelfBlock.SLOT_OCCUPIED_PROPERTIES.size(); ++i) {
                boolean bl = !this.getItem(i).isEmpty();
                BooleanProperty booleanProperty = (BooleanProperty)MoreChiseledBookShelfBlock.SLOT_OCCUPIED_PROPERTIES.get(i);
                blockState = (BlockState)blockState.setValue(booleanProperty, bl);
            }

            ((Level) Objects.requireNonNull(this.level)).setBlock(this.worldPosition, blockState, 3);
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.worldPosition, GameEvent.Context.of(blockState));
        } else {
            LOGGER.error("Expected slot 0-5, got {}", slot);
        }
    }

    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.items.clear();
        ContainerHelper.loadAllItems(tag, this.items, registries);
        this.lastInteractedSlot = tag.getInt("last_interacted_slot");
    }

    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.items, true, registries);
        tag.putInt("last_interacted_slot", this.lastInteractedSlot);
    }

    public int count() {
        return (int)this.items.stream().filter(Predicate.not(ItemStack::isEmpty)).count();
    }

    public void clearContent() {
        this.items.clear();
    }

    public int getContainerSize() {
        return 6;
    }

    public boolean isEmpty() {
        return this.items.stream().allMatch(ItemStack::isEmpty);
    }

    public @NotNull ItemStack getItem(int slot) {
        return (ItemStack)this.items.get(slot);
    }

    public @NotNull ItemStack removeItem(int slot, int amount) {
        ItemStack itemStack = (ItemStack)Objects.requireNonNullElse((ItemStack)this.items.get(slot), ItemStack.EMPTY);
        this.items.set(slot, ItemStack.EMPTY);
        if (!itemStack.isEmpty()) {
            this.updateState(slot);
        }

        return itemStack;
    }

    public @NotNull ItemStack removeItemNoUpdate(int slot) {
        return this.removeItem(slot, 1);
    }

    public void setItem(int slot, ItemStack stack) {
        if (stack.is(ItemTags.BOOKSHELF_BOOKS)) {
            this.items.set(slot, stack);
            this.updateState(slot);
        } else if (stack.isEmpty()) {
            this.removeItem(slot, 1);
        }

    }

    public boolean canTakeItem(Container target, int slot, ItemStack stack) {
        return target.hasAnyMatching((itemStack2) -> {
            if (itemStack2.isEmpty()) {
                return true;
            } else {
                return ItemStack.isSameItemSameComponents(stack, itemStack2) && itemStack2.getCount() + stack.getCount() <= target.getMaxStackSize(itemStack2);
            }
        });
    }

    public int getMaxStackSize() {
        return 1;
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    public boolean canPlaceItem(int slot, ItemStack stack) {
        return stack.is(ItemTags.BOOKSHELF_BOOKS) && this.getItem(slot).isEmpty() && stack.getCount() == this.getMaxStackSize();
    }

    public int getLastInteractedSlot() {
        return this.lastInteractedSlot;
    }

    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        ((ItemContainerContents)componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)).copyInto(this.items);
    }

    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.items));
    }

    public void removeComponentsFromTag(CompoundTag tag) {
        tag.remove("Items");
    }
}
