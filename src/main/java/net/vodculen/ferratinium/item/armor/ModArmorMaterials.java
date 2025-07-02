package net.vodculen.ferratinium.item.armor;

import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.vodculen.ferratinium.Ferratinium;
import net.vodculen.ferratinium.item.ModItems;

public enum ModArmorMaterials implements ArmorMaterial {
	PLATINIAM("platiniam", 30, new int[] { 4, 7, 10, 4 }, 20, 
		SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> Ingredient.ofItems(ModItems.PLATINIAM_INGOT))
	,
	FERRATINIUM("ferratinium", 40, new int[] { 5, 8, 12, 5 }, 25, 
			SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(ModItems.CRYSTALLIZED_FERRATINIUM_INGOT))
	;

   	private static final int[] BASE_DURABILITY = {13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;

	ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionAmounts = protectionAmounts;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	public int getDurability(ArmorItem.Type type) {
		return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
	}

	public int getProtection(ArmorItem.Type type) {
		return protectionAmounts[type.ordinal()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return Ferratinium.MOD_ID + ":" + this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
