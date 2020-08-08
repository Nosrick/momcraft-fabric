package io.github.nosrick.client.gui.screen;

import io.github.nosrick.common.gui.screenhandler.ResearchAltarScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import spinnery.client.screen.BaseHandledScreen;
import spinnery.widget.WButton;
import spinnery.widget.WInterface;
import spinnery.widget.WPanel;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;

public class ResearchAltarScreen extends BaseHandledScreen<ResearchAltarScreenHandler> {

    private final int buttonSize = 32;
    private final int gridSize = 6;
    private final int buttonPadding = 4;

    private final WInterface mainInterface;
    private final WPanel gridPanel;

    public ResearchAltarScreen(
            Text name,
            ResearchAltarScreenHandler handler,
            PlayerEntity player) {
        super(name, handler, player);

        mainInterface = getInterface();
        gridPanel = mainInterface.createChild(WPanel::new);

        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                gridPanel.createChild(
                        WButton::new,
                        Position.of(
                                i * buttonSize + buttonPadding,
                                j * buttonSize + buttonPadding,
                                0),
                        Size.of(buttonSize));
            }
        }
    }
}
