package de.pnku.mcbv;

import de.pnku.mcbv.init.McbvBlockInit;
import de.pnku.mcbv.init.McbvItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class MoreChiseledBookshelfVariants implements ModInitializer {
    public static final String MODID = "lolmcbv";

    @Override
    public void onInitialize() {
        McbvBlockInit.registerBlocks();
        McbvItemInit.registerItems();
    }

    public static ResourceLocation asId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}