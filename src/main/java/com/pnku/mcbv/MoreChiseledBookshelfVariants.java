package com.pnku.mcbv;

import com.pnku.mcbv.init.McbvBlockInit;
import com.pnku.mcbv.init.McbvItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class MoreChiseledBookshelfVariants implements ModInitializer {
    public static final String MODID = "lolmcbv";

    @Override
    public void onInitialize() {
        McbvBlockInit.registerBlocks();
        McbvItemInit.registerItems();
    }

    public static Identifier asId(String path) {
        return new Identifier(MODID, path);
    }
}