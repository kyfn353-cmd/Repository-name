package com.myclient;

import com.myclient.events.ClientTickListener;
import com.myclient.module.ModuleManager;
import com.myclient.module.modules.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ClientInitializer implements ClientModInitializer {
    public static KeyBinding menuKey;

    @Override
    public void onInitializeClient() {
        // Register modules
        ModuleManager.register(new Fly());
        ModuleManager.register(new Speed());
        ModuleManager.register(new Aura());
        ModuleManager.register(new Strife());
        ModuleManager.register(new Atmosphere());

        // Register events
        ClientTickListener.register();

        // Register keybind
        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.myhack.menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_M,
                "category.myhack"
        ));
    }
}
