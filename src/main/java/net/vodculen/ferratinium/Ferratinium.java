package net.vodculen.ferratinium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.vodculen.ferratinium.block.ModBlocks;
import net.vodculen.ferratinium.item.ModItems;
import net.vodculen.ferratinium.world.gen.ModWorldGeneration;

public class Ferratinium implements ModInitializer {
	public static final String MOD_ID = "ferratinium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();
	}
}