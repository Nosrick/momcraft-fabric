package io.github.nosrick.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.block.BlockBase;
import io.github.nosrick.block.BlockResearchAltar;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    private static final Blocks[] BLOCKS = Blocks.values();

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

    public enum Blocks implements ItemConvertible {
        RESEARCH_ALTAR(new BlockResearchAltar());

        public final BlockBase block;

        <B extends BlockBase> Blocks(B block)
        {
            this.block = block;
            register(
                    this.block,
                    new Item.Settings()
                        .group(MoMCraftMod.MOM_ITEMS));
        }

        public ItemStack getItemStack() {
            return new ItemStack(block);
        }

        @Override
        public Item asItem() {
            return block.asItem();
        }
    }
}
