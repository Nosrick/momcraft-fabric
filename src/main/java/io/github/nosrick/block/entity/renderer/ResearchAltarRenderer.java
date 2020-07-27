package io.github.nosrick.block.entity.renderer;

import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.block.entity.BlockEntityResearchAltar;
import io.github.nosrick.dependency.cardinalcomponents.ModComponents;
import io.github.nosrick.util.HexCodeUtil;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.awt.*;

public class ResearchAltarRenderer extends BlockEntityRenderer<BlockEntityResearchAltar> {

    protected static final SpriteIdentifier BOOK_SPRITE = new SpriteIdentifier(
                                                                SpriteAtlasTexture.BLOCK_ATLAS_TEX,
                                                                new Identifier("entity/enchanting_table_book"));
    protected final BookModel bookModel = new BookModel();

    public ResearchAltarRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(BlockEntityResearchAltar entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
            matrices.translate(0.5d, 0.75d, 0.5d);

            float g = (float)entity.ticks + tickDelta;
            matrices.translate(0.0D, 0.1F + MathHelper.sin(g * 0.1F) * 0.01F, 0.0D);

            float h;
            for(h = entity.field_11964 - entity.field_11963; h >= 3.1415927F; h -= 6.2831855F) {
            }

            while(h < -3.1415927F) {
                h += 6.2831855F;
            }

            float k = entity.field_11963 + h * tickDelta;
            matrices.multiply(Vector3f.POSITIVE_Y.getRadialQuaternion(-k));
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(80.0F));
            float l = MathHelper.lerp(tickDelta, entity.pageAngle, entity.nextPageAngle);
            float m = MathHelper.fractionalPart(l + 0.25F) * 1.6F - 0.3F;
            float n = MathHelper.fractionalPart(l + 0.75F) * 1.6F - 0.3F;
            float o = MathHelper.lerp(tickDelta, entity.pageTurningSpeed, entity.nextPageTurningSpeed);
            this.bookModel.setPageAngles(g, MathHelper.clamp(m, 0.0F, 1.0F), MathHelper.clamp(n, 0.0F, 1.0F), o);

            VertexConsumer vertexConsumer = BOOK_SPRITE.getVertexConsumer(
                                                            vertexConsumers,
                                                            RenderLayer::getEntitySolid);

            int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
            bookModel.render(
                    matrices,
                    vertexConsumer,
                    lightAbove,
                    overlay,
                    1.0f,
                    1.0f,
                    1.0f,
                    1.0f);
        matrices.pop();

        IOwnable ownable = entity.getComponent(ModComponents.OWNABLE);
        Color colour = HexCodeUtil.getCodeAsColor(ownable.getColour());
    }
}
