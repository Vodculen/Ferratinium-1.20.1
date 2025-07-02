package net.vodculen.ferratinium.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.vodculen.ferratinium.item.ModItems;

@Mixin(GrindstoneScreenHandler.class)
public abstract class GrindstoneScreenHandlerMixin {
	@Shadow @Final private Inventory result;
	@Shadow @Final private Inventory input;

	@Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
	private void customGrindstoneLogic(CallbackInfo callbackInfo) {
		ItemStack input1 = this.input.getStack(0);
		ItemStack input2 = this.input.getStack(1);

		if (input1.isOf(ModItems.ENERGIZED_FERRONYX_INGOT) && input2.isEmpty()) {
			this.result.setStack(0, new ItemStack(ModItems.ENERGIZED_FERRONYX_POWDER, input1.getCount()));

			callbackInfo.cancel();
		}
		if (input2.isOf(ModItems.ENERGIZED_FERRONYX_INGOT) && input1.isEmpty()) {
			this.result.setStack(0, new ItemStack(ModItems.ENERGIZED_FERRONYX_POWDER, input2.getCount()));

			callbackInfo.cancel();
		}
	}

	
}
