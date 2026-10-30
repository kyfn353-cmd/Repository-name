package com.myclient.module.modules;

import com.myclient.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Aura extends Module {
    private float attackRange = 4.0f;
    private int attackCooldown = 0;

    public Aura() {
        super("Aura");
    }

    @Override
    public void onEnable() {
        attackCooldown = 0;
    }

    @Override
    public void onDisable() {
        attackCooldown = 0;
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;

        if (attackCooldown > 0) {
            attackCooldown--;
            return;
        }

        LivingEntity target = null;
        double closestDistance = attackRange;

        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof LivingEntity && entity != mc.player) {
                if (entity instanceof HostileEntity || entity instanceof PlayerEntity) {
                    double distance = mc.player.distanceTo(entity);
                    if (distance < closestDistance) {
                        closestDistance = distance;
                        target = (LivingEntity) entity;
                    }
                }
            }
        }

        if (target != null) {
            mc.interactionManager.attackEntity(mc.player, target);
            attackCooldown = 10;
        }
    }
}
