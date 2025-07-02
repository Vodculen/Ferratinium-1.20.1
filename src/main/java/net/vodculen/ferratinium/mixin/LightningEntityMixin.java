package net.vodculen.ferratinium.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.vodculen.ferratinium.item.ModItems;

@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void onTick(CallbackInfo ci) {
		LightningEntity lightning = (LightningEntity) (Object) this;

		// Loop through nearby entities hit by lightning
		List<Entity> hitEntities = lightning.getWorld().getOtherEntities(lightning, lightning.getBoundingBox().expand(1.0), entity -> entity instanceof ItemEntity);

		for (Entity entity : hitEntities) {
			ItemEntity itemEntity = (ItemEntity) entity;
			ItemStack stack = itemEntity.getStack();

			// Check for your specific item
			if (stack.getItem() == ModItems.FERRONYX) {
				itemEntity.setInvulnerable(true);
				itemEntity.setStack(new ItemStack(ModItems.ENERGIZED_FERRONYX));
				itemEntity.getWorld().playSound(null, itemEntity.getBlockPos(), SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
}
