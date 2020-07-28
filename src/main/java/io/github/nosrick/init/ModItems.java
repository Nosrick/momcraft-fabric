package io.github.nosrick.init;

import io.github.nosrick.MoMCraftMod;
import io.github.nosrick.item.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class ModItems {

    private final Items[] items = Items.values();

    public static <I extends ItemBase> I register(I item) {
        return Registry.register(Registry.ITEM, item.getIdentifier(), item);
    }

    public enum Items {
        WOODEN_WAND(new ItemBase(
                new Item.Settings().group(MoMCraftMod.MOM_ITEMS),
                new TranslatableText("item.master_of_magic.wooden_wand"),
                "wooden_wand"));

        public final ItemBase item;

        <I extends ItemBase> Items(ItemBase item) {
            this.item = item;

            register(this.item);
        }
    }
}
