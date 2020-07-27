package io.github.nosrick.block;

import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.block.entity.BlockEntityResearchAltar;
import io.github.nosrick.dependency.cardinalcomponents.ModComponents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockResearchAltar extends BlockWithEntityBase {

    public BlockResearchAltar() {
        super(
                FabricBlockSettings.of(
                    Material.STONE,
                    MaterialColor.BLACK),
            new TranslatableText("block.momcraft.researchaltar"),
"researchaltar",
            BlockEntityResearchAltar::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return blockEntitySupplier.get();
    }

    @Override
    public ActionResult onUse(
            BlockState state,
            World world,
            BlockPos pos,
            PlayerEntity player,
            Hand hand,
            BlockHitResult hit) {

        if(!world.isClient)
        {
            BlockEntityResearchAltar blockEntity = (BlockEntityResearchAltar) world.getBlockEntity(pos);
            IOwnable ownable = blockEntity.getComponent(ModComponents.OWNABLE);
            IOwnable playerData = IOwnable.get(player);

            ownable.setOwnerUUID(playerData.getOwnerUUID());
            ownable.setColour(playerData.getColour());
            blockEntity.sync();
            blockEntity.markDirty();
        }

        return ActionResult.success(true);
    }
}
