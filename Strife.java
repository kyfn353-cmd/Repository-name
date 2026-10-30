package com.myclient.module.modules;

import com.myclient.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;

public class Strife extends Module {
    private float strifeSpeed = 1.5f;

    public Strife() {
        super("Strife");
    }

    @Override
    public void onEnable() {
        // Strife enabled
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

        if (mc.options.leftKey.isPressed()) {
            player.addVelocity(
                    -Math.cos(-player.getYaw() * (Math.PI / 180)) * strifeSpeed,
                    0,
                    Math.sin(-player.getYaw() * (Math.PI / 180)) * strifeSpeed
            );
        }
        if (mc.options.rightKey.isPressed()) {
            player.addVelocity(
                    Math.cos(-player.getYaw() * (Math.PI / 180)) * strifeSpeed,
                    0,
                    -Math.sin(-player.getYaw() * (Math.PI / 180)) * strifeSpeed
            );
        }
    }
}
