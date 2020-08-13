package io.github.nosrick.common.init;

import io.github.nosrick.MoMCraftMod;
import net.devtech.arrp.api.RuntimeResourcePack;

public class ModResourcePacks {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MoMCraftMod.MOD_ID + ":pack");

    public static void initialise() {
        /*
        Image image = new ImageIcon("resources/assets/textures/gui/icon_life.png").getImage();
        BufferedImage icon = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
        icon.getGraphics().drawImage(image, 0, 0, 16, 16, null);

        RESOURCE_PACK.addTexture(
                SchoolIcon.ARCANE.identifier,
                icon);

        RRPCallback.EVENT.register(t -> t.add(RESOURCE_PACK));
         */
    }
}
