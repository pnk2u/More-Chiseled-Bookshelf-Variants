package de.pnku.mcbv.init;

import de.pnku.mcbv.MoreChiseledBookshelfVariants;
import de.pnku.mcbv.block.MoreChiseledBookShelfBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public class McbvBlockInit {
    public static final MoreChiseledBookShelfBlock SPRUCE_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.PODZOL, "spruce");
    public static final MoreChiseledBookShelfBlock BIRCH_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.SAND, "birch");
    public static final MoreChiseledBookShelfBlock JUNGLE_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.DIRT, "jungle");
    public static final MoreChiseledBookShelfBlock ACACIA_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.COLOR_ORANGE, "acacia");
    public static final MoreChiseledBookShelfBlock DARK_OAK_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.COLOR_BROWN, "dark_oak");
    public static final MoreChiseledBookShelfBlock MANGROVE_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.COLOR_RED, "mangrove");
    public static final MoreChiseledBookShelfBlock CHERRY_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry");
    public static final MoreChiseledBookShelfBlock BAMBOO_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo");
    public static final MoreChiseledBookShelfBlock CRIMSON_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson");
    public static final MoreChiseledBookShelfBlock WARPED_CHISELED_BOOKSHELF = new MoreChiseledBookShelfBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped");


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

    private static void registerBlock(MoreChiseledBookShelfBlock chiseled_bookshelf) {
        Registry.register(BuiltInRegistries.BLOCK, MoreChiseledBookshelfVariants.asId(chiseled_bookshelf.chiseledBookshelfWoodType + "_chiseled_bookshelf"), chiseled_bookshelf);
        more_chiseled_bookshelves.add(chiseled_bookshelf);
    }
}