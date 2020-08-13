package io.github.nosrick.dependency.cardinalcomponents;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.components.ColouredOwnableComponent;
import io.github.nosrick.components.PlayerOwnableComponent;
import io.github.nosrick.util.HexCodeUtil;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.event.EntityComponentCallback;
import nerdhub.cardinal.components.api.util.EntityComponents;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ModComponents {

    public static final Identifier OWNABLE_ID = new Identifier(MoMCraftMod.MOD_ID, "ownable");
    public static final Identifier PLAYER_OWNABLE_ID = new Identifier(MoMCraftMod.MOD_ID, "player_ownable");

    public static final ComponentType<IOwnable> OWNABLE = ComponentRegistry.INSTANCE.registerIfAbsent(
                                                            OWNABLE_ID,
                                                            IOwnable.class);

    public static void initialise() {
        EntityComponentCallback.event(PlayerEntity.class).register(
                (player, components) -> components.put(OWNABLE, createForPlayer(player)));

        EntityComponents.setRespawnCopyStrategy(OWNABLE, RespawnCopyStrategy.ALWAYS_COPY);
    }

    private static IOwnable createForPlayer(PlayerEntity playerEntity) {
        PlayerOwnableComponent component = new PlayerOwnableComponent(
                                                playerEntity,
                                                HexCodeUtil.generate(playerEntity.getUuid()));
        return component;
    }

    public static IOwnable createForBlockEntity() {
        return new ColouredOwnableComponent();
    }
}
