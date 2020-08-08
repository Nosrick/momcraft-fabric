package io.github.nosrick.common.gui.screenhandler;

import io.github.nosrick.common.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerType;
import spinnery.common.handler.BaseScreenHandler;

public class ResearchAltarScreenHandler extends BaseScreenHandler {

    public ResearchAltarScreenHandler(int synchronizationID, PlayerInventory playerInventory) {
        super(synchronizationID, playerInventory);
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return ModScreenHandlers.RESEARCH_ALTAR;
    }


}
