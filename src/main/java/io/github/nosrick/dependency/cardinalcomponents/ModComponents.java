package io.github.nosrick.dependency.cardinalcomponents;

import dev.onyxstudios.cca.api.v3.component.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.component.entity.EntityComponentInitializer;
import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.components.ColouredOwnableComponent;
import io.github.nosrick.components.PlayerOwnableComponent;
import io.github.nosrick.util.HexCodeUtil;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.util.EntityComponents;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ModComponents implements EntityComponentInitializer {

    public static final Identifier OWNABLE_ID = new Identifier(MoMCraftMod.MOD_ID, "ownable");
    public static final Identifier PLAYER_OWNABLE_ID = new Identifier(MoMCraftMod.MOD_ID, "player_ownable");

    public static final ComponentType<IOwnable> OWNABLE = ComponentRegistry.INSTANCE.registerStatic(
                                                            OWNABLE_ID,
                                                            IOwnable.class);

    public static void initialise() {}

    private static IOwnable createForPlayer(PlayerEntity playerEntity) {
        PlayerOwnableComponent component = new PlayerOwnableComponent(
                                                playerEntity,
                                                HexCodeUtil.generate(playerEntity.getUuid()));
        return component;
    }

    public static IOwnable createForBlockEntity() {
        return new ColouredOwnableComponent();
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry entityComponentFactoryRegistry) {
        entityComponentFactoryRegistry.registerFor(PlayerEntity.class, OWNABLE, ModComponents::createForPlayer);

        EntityComponents.setRespawnCopyStrategy(OWNABLE, RespawnCopyStrategy.ALWAYS_COPY);

        MoMCraftMod.LOGGER.info("REGISTERED COMPONENTS");
    }
}
