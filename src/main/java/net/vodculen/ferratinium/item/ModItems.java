package net.vodculen.ferratinium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vodculen.ferratinium.Ferratinium;
import net.vodculen.ferratinium.item.armor.ModArmorMaterials;
import net.vodculen.ferratinium.item.armor.WaterTransformableArmorItem;
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
	
	public static final Item FERRATINIUM_SWORD = registerItem("ferratinium_sword", new SwordItem(ModToolMaterials.FERRATINIUM_MATERIAL, 3, -2.4F, new FabricItemSettings()));
	public static final Item FERRATINIUM_AXE = registerItem("ferratinium_axe", new AxeItem(ModToolMaterials.FERRATINIUM_MATERIAL, 5.5F, -3F, new FabricItemSettings()));
	public static final Item FERRATINIUM_DAGGER = registerItem("ferratinium_dagger", new DaggerItem(new Item.Settings()));


	// These are the armor
	public static final Item PLATINIAM_HELMET = registerItem("platiniam_helmet",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.HELMET, new FabricItemSettings()));
	public static final Item PLATINIAM_CHESTPLATE = registerItem("platiniam_chestplate",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
	public static final Item PLATINIAM_LEGGINGS = registerItem("platiniam_leggings",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
	public static final Item PLATINIAM_BOOTS = registerItem("platiniam_boots",
		new ArmorItem(ModArmorMaterials.PLATINIAM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

	public static final Item FERRATINIUM_HELMET = registerItem("ferratinium_helmet",
		new WaterTransformableArmorItem(ModArmorMaterials.FERRATINIUM, ArmorItem.Type.HELMET, new FabricItemSettings(), ModItems.PLATINIAM_HELMET));
	public static final Item FERRATINIUM_CHESTPLATE = registerItem("ferratinium_chestplate",
		new WaterTransformableArmorItem(ModArmorMaterials.FERRATINIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings(), ModItems.PLATINIAM_CHESTPLATE));
	public static final Item FERRATINIUM_LEGGINGS = registerItem("ferratinium_leggings",
		new WaterTransformableArmorItem(ModArmorMaterials.FERRATINIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings(), ModItems.PLATINIAM_LEGGINGS));
	public static final Item FERRATINIUM_BOOTS = registerItem("ferratinium_boots",
		new WaterTransformableArmorItem(ModArmorMaterials.FERRATINIUM, ArmorItem.Type.BOOTS, new FabricItemSettings(), ModItems.PLATINIAM_BOOTS));


	// Helper classes
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(Ferratinium.MOD_ID, name), item);
	}

	public static void registerModItems() {
		Ferratinium.LOGGER.info("Registering Modded Items");

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::combatItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::ingredientsItemGroup);
	}

	// Item Groups
	private static void combatItemGroup(FabricItemGroupEntries entires) {
		// Weapons 
		entires.addAfter(Items.GOLDEN_SWORD, ModItems.FERRONYX_SWORD);
		entires.addAfter(Items.NETHERITE_SWORD, ModItems.FERRATINIUM_SWORD);
		entires.addAfter(Items.GOLDEN_AXE, ModItems.FERRONYX_AXE);
		entires.addAfter(Items.NETHERITE_AXE, ModItems.FERRATINIUM_AXE);
		entires.addAfter(ModItems.FERRATINIUM_AXE, ModItems.FERRONYX_DAGGER);
		entires.addAfter(ModItems.FERRONYX_DAGGER, ModItems.FERRATINIUM_DAGGER);

		// Armor
		entires.addAfter(Items.GOLDEN_BOOTS, ModItems.PLATINIAM_HELMET);
		entires.addAfter(ModItems.PLATINIAM_HELMET, ModItems.PLATINIAM_CHESTPLATE);
		entires.addAfter(ModItems.PLATINIAM_CHESTPLATE, ModItems.PLATINIAM_LEGGINGS);
		entires.addAfter(ModItems.PLATINIAM_LEGGINGS, ModItems.PLATINIAM_BOOTS);
		entires.addAfter(Items.NETHERITE_BOOTS, ModItems.FERRATINIUM_HELMET);
		entires.addAfter(ModItems.FERRATINIUM_HELMET, ModItems.FERRATINIUM_CHESTPLATE);
		entires.addAfter(ModItems.FERRATINIUM_CHESTPLATE, ModItems.FERRATINIUM_LEGGINGS);
		entires.addAfter(ModItems.FERRATINIUM_LEGGINGS, ModItems.FERRATINIUM_BOOTS);
	}

	private static void ingredientsItemGroup(FabricItemGroupEntries entires) {
		entires.addAfter(Items.RAW_GOLD, ModItems.RAW_PLATINIAM);
		entires.addAfter(Items.GOLD_INGOT, ModItems.PLATINIAM_INGOT);
		entires.addAfter(Items.AMETHYST_SHARD, ModItems.FERRONYX);
		entires.addAfter(ModItems.FERRONYX, ModItems.ENERGIZED_FERRONYX_INGOT);
		entires.addAfter(ModItems.ENERGIZED_FERRONYX_INGOT, ModItems.ENERGIZED_FERRONYX_POWDER);
		entires.addAfter(Items.NETHERITE_INGOT, ModItems.CRYSTALLIZED_FERRATINIUM_INGOT); 	
	}
}
