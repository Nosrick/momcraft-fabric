package io.github.nosrick.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;

public abstract class BlockWithEntityBase extends BlockBase implements BlockEntityProvider {

    Supplier<BlockEntity> blockEntitySupplier;

    public BlockWithEntityBase(
            Settings settings,
            Text localisedName,
            String internalName,
            Supplier<BlockEntity> blockEntitySupplier) {
        super(settings, localisedName, internalName);
        this.blockEntitySupplier = blockEntitySupplier;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView worldIn) {
        if(blockEntitySupplier == null) {
            return null;
        }

        return blockEntitySupplier.get();
    }
}
