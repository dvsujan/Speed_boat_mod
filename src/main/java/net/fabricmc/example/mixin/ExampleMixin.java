package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleMod;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
// import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class ExampleMixin extends Screen {

	protected ExampleMixin(Text title) {
		super(title);
	}
	@Inject(at = @At("HEAD"), method = "initWidgets")
	private void AddCustomButton(CallbackInfo info) {
		this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 4 + 160, 200, 20, Text.of("flying: "+ExampleMod.isHacksEnabled()),
		on -> {
			ExampleMod.toggleHacks();
		}));
		
		this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 4 + 130, 200, 20, Text.of("flyingSpeed: "+ExampleMod.isSpeedHack()),
		on -> {
			ExampleMod.toggleSpeedHacks();
		}));
	}
}
