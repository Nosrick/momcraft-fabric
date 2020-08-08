package io.github.nosrick.common.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.common.block.BlockBase;
import io.github.nosrick.common.block.BlockResearchAltar;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block RESEARCH_ALTAR = register(new BlockResearchAltar());

    public static void initialise() {

    }

    protected static <T extends BlockBase> T register(
            T block,
            Item.Settings settings) {
        T newBlock = Registry.register(Registry.BLOCK, block.getIdentifier(), block);
        Registry.register(Registry.ITEM, newBlock.getIdentifier(), new BlockItem(newBlock, settings));
        MoMCraftMod.LOGGER.info("REGISTERED BLOCK");
        return newBlock;
    }

    protected static <T extends BlockBase> T register(T block) {
        return register(block, new Item.Settings().group(MoMCraftMod.MOM_ITEMS));
    }
}
