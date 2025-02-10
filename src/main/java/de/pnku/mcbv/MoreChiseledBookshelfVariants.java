package de.pnku.mcbv;

import de.pnku.mcbv.init.McbvBlockInit;
import de.pnku.mcbv.init.McbvItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreChiseledBookshelfVariants implements ModInitializer {
    public static final String MODID = "lolmcbv";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        McbvBlockInit.registerBlocks();
        McbvItemInit.registerItems();
    }

    public static ResourceLocation asId(String path) {
        return new ResourceLocation(MODID, path);
    }
}