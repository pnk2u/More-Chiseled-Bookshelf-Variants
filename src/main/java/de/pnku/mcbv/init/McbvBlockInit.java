package de.pnku.mcbv.init;

import de.pnku.mcbv.MoreChiseledBookshelfVariants;
import de.pnku.mcbv.block.MoreChiseledBookshelfBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public class McbvBlockInit {
    public static final MoreChiseledBookshelfBlock SPRUCE_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.PODZOL, "spruce");
    public static final MoreChiseledBookshelfBlock BIRCH_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.SAND, "birch");
    public static final MoreChiseledBookshelfBlock JUNGLE_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.DIRT, "jungle");
    public static final MoreChiseledBookshelfBlock ACACIA_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.COLOR_ORANGE, "acacia");
    public static final MoreChiseledBookshelfBlock DARK_OAK_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.COLOR_BROWN, "dark_oak");
    public static final MoreChiseledBookshelfBlock MANGROVE_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.COLOR_RED, "mangrove");
    public static final MoreChiseledBookshelfBlock CHERRY_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry");
    public static final MoreChiseledBookshelfBlock BAMBOO_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo");
    public static final MoreChiseledBookshelfBlock CRIMSON_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson");
    public static final MoreChiseledBookshelfBlock WARPED_CHISELED_BOOKSHELF = new MoreChiseledBookshelfBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped");

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
        Registry.register(BuiltInRegistries.BLOCK, MoreChiseledBookshelfVariants.asId(chiseled_bookshelf.chiseledBookshelfWoodType + "_chiseled_bookshelf"), chiseled_bookshelf);
        more_chiseled_bookshelves.add(chiseled_bookshelf);
    }
}