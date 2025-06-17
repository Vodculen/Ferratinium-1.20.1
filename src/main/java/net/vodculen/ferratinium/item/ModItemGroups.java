package net.vodculen.ferratinium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vodculen.ferratinium.Ferratinium;
import net.vodculen.ferratinium.block.ModBlocks;

public class ModItemGroups {
	public static final ItemGroup FERRATINIUM_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Ferratinium.MOD_ID, "ferratinium_item_group"),
		FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FERRONYX)).displayName(Text.translatable("itemgroup.ferratinium.ferratinium_item_group"))
		.entries((displayContext, entries) -> {
			// Ferronyx block material and ore
			entries.add(ModItems.FERRONYX);
			entries.add(ModBlocks.FERRONYX_BLOCK);
			entries.add(ModBlocks.FERRONYX_STAIRS);
			entries.add(ModBlocks.FERRONYX_SLAB);
			entries.add(ModBlocks.FERRONYX_WALL);
			entries.add(ModBlocks.FERRONYX_PRESSURE_PLATE);
			entries.add(ModBlocks.FERRONYX_BUTTON);
			entries.add(ModBlocks.FERRONYX_ORE);
			entries.add(ModBlocks.DEEPSLATE_FERRONYX_ORE);

			// Ferronyx Weapons
			entries.add(ModItems.FERRONYX_SWORD);
			entries.add(ModItems.FERRONYX_AXE);
			entries.add(ModItems.FERRONYX_DAGGER);

			// Platiniam ore
			entries.add(ModItems.PLATINIAM_INGOT);
			entries.add(ModItems.RAW_PLATINIAM);
			entries.add(ModBlocks.DEEPSLATE_PLATINIAM_ORE);

			// Platiniam armor set
			entries.add(ModItems.PLATINIAM_HELMET);
			entries.add(ModItems.PLATINIAM_CHESTPLATE);
			entries.add(ModItems.PLATINIAM_LEGGINGS);
			entries.add(ModItems.PLATINIAM_BOOTS);
		}).build());


	public static void registerItemGroups() {
		Ferratinium.LOGGER.info("Registering Item Groups for " + Ferratinium.MOD_ID);
	}
}
