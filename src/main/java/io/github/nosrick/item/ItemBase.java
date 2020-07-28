package io.github.nosrick.item;

import io.github.nosrick.MoMCraftMod;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemBase extends Item {

    protected final Text localisedName;
    protected final Identifier identifier;

    public ItemBase(
            Settings settings,
            Text localisedName,
            String internalName) {
        super(settings);

        this.localisedName = localisedName;
        this.identifier = new Identifier(MoMCraftMod.MOD_ID, internalName);
    }

    public Text getLocalisedName() {
        return this.localisedName;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }
}
