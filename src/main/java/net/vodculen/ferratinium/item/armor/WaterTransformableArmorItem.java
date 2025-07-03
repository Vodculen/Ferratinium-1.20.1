package net.vodculen.ferratinium.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.vodculen.ferratinium.item.ModItems;

public class WaterTransformableArmorItem extends ArmorItem {
	private final Item transformedItem;

	public WaterTransformableArmorItem(ArmorMaterial material, Type type, Settings settings, Item transformedItem) {
		super(material, type, settings);
		
		this.transformedItem = transformedItem;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && entity instanceof PlayerEntity player && entity.isTouchingWater()) {
			EquipmentSlot armorSlot = getSlotType();
			ItemStack equipped = player.getEquippedStack(armorSlot);
			ItemStack newStack = new ItemStack(transformedItem);
			ItemStack byproduct = new ItemStack(ModItems.ENERGIZED_FERRONYX_POWDER);

			newStack.setCount(stack.getCount());
			newStack.setNbt(stack.getNbt());

			if (equipped == stack && equipped.getItem() != transformedItem) {
				player.equipStack(armorSlot, newStack);
			} else {
				player.getInventory().setStack(slot, newStack);
			}

			player.getInventory().insertStack(byproduct);
		}

		super.inventoryTick(stack, world, entity, slot, selected);
	}
}
