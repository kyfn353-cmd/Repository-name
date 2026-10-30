package com.myclient.events;

import com.myclient.module.ModuleManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ClientTickListener {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ModuleManager.tick();
        });
    }
}
