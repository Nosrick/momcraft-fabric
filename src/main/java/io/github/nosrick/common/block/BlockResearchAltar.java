package io.github.nosrick.common.block;

import io.github.nosrick.common.block.entity.BlockEntityResearchAltar;
import io.github.nosrick.common.components.ColouredOwnableComponent;
import io.github.nosrick.common.components.PlayerOwnableComponent;
import io.github.nosrick.common.dependency.cardinalcomponents.ModComponents;
import io.github.nosrick.common.gui.screenhandler.factory.ResearchAltarScreenHandlerFactory;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockResearchAltar extends BlockWithEntityBase {

    public BlockResearchAltar() {
        super(FabricBlockSettings.of(
                    Material.STONE,
                    MaterialColor.BLACK),
            new TranslatableText("block.master_of_magic.research_altar"),
"research_altar",
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

        if(!world.isClient) {
            BlockEntityResearchAltar blockEntity = (BlockEntityResearchAltar) world.getBlockEntity(pos);
            ColouredOwnableComponent ownable = (ColouredOwnableComponent) blockEntity.getComponent(ModComponents.OWNABLE);
            PlayerOwnableComponent playerData = (PlayerOwnableComponent) ModComponents.OWNABLE.get(ComponentProvider.fromEntity(player));

            if(ownable.getOwnerUUID().equals(playerData.getOwnerUUID())){
                player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
                return ActionResult.CONSUME;
            }
            else if(ownable.getOwnerUUID().equals("")) {
                ownable.setOwnerUUID(playerData.getOwnerUUID());
                ownable.setColour(playerData.getColour());
                blockEntity.markDirty();
                blockEntity.updateClient(true);
            }
            else {
                return ActionResult.PASS;
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new ResearchAltarScreenHandlerFactory(getTranslationKey(), pos);
    }


}
