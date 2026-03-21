package de.pnku.mcbv.init;

import de.pnku.mcbv.MoreChiseledBookshelfVariants;
import de.pnku.mcbv.block.MoreChiseledBookShelfBlock;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static de.pnku.mcbv.init.McbvBlockInit.*;

public class McbvItemInit {
    public static final BlockItem SPRUCE_CHISELED_BOOKSHELF_I = itemFromBlock(SPRUCE_CHISELED_BOOKSHELF);
    public static final BlockItem BIRCH_CHISELED_BOOKSHELF_I = itemFromBlock(BIRCH_CHISELED_BOOKSHELF);
    public static final BlockItem JUNGLE_CHISELED_BOOKSHELF_I = itemFromBlock(JUNGLE_CHISELED_BOOKSHELF);
    public static final BlockItem ACACIA_CHISELED_BOOKSHELF_I = itemFromBlock(ACACIA_CHISELED_BOOKSHELF);
    public static final BlockItem DARK_OAK_CHISELED_BOOKSHELF_I = itemFromBlock(DARK_OAK_CHISELED_BOOKSHELF);
    public static final BlockItem PALE_OAK_CHISELED_BOOKSHELF_I = itemFromBlock(PALE_OAK_CHISELED_BOOKSHELF);
    public static final BlockItem MANGROVE_CHISELED_BOOKSHELF_I = itemFromBlock(MANGROVE_CHISELED_BOOKSHELF);
    public static final BlockItem CHERRY_CHISELED_BOOKSHELF_I = itemFromBlock(CHERRY_CHISELED_BOOKSHELF);
    public static final BlockItem BAMBOO_CHISELED_BOOKSHELF_I = itemFromBlock(BAMBOO_CHISELED_BOOKSHELF);
    public static final BlockItem CRIMSON_CHISELED_BOOKSHELF_I = itemFromBlock(CRIMSON_CHISELED_BOOKSHELF);
    public static final BlockItem WARPED_CHISELED_BOOKSHELF_I = itemFromBlock(WARPED_CHISELED_BOOKSHELF);

    public static BlockItem itemFromBlock(MoreChiseledBookShelfBlock moreChiseledBookShelfBlock) {
        return new BlockItem(moreChiseledBookShelfBlock, setProperties(moreChiseledBookShelfBlock));
    }

    public static Item.Properties setProperties(MoreChiseledBookShelfBlock moreChiseledBookShelfBlock) {
        return new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM,BuiltInRegistries.BLOCK.getKey(moreChiseledBookShelfBlock))).useBlockDescriptionPrefix();
    }

    public static void registerItems() {
        registerItem(SPRUCE_CHISELED_BOOKSHELF_I, Items.CHISELED_BOOKSHELF);
        registerItem(BIRCH_CHISELED_BOOKSHELF_I, SPRUCE_CHISELED_BOOKSHELF_I);
        registerItem(JUNGLE_CHISELED_BOOKSHELF_I, BIRCH_CHISELED_BOOKSHELF_I);
        registerItem(ACACIA_CHISELED_BOOKSHELF_I, JUNGLE_CHISELED_BOOKSHELF_I);
        registerItem(DARK_OAK_CHISELED_BOOKSHELF_I, ACACIA_CHISELED_BOOKSHELF_I);
        registerItem(PALE_OAK_CHISELED_BOOKSHELF_I, DARK_OAK_CHISELED_BOOKSHELF_I);
        registerItem(MANGROVE_CHISELED_BOOKSHELF_I, PALE_OAK_CHISELED_BOOKSHELF_I);
        registerItem(CHERRY_CHISELED_BOOKSHELF_I, MANGROVE_CHISELED_BOOKSHELF_I);
        registerItem(BAMBOO_CHISELED_BOOKSHELF_I, CHERRY_CHISELED_BOOKSHELF_I);
        registerItem(CRIMSON_CHISELED_BOOKSHELF_I, BAMBOO_CHISELED_BOOKSHELF_I);
        registerItem(WARPED_CHISELED_BOOKSHELF_I, CRIMSON_CHISELED_BOOKSHELF_I);
    }

    private static void registerItem(BlockItem chiseled_bookshelf, Item chiseled_bookshelfAfter) {
        Registry.register(BuiltInRegistries.ITEM, MoreChiseledBookshelfVariants.asId(((MoreChiseledBookShelfBlock) chiseled_bookshelf.getBlock()).chiseledBookshelfWoodType + "_chiseled_bookshelf"), chiseled_bookshelf);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.insertAfter(chiseled_bookshelfAfter, chiseled_bookshelf));
    }
}