package io.github.nosrick.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.block.entity.BlockEntityBase;
import io.github.nosrick.block.entity.BlockEntityResearchAltar;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBlockEntities {

    public enum BlockEntities {
        RESEARCH_ALTAR(
                BlockEntityResearchAltar::new,
                new Identifier(MoMCraftMod.MOD_ID, "researchaltar"),
                ModBlocks.Blocks.RESEARCH_ALTAR.block);

        <T extends BlockEntityBase> BlockEntities(
                Supplier<T> supplier,
                Identifier id,
                Block... blocks)
        {
            BlockEntityType.Builder<T> builder = BlockEntityType.Builder.create(supplier, blocks);
            BlockEntityType<T> blockEntityType = builder.build(null);
            Registry.register(Registry.BLOCK_ENTITY_TYPE, id, blockEntityType);
            this.blockEntity = blockEntityType;
        }

        public final BlockEntityType blockEntity;
    }
}
