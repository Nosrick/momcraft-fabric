package io.github.nosrick.block.entity;

import io.github.nosrick.api.interfaces.IOwnable;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.Component;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import nerdhub.cardinal.components.api.component.extension.TypeAwareComponent;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BlockEntityOwnable extends BlockEntityBase implements ComponentProvider, BlockEntityClientSerializable {

    protected final List<TypeAwareComponent> components;
    protected boolean rerender;

    public BlockEntityOwnable(TypeAwareComponent ownable, BlockEntityType<?> type) {
        super(type);
        this.components = new ArrayList<>();
        this.components.add(ownable);
        rerender = false;
    }

    @Override
    public boolean hasComponent(ComponentType<?> componentType) {
        return components.stream()
                .anyMatch(component -> component.getComponentType().equals(componentType));
    }

    @Override
    public <C extends Component> C getComponent(ComponentType<C> componentType) {
        for (TypeAwareComponent component : components) {
            if (component.getComponentType() != componentType) {
                continue;
            }

            return (C) component;
        }

        return null;
    }

    public void updateClient(boolean rerender) {
        this.rerender |= rerender;
        this.sync();
    }

    @Override
    public Set<ComponentType<?>> getComponentTypes() {
        return components.stream()
                .map(component -> component.getComponentType())
                .collect(Collectors.toSet());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);

        IOwnable ownable = (IOwnable) this.components.get(0);

        ownable.setOwnerUUID(tag.getString("ownerUUID"));
        ownable.setColour(tag.getInt("ownerColour"));
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        IOwnable ownable = (IOwnable) this.components.get(0);

        tag.putString("ownerUUID", ownable.getOwnerUUID());
        tag.putInt("ownerColour", ownable.getColour());

        return tag;
    }

    @Override
    public void fromClientTag(CompoundTag compoundTag) {
        IOwnable ownable = (IOwnable) this.components.get(0);

        ownable.setColour(compoundTag.getInt("ownerColour"));
        ownable.setOwnerUUID(compoundTag.getString("ownerUUID"));
        if(compoundTag.getBoolean("rerender")) {
            this.getWorld().updateListeners(this.pos, this.getCachedState(), this.getCachedState(), 4);
        }
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        IOwnable ownable = (IOwnable) this.components.get(0);

        compoundTag.putString("ownerUUID", ownable.getOwnerUUID());
        compoundTag.putInt("ownerColour", ownable.getColour());
        compoundTag.putBoolean("rerender", this.rerender);

        this.rerender = false;

        return compoundTag;
    }
}
