package net.vodculen.ferratinium.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.vodculen.ferratinium.world.ModPlacedFeatures;

public class ModOreGeneration {
		public static void generateOres() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PLATINIAM_ORE_VEIN_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.FERRONYX_ORE_VEIN_PLACED_KEY);
	}
}
