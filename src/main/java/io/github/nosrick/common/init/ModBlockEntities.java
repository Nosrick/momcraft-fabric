package io.github.nosrick.common.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.common.block.entity.BlockEntityBase;
import io.github.nosrick.common.block.entity.BlockEntityResearchAltar;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final BlockEntityType<BlockEntityResearchAltar> RESEARCH_ALTAR = register(
            BlockEntityResearchAltar::new,
            MoMCraftMod.identifier("research_altar"),
            ModBlocks.RESEARCH_ALTAR);

    public static void initialise() {}

    public static <T extends BlockEntityBase> BlockEntityType<T> register(
            Supplier<T> supplier,
            Identifier id,
            Block... blocks) {

        BlockEntityType.Builder<T> builder = BlockEntityType.Builder.create(supplier, blocks);
        BlockEntityType<T> blockEntityType = builder.build(null);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, id, blockEntityType);
    }
}
