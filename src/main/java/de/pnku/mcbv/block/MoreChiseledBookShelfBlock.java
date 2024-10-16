package de.pnku.mcbv.block;

import de.pnku.mcbv.MoreChiseledBookshelfVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.OptionalInt;

public class MoreChiseledBookShelfBlock extends ChiseledBookShelfBlock {
    public final String chiseledBookshelfWoodType;

    public MoreChiseledBookShelfBlock(MapColor colour, String chiseledBookshelfWoodType) {
        super(Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF).mapColor(colour).setId(ResourceKey.create(Registries.BLOCK, MoreChiseledBookshelfVariants.asId(chiseledBookshelfWoodType + "_chiseled_boookshelf"))));
        this.chiseledBookshelfWoodType = chiseledBookshelfWoodType;
    }

    public MoreChiseledBookShelfBlock(MapColor colour, SoundType soundType, String chiseledBookshelfWoodType) {
        super(Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF).mapColor(colour).setId(ResourceKey.create(Registries.BLOCK, MoreChiseledBookshelfVariants.asId(chiseledBookshelfWoodType + "_chiseled_boookshelf"))).sound(soundType));
        this.chiseledBookshelfWoodType = chiseledBookshelfWoodType;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        BlockEntity var9 = level.getBlockEntity(blockPos);
        if (var9 instanceof MoreChiseledBookShelfBlockEntity moreChiseledBookShelfBlockEntity) {
            if (!itemStack.is(ItemTags.BOOKSHELF_BOOKS)) {
                return InteractionResult.TRY_WITH_EMPTY_HAND;
            } else {
                OptionalInt optionalInt = this.getHitSlot(blockHitResult, blockState);
                if (optionalInt.isEmpty()) {
                    return InteractionResult.PASS;
                } else if ((Boolean)blockState.getValue((Property)SLOT_OCCUPIED_PROPERTIES.get(optionalInt.getAsInt()))) {
                    return InteractionResult.TRY_WITH_EMPTY_HAND;
                } else {
                    addBook(level, blockPos, player, moreChiseledBookShelfBlockEntity, itemStack, optionalInt.getAsInt());
                    return InteractionResult.SUCCESS;
                }
            }
            } else {
                return InteractionResult.PASS;
            }
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity var7 = level.getBlockEntity(pos);
        if (var7 instanceof MoreChiseledBookShelfBlockEntity moreChiseledBookShelfBlockEntity) {
            OptionalInt optionalInt = this.getHitSlot(hitResult, state);
            if (optionalInt.isEmpty()) {
                return InteractionResult.PASS;
            } else if (!(Boolean)state.getValue((Property)SLOT_OCCUPIED_PROPERTIES.get(optionalInt.getAsInt()))) {
                return InteractionResult.CONSUME;
            } else {
                removeBook(level, pos, player, moreChiseledBookShelfBlockEntity, optionalInt.getAsInt());
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }


    private static void addBook(Level level, BlockPos pos, Player player, MoreChiseledBookShelfBlockEntity blockEntity, ItemStack bookStack, int slot) {
        if (!level.isClientSide) {
            player.awardStat(Stats.ITEM_USED.get(bookStack.getItem()));
            SoundEvent soundEvent = bookStack.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_INSERT_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_INSERT;
            blockEntity.setItem(slot, bookStack.consumeAndReturn(1, player));
            level.playSound((Player)null, pos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    private static void removeBook(Level level, BlockPos pos, Player player, MoreChiseledBookShelfBlockEntity blockEntity, int slot) {
        if (!level.isClientSide) {
            ItemStack itemStack = blockEntity.removeItem(slot, 1);
            SoundEvent soundEvent = itemStack.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_PICKUP_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_PICKUP;
            level.playSound((Player)null, pos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!player.getInventory().add(itemStack)) {
                player.drop(itemStack, false);
            }

            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChiseledBookShelfBlockEntity(pos, state);
    }

    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            boolean bl;
            label32: {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof MoreChiseledBookShelfBlockEntity) {
                    MoreChiseledBookShelfBlockEntity moreChiseledBookShelfBlockEntity = (MoreChiseledBookShelfBlockEntity)blockEntity;
                    if (!moreChiseledBookShelfBlockEntity.isEmpty()) {
                        for(int i = 0; i < 6; ++i) {
                            ItemStack itemStack = moreChiseledBookShelfBlockEntity.getItem(i);
                            if (!itemStack.isEmpty()) {
                                Containers.dropItemStack(level, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), itemStack);
                            }
                        }

                        moreChiseledBookShelfBlockEntity.clearContent();
                        bl = true;
                        break label32;
                    }
                }

                bl = false;
            }

            super.onRemove(state, level, pos, newState, movedByPiston);
            if (bl) {
                level.updateNeighbourForOutputSignal(pos, this);
            }

        }
    }

    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        if (level.isClientSide()) {
            return 0;
        } else {
            BlockEntity var5 = level.getBlockEntity(pos);
            if (var5 instanceof MoreChiseledBookShelfBlockEntity) {
                MoreChiseledBookShelfBlockEntity moreChiseledBookShelfBlockEntity = (MoreChiseledBookShelfBlockEntity)var5;
                return moreChiseledBookShelfBlockEntity.getLastInteractedSlot() + 1;
            } else {
                return 0;
            }
        }
    }

}