package io.github.nosrick;

import io.github.nosrick.block.entity.renderer.ResearchAltarRenderer;
import io.github.nosrick.init.ModBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class MoMCraftClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(
                ModBlockEntities.BlockEntities.RESEARCH_ALTAR.blockEntity,
                ResearchAltarRenderer::new);
    }
}
