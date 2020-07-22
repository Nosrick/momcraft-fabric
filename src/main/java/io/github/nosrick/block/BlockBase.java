package io.github.nosrick.block;

import io.github.nosrick.MoMCraftMod;
import net.minecraft.block.Block;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class BlockBase extends Block {

    protected final Text localisedName;
    protected final Identifier internalName;

    public BlockBase(
            Settings settings,
            Text localisedName,
            String internalName) {
        super(settings);
        this.localisedName = localisedName;
        this.internalName = new Identifier(
                MoMCraftMod.MOD_ID,
                internalName);
    }

    public Identifier getIdentifier() {
        return internalName;
    }
}
