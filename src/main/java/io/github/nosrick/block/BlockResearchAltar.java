package io.github.nosrick.block;

import io.github.nosrick.block.entity.BlockEntityResearchAltar;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

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
}
