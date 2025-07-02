package net.vodculen.ferratinium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.util.Identifier;
import net.vodculen.ferratinium.Ferratinium;
import net.vodculen.ferratinium.item.armor.ModArmorMaterials;
import net.vodculen.ferratinium.item.tool.ModToolMaterials;
import net.vodculen.ferratinium.item.weapon.DaggerItem;

public class ModItems {
	// The material you can get from ores
	public static final Item FERRONYX = registerItem("ferronyx", new Item(new Item.Settings()));
	public static final Item ENERGIZED_FERRONYX = registerItem("energized_ferronyx", new Item(new Item.Settings()));
	public static final Item ENERGIZED_FERRONYX_INGOT = registerItem("energized_ferronyx_ingot", new Item(new Item.Settings()));
	public static final Item ENERGIZED_FERRONYX_POWDER = registerItem("energized_ferronyx_powder", new Item(new Item.Settings()));
	public static final Item CRYSTALLIZED_FERRATINIUM_INGOT = registerItem("crystallized_ferratinium_ingot", new Item(new Item.Settings()));
	public static final Item PLATINIAM_INGOT = registerItem("platiniam_ingot", new Item(new Item.Settings()));
	public static final Item RAW_PLATINIAM = registerItem("raw_platiniam", new Item(new Item.Settings()));

	// These are the weapons
	public static final Item FERRONYX_SWORD = registerItem("ferronyx_sword", new SwordItem(ModToolMaterials.FERRONYX_MATERIAL, 3, -2.4F, new FabricItemSettings()));
	public static final Item FERRONYX_AXE = registerItem("ferronyx_axe", new AxeItem(ModToolMaterials.FERRONYX_MATERIAL, 5.5F, -3F, new FabricItemSettings()));
	public static final Item FERRONYX_DAGGER = registerItem("ferronyx_dagger", new DaggerItem(new Item.Settings()));
	public static final Item FERRATINIUM_SWORD = registerItem("ferronyx_sword", new SwordItem(ModToolMaterials.FERRATINIUM_MATERIAL, 3, -2.4F, new FabricItemSettings()));
	public static final Item FERRATINIUM_AXE = registerItem("ferronyx_axe", new AxeItem(ModToolMaterials.FERRATINIUM_MATERIAL, 5.5F, -3F, new FabricItemSettings()));
	public static final Item FERRATINIUM_DAGGER = registerItem("ferronyx_dagger", new DaggerItem(new Item.Settings()));


	// These are the armor
	public static final Item FERRATINIUM_HELMET = registerItem("ferratinium_helmet",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.HELMET, new FabricItemSettings()));
	public static final Item FERRATINIUM_CHESTPLATE = registerItem("ferratinium_chestplate",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
	public static final Item FERRATINIUM_LEGGINGS = registerItem("ferratinium_leggings",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
	public static final Item FERRATINIUM_BOOTS = registerItem("ferratinium_boots",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

	public static final Item PLATINIAM_HELMET = registerItem("platiniam_helmet",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.HELMET, new FabricItemSettings()));
	public static final Item PLATINIAM_CHESTPLATE = registerItem("platiniam_chestplate",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
	public static final Item PLATINIAM_LEGGINGS = registerItem("platiniam_leggings",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
	public static final Item PLATINIAM_BOOTS = registerItem("platiniam_boots",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


	// Helper classes
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(Ferratinium.MOD_ID, name), item);
	}

	public static void registerModItems() {
		Ferratinium.LOGGER.info("Registering Modded Items");
	}

	
}
