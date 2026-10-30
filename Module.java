package com.myclient.module;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected MinecraftClient mc = MinecraftClient.getInstance();
    protected String name;
    protected boolean enabled = false;

    public Module(String name) {
        this.name = name;
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void onTick();

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
