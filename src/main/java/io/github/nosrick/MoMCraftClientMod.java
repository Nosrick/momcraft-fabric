package io.github.nosrick;

import io.github.nosrick.client.init.ModScreens;
import io.github.nosrick.common.block.entity.colorprovider.OwnableColorProvider;
import io.github.nosrick.common.block.entity.renderer.ResearchAltarRenderer;
import io.github.nosrick.common.init.ModBlockEntities;
import io.github.nosrick.common.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class MoMCraftClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModScreens.initialise();

        BlockEntityRendererRegistry.INSTANCE.register(
                ModBlockEntities.RESEARCH_ALTAR,
                ResearchAltarRenderer::new);

        ColorProviderRegistry.BLOCK.register(
                new OwnableColorProvider(),
                ModBlocks.RESEARCH_ALTAR);
    }
}
