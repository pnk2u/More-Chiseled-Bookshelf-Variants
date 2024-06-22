package com.pnku.mcbv.init;

import com.pnku.mcbv.MoreChiseledBookshelfVariants;
import com.pnku.mcbv.block.MoreChiseledBookshelfBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.List;

public class McbvBlockInit {
    public static final MoreChiseledBookshelfBlock SPRUCE_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.SPRUCE_BROWN, "spruce");
    public static final MoreChiseledBookshelfBlock BIRCH_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.PALE_YELLOW, "birch");
    public static final MoreChiseledBookshelfBlock JUNGLE_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.DIRT_BROWN, "jungle");
    public static final MoreChiseledBookshelfBlock ACACIA_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.ORANGE, "acacia");
    public static final MoreChiseledBookshelfBlock DARK_OAK_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.BROWN, "dark_oak");
    public static final MoreChiseledBookshelfBlock MANGROVE_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.RED, "mangrove");
    public static final MoreChiseledBookshelfBlock CHERRY_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.TERRACOTTA_WHITE, BlockSoundGroup.CHERRY_WOOD, "cherry");
    public static final MoreChiseledBookshelfBlock BAMBOO_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.YELLOW, BlockSoundGroup.BAMBOO_WOOD, "bamboo");
    public static final MoreChiseledBookshelfBlock CRIMSON_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.DULL_PINK, BlockSoundGroup.NETHER_WOOD, "crimson");
    public static final MoreChiseledBookshelfBlock WARPED_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.DARK_AQUA, BlockSoundGroup.NETHER_WOOD, "warped");

    public static final List<Block> more_chiseled_bookshelves = new ArrayList<>();


    public static void registerBlocks() {
        registerBlock(SPRUCE_CHISELED_BOOKSHELF);
        registerBlock(BIRCH_CHISELED_BOOKSHELF);
        registerBlock(JUNGLE_CHISELED_BOOKSHELF);
        registerBlock(ACACIA_CHISELED_BOOKSHELF);
        registerBlock(DARK_OAK_CHISELED_BOOKSHELF);
        registerBlock(MANGROVE_CHISELED_BOOKSHELF);
        registerBlock(CHERRY_CHISELED_BOOKSHELF);
        registerBlock(BAMBOO_CHISELED_BOOKSHELF);
        registerBlock(CRIMSON_CHISELED_BOOKSHELF);
        registerBlock(WARPED_CHISELED_BOOKSHELF);

    }

    private static void registerBlock(MoreChiseledBookshelfBlock chiseled_bookshelf) {
        Registry.register(Registries.BLOCK, MoreChiseledBookshelfVariants.asId(chiseled_bookshelf.chiseledBookshelfType + "_chiseled_bookshelf"), chiseled_bookshelf);
        more_chiseled_bookshelves.add(chiseled_bookshelf);
    }
}