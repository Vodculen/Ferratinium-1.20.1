package net.vodculen.ferratinium.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import net.vodculen.ferratinium.item.ModItems;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin {
	@Shadow @Final private Inventory output;
	@Shadow @Final private Inventory input;

	@Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
	private void customAnvilLogic(CallbackInfo callbackInfo) {
		ItemStack input1 = this.input.getStack(0);
		ItemStack input2 = this.input.getStack(1);

		if ((input1.isOf(ModItems.PLATINIAM_INGOT) && input2.isOf(ModItems.ENERGIZED_FERRONYX_POWDER)) || 
			(input1.isOf(ModItems.ENERGIZED_FERRONYX_POWDER) && input2.isOf(ModItems.PLATINIAM_INGOT))) {
			this.output.setStack(0, new ItemStack(ModItems.ENERGIZED_FERRONYX_POWDER, min(input1.getCount(), input2.getCount())));

			callbackInfo.cancel();
		}
	}

	private int min(int x, int y) {
		if (x < y) {
			return x;
		}

		return y;
	}
}
