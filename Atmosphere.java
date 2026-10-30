package com.myclient.module.modules;

import com.myclient.module.Module;
import net.minecraft.client.render.WorldRenderer;

public class Atmosphere extends Module {
    private float brightness = 1.0f;

    public Atmosphere() {
        super("Atmosphere");
    }

    @Override
    public void onEnable() {
        if (mc.world != null) {
            brightness = mc.world.getLevelProperties().getClearWeatherTime();
        }
    }

    @Override
    public void onDisable() {
        // Reset atmosphere
    }

    @Override
    public void onTick() {
        if (mc.world != null) {
            // Modify brightness or weather
            mc.world.getLevelProperties().setClearWeatherTime(100000);
        }
    }
}
