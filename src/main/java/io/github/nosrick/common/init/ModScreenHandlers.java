package io.github.nosrick.common.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.common.gui.screenhandler.ResearchAltarScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ResearchAltarScreenHandler> RESEARCH_ALTAR =
            ScreenHandlerRegistry.registerExtended(
                MoMCraftMod.identifier("research_altar"),
                (synchronizationID, inventory, buffer) -> new ResearchAltarScreenHandler(synchronizationID, inventory));

    public static void initialise() {

    }
}
