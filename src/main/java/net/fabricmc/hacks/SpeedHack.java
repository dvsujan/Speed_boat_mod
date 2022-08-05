package net.fabricmc.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class SpeedHack {
    public void tick(MinecraftClient client) {
        // set player name as dvsujan
        if (client.player != null && client.player.hasVehicle()) {
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = client.options.jumpKey.isPressed() ? 0.3 : 0;
            vehicle.setVelocity(new Vec3d(velocity.x * 1.1, motionY, velocity.z * 1.1));
        }
    }
}
