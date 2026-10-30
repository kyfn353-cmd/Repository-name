package com.myclient.module.modules;

import com.myclient.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;

public class Fly extends Module {
    private float flySpeed = 0.5f;

    public Fly() {
        super("Fly");
    }

    @Override
    public void onEnable() {
        if (mc.player != null) {
            mc.player.getAbilities().flying = true;
            mc.player.getAbilities().setFlying(true);
        }
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.getAbilities().flying = false;
            mc.player.getAbilities().setFlying(false);
        }
    }

    @Override
    public void onTick() {
        ClientPlayerEntity player = mc.player;
        if (player == null) return;

        player.setVelocity(0, 0, 0);

        if (mc.options.forwardKey.isPressed()) {
            player.addVelocity(
                    Math.sin(-player.getYaw() * (Math.PI / 180)) * flySpeed,
                    0,
                    -Math.cos(-player.getYaw() * (Math.PI / 180)) * flySpeed
            );
        }
        if (mc.options.backKey.isPressed()) {
            player.addVelocity(
                    -Math.sin(-player.getYaw() * (Math.PI / 180)) * flySpeed,
                    0,
                    Math.cos(-player.getYaw() * (Math.PI / 180)) * flySpeed
            );
        }
        if (mc.options.leftKey.isPressed()) {
            player.addVelocity(
                    -Math.cos(-player.getYaw() * (Math.PI / 180)) * flySpeed,
                    0,
                    Math.sin(-player.getYaw() * (Math.PI / 180)) * flySpeed
            );
        }
        if (mc.options.rightKey.isPressed()) {
            player.addVelocity(
                    Math.cos(-player.getYaw() * (Math.PI / 180)) * flySpeed,
                    0,
                    -Math.sin(-player.getYaw() * (Math.PI / 180)) * flySpeed
            );
        }

        if (mc.options.jumpKey.isPressed()) {
            player.addVelocity(0, flySpeed, 0);
        }
        if (mc.options.sneakKey.isPressed()) {
            player.addVelocity(0, -flySpeed, 0);
        }
    }
}
