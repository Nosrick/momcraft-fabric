package io.github.nosrick.components;

import dev.onyxstudios.cca.api.v3.util.PlayerComponent;
import io.github.nosrick.api.interfaces.IOwnable;
import nerdhub.cardinal.components.api.util.sync.EntitySyncedComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerOwnableComponent extends ColouredOwnableComponent implements EntitySyncedComponent, PlayerComponent<IOwnable> {
    protected PlayerEntity owner;

    public PlayerOwnableComponent(
            PlayerEntity owner,
            int ownerColour) {
        super(owner.getUuidAsString(), ownerColour);
        this.owner = owner;
    }

    @Override
    public Entity getEntity() {
        return this.owner;
    }
}
