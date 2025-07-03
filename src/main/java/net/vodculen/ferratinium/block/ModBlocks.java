package net.vodculen.ferratinium.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.vodculen.ferratinium.Ferratinium;

public class ModBlocks {
	// Ore blocks 
	public static final Block FERRONYX_ORE = registerBlock("ferronyx_ore", 
		new Block(AbstractBlock.Settings.create().strength(3.0F, 3.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
	public static final Block DEEPSLATE_FERRONYX_ORE = registerBlock("deepslate_ferronyx_ore", 
		new Block(AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
	public static final Block PLATINIAM_ORE = registerBlock("platiniam_ore", 
		new Block(AbstractBlock.Settings.create().strength(3.0F, 3.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
	public static final Block DEEPSLATE_PLATINIAM_ORE = registerBlock("deepslate_platiniam_ore", 
		new Block(AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


	// Material Blocks
	public static final Block FERRONYX_BLOCK = registerBlock("ferronyx_block", 
		new Block(AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.METAL)));
	public static final Block FERRONYX_STAIRS = registerBlock("ferronyx_stairs", 
		new StairsBlock(ModBlocks.FERRONYX_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.METAL)));
	public static final Block FERRONYX_SLAB = registerBlock("ferronyx_slab", 
		new SlabBlock(AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.METAL)));
	public static final Block FERRONYX_PRESSURE_PLATE = registerBlock("ferronyx_pressure_plate", 
		new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.METAL), BlockSetType.IRON));
	public static final Block FERRONYX_BUTTON = registerBlock("ferronyx_button", 
		new ButtonBlock(AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.METAL), BlockSetType.IRON, 10, false));
	public static final Block FERRONYX_WALL = registerBlock("ferronyx_wall", 
		new WallBlock(AbstractBlock.Settings.create().strength(4.5F, 3.0F).requiresTool().sounds(BlockSoundGroup.METAL)));
	

	// Helper classes
	private static Block registerBlock(String name, Block block) {
		registerModBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(Ferratinium.MOD_ID, name), block);
	}

	private static void registerModBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(Ferratinium.MOD_ID, name), new BlockItem(block, new Item.Settings()));
	}

	public static void registerModBlocks() {
		Ferratinium.LOGGER.info("Registering Modded Block");

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::natrualBlocksItemGroup);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::buildingBlocksItemGroup);
	}

	private static void natrualBlocksItemGroup(FabricItemGroupEntries entries) {
		entries.addAfter(Blocks.DEEPSLATE_EMERALD_ORE, ModBlocks.FERRONYX_ORE);
		entries.addAfter(ModBlocks.FERRONYX_ORE, ModBlocks.DEEPSLATE_FERRONYX_ORE);
		entries.addAfter(ModBlocks.DEEPSLATE_FERRONYX_ORE, ModBlocks.PLATINIAM_ORE);
		entries.addAfter(ModBlocks.PLATINIAM_ORE, ModBlocks.DEEPSLATE_PLATINIAM_ORE);
	}

	private static void buildingBlocksItemGroup(FabricItemGroupEntries entries) {
		entries.add(ModBlocks.FERRONYX_BLOCK);
		entries.add(ModBlocks.FERRONYX_STAIRS);
		entries.add(ModBlocks.FERRONYX_SLAB);
		entries.add(ModBlocks.FERRONYX_WALL);
		entries.add(ModBlocks.FERRONYX_PRESSURE_PLATE);
		entries.add(ModBlocks.FERRONYX_BUTTON);
	}
}
