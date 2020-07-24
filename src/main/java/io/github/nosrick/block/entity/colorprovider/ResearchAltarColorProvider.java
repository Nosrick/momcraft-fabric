package io.github.nosrick.block.entity.colorprovider;

import io.github.nosrick.block.entity.BlockEntityResearchAltar;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

public class ResearchAltarColorProvider implements BlockColorProvider {

    @Override
    public int getColor(BlockState state, BlockRenderView world, BlockPos pos, int tintIndex) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if(blockEntity instanceof BlockEntityResearchAltar)
        {
            BlockEntityResearchAltar researchAltar = (BlockEntityResearchAltar)blockEntity;
            return researchAltar.getColour();
        }

        return 0xFFFFFF;
    }
}
