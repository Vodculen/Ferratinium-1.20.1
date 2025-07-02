package net.vodculen.ferratinium.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WaterPhobicItem extends Item {
	public WaterPhobicItem(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && entity instanceof PlayerEntity player && player.isTouchingWater()) {
			player.getInventory().removeOne(stack);
		}
		super.inventoryTick(stack, world, entity, slot, selected);
	}
}
