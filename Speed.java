package com.myclient.module.modules;

import com.myclient.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;

public class Speed extends Module {
    private float speedMultiplier = 2.0f;

    public Speed() {
        super("Speed");
    }

    @Override
    public void onEnable() {
        // Speed enabled
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.setVelocity(0, mc.player.getVelocity().y, 0);
        }
    }

    @Override
    public void onTick() {
        ClientPlayerEntity player = mc.player;
        if (player == null) return;

        if (player.isOnGround() && (mc.options.forwardKey.isPressed() || 
            mc.options.backKey.isPressed() || 
            mc.options.leftKey.isPressed() || 
            mc.options.rightKey.isPressed())) {
            
            double vx = player.getVelocity().x;
            double vz = player.getVelocity().z;
            
            player.setVelocity(vx * speedMultiplier, player.getVelocity().y, vz * speedMultiplier);
        }
    }
}
