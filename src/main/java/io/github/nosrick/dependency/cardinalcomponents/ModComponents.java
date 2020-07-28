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

import java.util.ArrayList;
import java.util.List;

public class ModComponents implements EntityComponentInitializer {

    public static final List<ComponentType> COMPONENTS = getComponents();

    public static final ComponentType<IOwnable> OWNABLE = ComponentRegistry.INSTANCE.registerIfAbsent(
                                                            new Identifier(MoMCraftMod.MOD_ID, "ownable"),
                                                            IOwnable.class);

    public ModComponents() {
    }

    private static IOwnable createForPlayer(PlayerEntity playerEntity) {
        return new PlayerOwnableComponent(playerEntity, HexCodeUtil.generate(playerEntity.getUuid()));
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
        entityComponentFactoryRegistry.registerFor(PlayerEntity.class, OWNABLE, ModComponents::createForPlayer);

        EntityComponents.setRespawnCopyStrategy(OWNABLE, RespawnCopyStrategy.ALWAYS_COPY);

        MoMCraftMod.LOGGER.info("REGISTERED COMPONENTS");
    }
}
