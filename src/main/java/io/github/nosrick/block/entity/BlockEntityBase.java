package io.github.nosrick.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public abstract class BlockEntityBase extends BlockEntity {
    
    public BlockEntityBase(BlockEntityType<?> type) {
        super(type);
    }
}
