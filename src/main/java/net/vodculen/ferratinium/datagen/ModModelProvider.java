package net.vodculen.ferratinium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.vodculen.ferratinium.block.ModBlocks;
import net.vodculen.ferratinium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FERRONYX_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FERRONYX_ORE);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PLATINIAM_ORE);

		// Ferronyx Block Materials
		BlockStateModelGenerator.BlockTexturePool ferronyxPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FERRONYX_BLOCK);
		ferronyxPool.stairs(ModBlocks.FERRONYX_STAIRS);
		ferronyxPool.slab(ModBlocks.FERRONYX_SLAB);
		ferronyxPool.wall(ModBlocks.FERRONYX_WALL);
		ferronyxPool.pressurePlate(ModBlocks.FERRONYX_PRESSURE_PLATE);
		ferronyxPool.button(ModBlocks.FERRONYX_BUTTON);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.FERRONYX, Models.GENERATED);
		itemModelGenerator.register(ModItems.FERRONYX_SWORD, Models.HANDHELD);
		itemModelGenerator.register(ModItems.FERRONYX_AXE, Models.HANDHELD);
		itemModelGenerator.register(ModItems.RAW_PLATINIAM, Models.GENERATED);
		itemModelGenerator.register(ModItems.PLATINIAM_INGOT, Models.GENERATED);
		itemModelGenerator.register(ModItems.FERRONYX_DAGGER, Models.HANDHELD);

		itemModelGenerator.registerArmor(((ArmorItem) ModItems.PLATINIAM_HELMET));
		itemModelGenerator.registerArmor(((ArmorItem) ModItems.PLATINIAM_CHESTPLATE));
		itemModelGenerator.registerArmor(((ArmorItem) ModItems.PLATINIAM_LEGGINGS));
		itemModelGenerator.registerArmor(((ArmorItem) ModItems.PLATINIAM_BOOTS));
	}

}
