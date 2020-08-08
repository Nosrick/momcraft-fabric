package io.github.nosrick.client.init;

import io.github.nosrick.client.gui.screen.ResearchAltarScreen;
import io.github.nosrick.common.gui.screenhandler.ResearchAltarScreenHandler;
import io.github.nosrick.common.init.ModScreenHandlers;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ModScreens {

    public static void initialise() {
        ScreenRegistry.<ResearchAltarScreenHandler, ResearchAltarScreen>register(
                ModScreenHandlers.RESEARCH_ALTAR,
                ((gui, inventory, title) -> new ResearchAltarScreen(title, gui, inventory.player)));
    }

}
