package com.pnku.mcbv.init;

import com.pnku.mcbv.MoreChiseledBookshelfVariants;
import com.pnku.mcbv.block.MoreChiseledBookshelfBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class McbvItemInit {
    public static final BlockItem SPRUCE_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.SPRUCE_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem BIRCH_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.BIRCH_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem JUNGLE_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.JUNGLE_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem ACACIA_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.ACACIA_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem DARK_OAK_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.DARK_OAK_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem MANGROVE_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.MANGROVE_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem CHERRY_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.CHERRY_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem BAMBOO_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.BAMBOO_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem CRIMSON_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.CRIMSON_CHISELED_BOOKSHELF, new Item.Settings());
    public static final BlockItem WARPED_CHISELED_BOOKSHELF_I = new BlockItem(McbvBlockInit.WARPED_CHISELED_BOOKSHELF, new Item.Settings());


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
        Registry.register(Registries.ITEM, MoreChiseledBookshelfVariants.asId(((MoreChiseledBookshelfBlock) chiseled_bookshelf.getBlock()).chiseledBookshelfType + "_chiseled_bookshelf"), chiseled_bookshelf);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(chiseled_bookshelfAfter, chiseled_bookshelf));
    }
}