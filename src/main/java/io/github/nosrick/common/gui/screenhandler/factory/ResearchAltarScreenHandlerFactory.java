package io.github.nosrick.common.gui.screenhandler.factory;

import io.github.nosrick.common.gui.screenhandler.ResearchAltarScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class ResearchAltarScreenHandlerFactory implements ExtendedScreenHandlerFactory {
    private final String translationKey;
    private final BlockPos position;

    public ResearchAltarScreenHandlerFactory(String key, BlockPos pos) {
        translationKey = key;
        position = pos;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(position);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(translationKey);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ResearchAltarScreenHandler(syncId, inv);
    }
}
