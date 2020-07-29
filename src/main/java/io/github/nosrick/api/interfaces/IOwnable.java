package io.github.nosrick.api.interfaces;

import nerdhub.cardinal.components.api.component.extension.TypeAwareComponent;

public interface IOwnable extends TypeAwareComponent {

    String getOwnerUUID();
    void setOwnerUUID(String newOwner);

    int getColour();
    void setColour(int newColour);
}
