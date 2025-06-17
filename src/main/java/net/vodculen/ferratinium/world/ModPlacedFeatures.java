package net.vodculen.ferratinium.world;

import java.util.List;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.vodculen.ferratinium.Ferratinium;

public class ModPlacedFeatures {
	public static final RegistryKey<PlacedFeature> FERRONYX_ORE_VEIN_PLACED_KEY = registerKey("ferronyx_ore_vein_placed");
	public static final RegistryKey<PlacedFeature> PLATINIAM_ORE_VEIN_PLACED_KEY = registerKey("platiniam_ore_vein_placed");

	public static void bootstrap(Registerable<PlacedFeature> context) {
		var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

		register(context, FERRONYX_ORE_VEIN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FERRONYX_ORE_VEIN_KEY), 
			ModOrePlacement.modifiersWithCount(10, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-54), YOffset.fixed(56))));
		register(context, PLATINIAM_ORE_VEIN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLATINIAM_ORE_VEIN_KEY), 
			ModOrePlacement.modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(-36))));
	}

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Ferratinium.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
