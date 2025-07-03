package net.vodculen.ferratinium.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.vodculen.ferratinium.item.ModItems;

public class WaterTransformableSword extends SwordItem {
	private final Item transformedItem;

	public WaterTransformableSword(ToolMaterial material, int maxCount, float attackDamage, Settings settings, Item transformedItem) {
		super(material, maxCount, attackDamage, settings);
		
		this.transformedItem = transformedItem;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && entity instanceof PlayerEntity player && entity.isTouchingWater() && stack.getItem() != transformedItem) {
			ItemStack newStack = new ItemStack(transformedItem);
			ItemStack byproduct = new ItemStack(ModItems.ENERGIZED_FERRONYX_POWDER);

			newStack.setCount(stack.getCount());
			newStack.setNbt(stack.getNbt());

			player.getInventory().setStack(slot, newStack);

			if (!player.getInventory().insertStack(byproduct)) {
				player.dropItem(byproduct, false);
			}
		}
	}
}