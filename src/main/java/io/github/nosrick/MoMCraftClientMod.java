package io.github.nosrick;

import io.github.nosrick.block.entity.colorprovider.OwnableColorProvider;
import io.github.nosrick.block.entity.renderer.ResearchAltarRenderer;
import io.github.nosrick.init.ModBlockEntities;
import io.github.nosrick.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class MoMCraftClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(
                ModBlockEntities.BlockEntities.RESEARCH_ALTAR.blockEntity,
                ResearchAltarRenderer::new);

        ColorProviderRegistry.BLOCK.register(
                new OwnableColorProvider(),
                ModBlocks.Blocks.RESEARCH_ALTAR.block);
    }
}
