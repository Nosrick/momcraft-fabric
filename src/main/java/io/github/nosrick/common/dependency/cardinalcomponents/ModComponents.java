package io.github.nosrick.common.dependency.cardinalcomponents;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.component.entity.EntityComponentInitializer;
import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.common.components.ColouredOwnableComponent;
import io.github.nosrick.common.components.PlayerOwnableComponent;
import io.github.nosrick.common.util.HexCodeUtil;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.event.EntityComponentCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModComponents implements EntityComponentInitializer {

    public static final List<ComponentType> COMPONENTS = getComponents();

    public static final Identifier OWNABLE_ID = new Identifier(MoMCraftMod.MOD_ID, "ownable");
    public static final Identifier PLAYER_OWNABLE_ID = new Identifier(MoMCraftMod.MOD_ID, "player_ownable");

    public static final ComponentType<IOwnable> OWNABLE = ComponentRegistry.INSTANCE.registerIfAbsent(
                                                            OWNABLE_ID,
                                                            IOwnable.class);

    public static final ComponentKey<IOwnable> PLAYER_OWNABLE = ComponentRegistry.INSTANCE.registerStatic(
                                                            PLAYER_OWNABLE_ID,
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

    private static List<ComponentType> getComponents() {
        List<ComponentType> components = new ArrayList<>();
        components.add(OWNABLE);
        return components;
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry entityComponentFactoryRegistry) {
        //entityComponentFactoryRegistry.registerFor(PlayerEntity.class, OWNABLE, ModComponents::createForPlayer);

        EntityComponentCallback.event(PlayerEntity.class).register((player, components) ->
                components.put((ComponentType<IOwnable>) PLAYER_OWNABLE, createForPlayer(player)));

        //EntityComponents.setRespawnCopyStrategy(PLAYER_OWNABLE, RespawnCopyStrategy.ALWAYS_COPY);

        MoMCraftMod.LOGGER.info("REGISTERED COMPONENTS");
    }
}
