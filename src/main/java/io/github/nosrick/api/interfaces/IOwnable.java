package io.github.nosrick.api.interfaces;

import io.github.nosrick.dependency.cardinalcomponents.ModComponents;
import nerdhub.cardinal.components.api.component.extension.TypeAwareComponent;

public interface IOwnable extends TypeAwareComponent {

    static <T> IOwnable get(T provider) {
        return ModComponents.OWNABLE.get(provider);
    }

    String getOwnerUUID();
    void setOwnerUUID(String newOwner);

    int getColour();
    void setColour(int newColour);
}
