package io.github.nosrick;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoMCraftMod implements ModInitializer {

    public static final Logger logger = LogManager.getLogger();
    public static final String modId = "momcraft";

    @Override
    public void onInitialize() {
        logger.info("MoMCraft initialised!");
    }
}
