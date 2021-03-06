package io.github.nosrick;

import io.github.nosrick.dependency.cardinalcomponents.ModComponents;
import io.github.nosrick.init.ModBlockEntities;
import io.github.nosrick.init.ModBlocks;
import io.github.nosrick.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoMCraftMod implements ModInitializer {

    public static final String NAME = "Master of Magic";
    public static final String MOD_ID = "master_of_magic";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static final ItemGroup MOM_ITEMS = FabricItemGroupBuilder
            .create(new Identifier(MOD_ID, "items"))
            .icon(() -> new ItemStack(Items.BOOK))
            .build();

    private static ModBlocks modBlocks = new ModBlocks();
    private static ModBlockEntities modBlockEntities = new ModBlockEntities();
    private static ModItems modItems = new ModItems();

    @Override
    public void onInitialize() {
        ModComponents.initialise();
    }
}
