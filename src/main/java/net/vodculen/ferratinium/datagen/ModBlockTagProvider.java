package net.vodculen.ferratinium.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import net.vodculen.ferratinium.block.ModBlocks;

public class ModBlockTagProvider extends BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(WrapperLookup arg) {
		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.add(ModBlocks.FERRONYX_ORE)
			.add(ModBlocks.DEEPSLATE_FERRONYX_ORE)
			.add(ModBlocks.DEEPSLATE_PLATINIAM_ORE)
			.add(ModBlocks.FERRONYX_BLOCK)
			;
		
		getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
			.add(ModBlocks.FERRONYX_ORE)
			.add(ModBlocks.DEEPSLATE_FERRONYX_ORE)
			.add(ModBlocks.DEEPSLATE_PLATINIAM_ORE)	
			.add(ModBlocks.FERRONYX_BLOCK)
			;
	}

}
