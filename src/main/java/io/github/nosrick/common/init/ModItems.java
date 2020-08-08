package io.github.nosrick.common.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.common.item.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WOODEN_WAND = register(new ItemBase(
            new Item.Settings().group(MoMCraftMod.MOM_ITEMS),
            new TranslatableText("item.master_of_magic.wooden_wand"),
            "wooden_wand"));

    public static <I extends ItemBase> I register(I item) {
        return Registry.register(Registry.ITEM, item.getIdentifier(), item);
    }

    public static void initialise() {}
}
