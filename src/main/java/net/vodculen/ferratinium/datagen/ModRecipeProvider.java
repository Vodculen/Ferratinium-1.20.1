package net.vodculen.ferratinium.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.vodculen.ferratinium.block.ModBlocks;
import net.vodculen.ferratinium.item.ModItems;

public class ModRecipeProvider extends FabricRecipeProvider {
	private static final List<ItemConvertible> PLATINIAM = List.of(ModItems.RAW_PLATINIAM);
	private static final List<ItemConvertible> ENERGIZED_FERRONYX = List.of(ModItems.ENERGIZED_FERRONYX);

	public ModRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FERRONYX, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRONYX_BLOCK);

		offerBlasting(exporter, PLATINIAM, RecipeCategory.MISC, ModItems.PLATINIAM_INGOT, 10, 100, "platiniam");
		offerSmelting(exporter, PLATINIAM, RecipeCategory.MISC, ModItems.PLATINIAM_INGOT, 5, 200, "platiniam");
		offerBlasting(exporter, ENERGIZED_FERRONYX, RecipeCategory.MISC, ModItems.ENERGIZED_FERRONYX_INGOT, 10, 200, "energized_ferronyx");

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRONYX_SWORD)
			.pattern(" # ")
			.pattern(" # ")
			.pattern(" | ")
			.input('#', ModItems.FERRONYX)
			.input('|', Items.STICK)
			.criterion(hasItem(ModItems.FERRONYX), conditionsFromItem(ModItems.FERRONYX))
			.offerTo(exporter)
			;
		
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRONYX_AXE)
			.pattern(" ##")
			.pattern(" |#")
			.pattern(" | ")
			.input('#', ModItems.FERRONYX)
			.input('|', Items.STICK)
			.criterion(hasItem(ModItems.FERRONYX), conditionsFromItem(ModItems.FERRONYX))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRONYX_DAGGER)
			.pattern("   ")
			.pattern(" # ")
			.pattern(" | ")
			.input('#', ModItems.FERRONYX)
			.input('|', Items.STICK)
			.criterion(hasItem(ModItems.FERRONYX), conditionsFromItem(ModItems.FERRONYX))
			.offerTo(exporter)
			;

		createStairsRecipe(ModBlocks.FERRONYX_STAIRS, Ingredient.ofItems(ModItems.FERRONYX));
		createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRONYX_SLAB, Ingredient.ofItems(ModItems.FERRONYX));
		createFenceRecipe(ModBlocks.FERRONYX_WALL, Ingredient.ofItems(ModItems.FERRONYX));
		createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FERRONYX_PRESSURE_PLATE, Ingredient.ofItems(ModItems.FERRONYX));

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINIAM_HELMET)
			.pattern("###")
			.pattern("# #")
			.pattern("   ")
			.input('#', ModItems.PLATINIAM_INGOT)
			.criterion(hasItem(ModItems.PLATINIAM_INGOT), conditionsFromItem(ModItems.PLATINIAM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINIAM_CHESTPLATE)
			.pattern("# #")
			.pattern("###")
			.pattern("###")
			.input('#', ModItems.PLATINIAM_INGOT)
			.criterion(hasItem(ModItems.PLATINIAM_INGOT), conditionsFromItem(ModItems.PLATINIAM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINIAM_LEGGINGS)
			.pattern("###")
			.pattern("# #")
			.pattern("# #")
			.input('#', ModItems.PLATINIAM_INGOT)
			.criterion(hasItem(ModItems.PLATINIAM_INGOT), conditionsFromItem(ModItems.PLATINIAM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINIAM_BOOTS)
			.pattern("# #")
			.pattern("# #")
			.pattern("   ")
			.input('#', ModItems.PLATINIAM_INGOT)
			.criterion(hasItem(ModItems.PLATINIAM_INGOT), conditionsFromItem(ModItems.PLATINIAM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_HELMET)
			.pattern("###")
			.pattern("# #")
			.pattern("   ")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_CHESTPLATE)
			.pattern("# #")
			.pattern("###")
			.pattern("###")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_LEGGINGS)
			.pattern("###")
			.pattern("# #")
			.pattern("# #")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_BOOTS)
			.pattern("# #")
			.pattern("# #")
			.pattern("   ")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_SWORD)
			.pattern(" # ")
			.pattern(" # ")
			.pattern(" | ")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.input('|', Items.STICK)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;
		
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_AXE)
			.pattern(" ##")
			.pattern(" |#")
			.pattern(" | ")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.input('|', Items.STICK)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;

		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FERRATINIUM_DAGGER)
			.pattern("   ")
			.pattern(" # ")
			.pattern(" | ")
			.input('#', ModItems.CRYSTALLIZED_FERRATINIUM_INGOT)
			.input('|', Items.STICK)
			.criterion(hasItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT), conditionsFromItem(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
			.offerTo(exporter)
			;
	}
}
