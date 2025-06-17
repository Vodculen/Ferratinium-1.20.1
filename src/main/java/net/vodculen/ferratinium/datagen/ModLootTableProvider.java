package net.vodculen.ferratinium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.vodculen.ferratinium.block.ModBlocks;
import net.vodculen.ferratinium.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ModBlocks.FERRONYX_ORE, ModItems.FERRONYX);
		addDrop(ModBlocks.DEEPSLATE_FERRONYX_ORE, ModItems.FERRONYX);
		addDrop(ModBlocks.DEEPSLATE_PLATINIAM_ORE, ModItems.RAW_PLATINIAM);
		addDrop(ModBlocks.FERRONYX_BLOCK);
		addDrop(ModBlocks.FERRONYX_STAIRS);
		addDrop(ModBlocks.FERRONYX_SLAB);
		addDrop(ModBlocks.FERRONYX_WALL);
		addDrop(ModBlocks.FERRONYX_PRESSURE_PLATE);
		addDrop(ModBlocks.FERRONYX_BUTTON, slabDrops(ModBlocks.FERRONYX_SLAB));
	}

}
