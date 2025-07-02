package net.vodculen.ferratinium.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.item.ItemStack;
import net.vodculen.ferratinium.item.ModItems;

@Mixin(targets = {"net.minecraft.screen.GrindstoneScreenHandler$2", "net.minecraft.screen.GrindstoneScreenHandler$3"})
public abstract class GrindstoneScreenHandlerSlotMixin {
	// Thanks to 7410 from KaupenHub
	@ModifyReturnValue(method = "canInsert", at = @At("RETURN"))
	private boolean allowInsertingCostomItem(boolean original, ItemStack stack) {
		return original || stack.isOf(ModItems.ENERGIZED_FERRONYX_INGOT);
	}
}
