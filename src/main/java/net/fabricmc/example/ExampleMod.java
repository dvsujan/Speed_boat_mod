package net.fabricmc.example;
import net.minecraft.client.MinecraftClient;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.hacks.FlyHack;
import net.fabricmc.hacks.SpeedHack;

public class ExampleMod implements ModInitializer {
	FlyHack f = new FlyHack() ; 
	SpeedHack s = new SpeedHack() ;	
	// public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	static Boolean hacks = false; 	
	static Boolean speedHacks = false ; 	
	@Override
	public void onInitialize() {
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);
		//print started
		// LOGGER.info("ExampleMod has been started!");
	}

	public static void toggleHacks() {
		if(hacks){
			hacks = false ; 
		}
		else{ 
			hacks = true ; 
			if(speedHacks){
				speedHacks = false ; 
			}
		}
	}	
	public static void toggleSpeedHacks(){ 
		if(speedHacks){
			speedHacks = false ; 
		}
		else{ 
			speedHacks = true ; 
			if(hacks){
				hacks = false ; 
			}
		}
	}	
	public static String isSpeedHack(){
		if(speedHacks){
			return "Enabled" ; 
		}
		else{ 
			return "Disabled" ; 
		}
	}	
	public static String isHacksEnabled() {
		if (hacks) {
			return "Enabled";
		} else {
			return "Disabled";
		}
	}	
	
	public  void tick(MinecraftClient client) {
		// client.player.setCustomName(Text.of("dvsujan"));
		if(hacks){
			f.tick(client);
		}
		if(speedHacks){ 
			s.tick(client);
		}
		
	}
}
