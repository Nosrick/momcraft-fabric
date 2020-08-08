package io.github.nosrick.common.block.entity.colorprovider;

import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.common.block.entity.BlockEntityOwnable;
import io.github.nosrick.common.dependency.cardinalcomponents.ModComponents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

public class OwnableColorProvider implements BlockColorProvider {

    @Override
    public int getColor(BlockState state, BlockRenderView world, BlockPos pos, int tintIndex) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if(blockEntity instanceof BlockEntityOwnable)
        {
            BlockEntityOwnable blockEntityOwnable = (BlockEntityOwnable) blockEntity;
            IOwnable researchAltar = blockEntityOwnable.getComponent(ModComponents.OWNABLE);
            return researchAltar.getColour();
        }

        return 0xFFFFFF;
    }
}
