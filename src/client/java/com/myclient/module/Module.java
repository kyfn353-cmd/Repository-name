package com.myclient.module;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected static final MinecraftClient mc = MinecraftClient.getInstance();

    private final String name;
    private boolean enabled;

    public Module(String name) {
        this.name = name;
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) return;
        this.enabled = enabled;
        if (enabled) onEnable(); else onDisable();
    }

    public boolean isEnabled() { return enabled; }
    public String getName() { return name; }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}
}
