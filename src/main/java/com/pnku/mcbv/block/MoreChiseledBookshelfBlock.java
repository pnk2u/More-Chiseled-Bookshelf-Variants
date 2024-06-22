package com.pnku.mcbv.block;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class MoreChiseledBookshelfBlock extends ChiseledBookshelfBlock {
    public final String chiseledBookshelfType;

    public MoreChiseledBookshelfBlock(MapColor colour, String chiseledBookshelfType) {
        super(Settings.copy(Blocks.CHISELED_BOOKSHELF).mapColor(colour));
        this.chiseledBookshelfType = chiseledBookshelfType;
    }

    public MoreChiseledBookshelfBlock(MapColor colour, BlockSoundGroup sound, String chiseledBookshelfType) {
        super(Settings.copy(Blocks.CHISELED_BOOKSHELF).mapColor(colour).sounds(sound));
        this.chiseledBookshelfType = chiseledBookshelfType;
    }
}