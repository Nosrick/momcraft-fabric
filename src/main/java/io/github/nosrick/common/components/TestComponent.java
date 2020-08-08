package io.github.nosrick.common.components;

import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.extension.TypeAwareComponent;
import net.minecraft.nbt.CompoundTag;

public class TestComponent implements TypeAwareComponent {
    @Override
    public ComponentType<?> getComponentType() {
        return null;
    }

    @Override
    public void fromTag(CompoundTag compoundTag) {

    }

    @Override
    public CompoundTag toTag(CompoundTag compoundTag) {
        return null;
    }
}
