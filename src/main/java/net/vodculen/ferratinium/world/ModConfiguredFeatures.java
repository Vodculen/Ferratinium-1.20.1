package net.vodculen.ferratinium.world;

import java.util.List;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.vodculen.ferratinium.Ferratinium;
import net.vodculen.ferratinium.block.ModBlocks;

public class ModConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> PLATINIAM_ORE_VEIN_KEY = registerKey("platiniam_ore_vein");
	public static final RegistryKey<ConfiguredFeature<?, ?>> FERRONYX_ORE_VEIN_KEY = registerKey("ferronyx_ore_vein");

	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
		RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldFerronyxOres = List.of(
			OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.FERRONYX_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_FERRONYX_ORE.getDefaultState())
		);

		List<OreFeatureConfig.Target> overworldPlatiniamOres = List.of(
			OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.PLATINIAM_ORE.getDefaultState()),
			OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_PLATINIAM_ORE.getDefaultState())
		);

		register(context, PLATINIAM_ORE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(overworldPlatiniamOres, 3));
		register(context, FERRONYX_ORE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(overworldFerronyxOres, 7));
	}

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Ferratinium.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
