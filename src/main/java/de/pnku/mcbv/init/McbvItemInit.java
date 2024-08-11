package de.pnku.mcbv.init;

import de.pnku.mcbv.MoreChiseledBookshelfVariants;
import de.pnku.mcbv.block.MoreChiseledBookshelfBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class McbvItemInit {
    public static final BlockItem SPRUCE_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.SPRUCE_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem BIRCH_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.BIRCH_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem JUNGLE_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.JUNGLE_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem ACACIA_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.ACACIA_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem DARK_OAK_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.DARK_OAK_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem MANGROVE_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.MANGROVE_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem CHERRY_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.CHERRY_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem BAMBOO_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.BAMBOO_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem CRIMSON_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.CRIMSON_CHISELED_BOOKSHELF, new Item.Properties());
    public static final BlockItem WARPED_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.WARPED_CHISELED_BOOKSHELF, new Item.Properties());


    public static void registerItems() {
        registerItem(SPRUCE_CHISELED_BOOKSHELF_I, Items.CHISELED_BOOKSHELF);
        registerItem(BIRCH_CHISELED_BOOKSHELF_I, SPRUCE_CHISELED_BOOKSHELF_I);
        registerItem(JUNGLE_CHISELED_BOOKSHELF_I, BIRCH_CHISELED_BOOKSHELF_I);
        registerItem(ACACIA_CHISELED_BOOKSHELF_I, JUNGLE_CHISELED_BOOKSHELF_I);
        registerItem(DARK_OAK_CHISELED_BOOKSHELF_I, ACACIA_CHISELED_BOOKSHELF_I);
        registerItem(MANGROVE_CHISELED_BOOKSHELF_I, DARK_OAK_CHISELED_BOOKSHELF_I);
        registerItem(CHERRY_CHISELED_BOOKSHELF_I, MANGROVE_CHISELED_BOOKSHELF_I);
        registerItem(BAMBOO_CHISELED_BOOKSHELF_I, CHERRY_CHISELED_BOOKSHELF_I);
        registerItem(CRIMSON_CHISELED_BOOKSHELF_I, BAMBOO_CHISELED_BOOKSHELF_I);
        registerItem(WARPED_CHISELED_BOOKSHELF_I, CRIMSON_CHISELED_BOOKSHELF_I);
    }

    private static void registerItem(BlockItem chiseled_bookshelf, Item chiseled_bookshelfAfter) {
        Registry.register(BuiltInRegistries.ITEM, MoreChiseledBookshelfVariants.asId(((MoreChiseledBookshelfBlock) chiseled_bookshelf.getBlock()).chiseledBookshelfWoodType + "_chiseled_bookshelf"), chiseled_bookshelf);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.addAfter(chiseled_bookshelfAfter, chiseled_bookshelf));
    }
}