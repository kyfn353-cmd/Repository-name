package com.myclient;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindingManager {
    public static KeyBinding hackMenuKey;

    public static void initialize() {
        hackMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.myhack.menu",
            InputUtil.Type.MOUSE,
            GLFW.GLFW_MOUSE_BUTTON_RIGHT,  // ✅ الزر الأيمن للماوس
            "category.myhack"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (hackMenuKey.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(new HackMenu());
                }
            }
        });
    }
}
