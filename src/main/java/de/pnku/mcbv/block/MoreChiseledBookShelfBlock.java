package de.pnku.mcbv.block;

import de.pnku.mcbv.MoreChiseledBookshelfVariants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

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

}