package net.vodculen.ferratinium.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WaterTransformableArmorItem extends ArmorItem {
	private final Item transformedItem;

	public WaterTransformableArmorItem(ArmorMaterial material, Type type, Settings settings, Item transformedItem) {
		super(material, type, settings);
		
		this.transformedItem = transformedItem;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && entity instanceof LivingEntity living && entity.isTouchingWater()) {
			EquipmentSlot armorSlot = getSlotType();
			ItemStack equipped = living.getEquippedStack(armorSlot);
			ItemStack newStack = new ItemStack(transformedItem);

			if (equipped == stack && equipped.getItem() != transformedItem) {
				newStack.setCount(stack.getCount());
				newStack.setNbt(stack.getNbt());

				living.equipStack(armorSlot, newStack);
			}
		}

		super.inventoryTick(stack, world, entity, slot, selected);
	}
}
