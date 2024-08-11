package de.pnku.mcbv.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class MoreChiseledBookShelfBlock extends ChiseledBookShelfBlock {
    public final String chiseledBookshelfWoodType;

    public MoreChiseledBookShelfBlock(MapColor colour, String chiseledBookshelfWoodType) {
        super(Properties.copy(Blocks.CHISELED_BOOKSHELF).mapColor(colour));
        this.chiseledBookshelfWoodType = chiseledBookshelfWoodType;
    }

    public MoreChiseledBookShelfBlock(MapColor colour, SoundType soundType, String chiseledBookshelfWoodType) {
        super(Properties.copy(Blocks.CHISELED_BOOKSHELF).mapColor(colour).sound(soundType));
        this.chiseledBookshelfWoodType = chiseledBookshelfWoodType;
    }
}