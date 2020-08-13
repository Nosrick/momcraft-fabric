package io.github.nosrick.components;

import io.github.nosrick.api.interfaces.IOwnable;
import io.github.nosrick.dependency.cardinalcomponents.ModComponents;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.nbt.CompoundTag;

public class ColouredOwnableComponent implements IOwnable {

    protected String ownerUUID;
    protected int ownerColour;

    public ColouredOwnableComponent() {
        this.ownerColour = 0xFFFFFF;
        this.ownerUUID = "";
    }

    public ColouredOwnableComponent(String ownerUUID, int ownerColour) {
        this.ownerColour = ownerColour;
        this.ownerUUID = ownerUUID;
    }

    @Override
    public String getOwnerUUID() {
        return ownerUUID;
    }

    @Override
    public void setOwnerUUID(String newOwner) {
        ownerUUID = newOwner;
    }

    @Override
    public int getColour() {
        return ownerColour;
    }

    @Override
    public void setColour(int newColour) {
        ownerColour = newColour;
    }

    @Override
    public void fromTag(CompoundTag compoundTag) {
        this.ownerUUID = compoundTag.getString("ownerUUID");
        this.ownerColour = compoundTag.getInt("ownerColour");
    }

    @Override
    public CompoundTag toTag(CompoundTag compoundTag) {
        compoundTag.putString("ownerUUID", this.ownerUUID);
        compoundTag.putInt("ownerColour", this.ownerColour);
        return compoundTag;
    }

    @Override
    public boolean isComponentEqual(Component other) {
        if(other instanceof ColouredOwnableComponent)
        {
            ColouredOwnableComponent otherOwnable = (ColouredOwnableComponent)other;

            return this.ownerUUID.equals(otherOwnable.ownerUUID)
                    && this.ownerColour == otherOwnable.ownerColour;
        }

        return false;
    }

    @Override
    public ComponentType<?> getComponentType() {
        return ModComponents.OWNABLE;
    }
}
