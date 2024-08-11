package de.pnku.mcbv.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

public class MoreChiseledBookshelfBlock extends ChiseledBookShelfBlock {
    public final String chiseledBookshelfWoodType;

    public MoreChiseledBookshelfBlock(MapColor colour, String chiseledBookshelfWoodType) {
        super(Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF).mapColor(colour));
        this.chiseledBookshelfWoodType = chiseledBookshelfWoodType;
    }

    public MoreChiseledBookshelfBlock(MapColor colour, SoundType soundType, String chiseledBookshelfWoodType) {
        super(Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF).mapColor(colour).sound(soundType));
        this.chiseledBookshelfWoodType = chiseledBookshelfWoodType;
    }
}