package io.github.nosrick.components;

import dev.onyxstudios.cca.api.v3.util.PlayerComponent;
import io.github.nosrick.api.interfaces.IOwnable;
import nerdhub.cardinal.components.api.util.sync.EntitySyncedComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerOwnableComponent extends ColouredOwnableComponent implements EntitySyncedComponent, PlayerComponent<IOwnable> {
    protected PlayerEntity owner;

    public PlayerOwnableComponent(
            PlayerEntity owner,
            int ownerColour) {
        super(owner.getUuidAsString(), ownerColour);
        this.owner = owner;
    }

    @Override
    public void sync() {
        if (!this.getEntity().world.isClient) {
            // We only sync with the holder, not with everyone around
            this.syncWith((ServerPlayerEntity) this.getEntity());
        }
    }

    @Override
    public Entity getEntity() {
        return this.owner;
    }

    @Override
    public boolean shouldCopyForRespawn(boolean lossless, boolean keepInventory) {
        return lossless || keepInventory;
    }
}
