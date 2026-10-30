package com.myclient.gui;

import com.myclient.module.Module;
import com.myclient.module.ModuleManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class HackMenu extends Screen {
    private int scrollY = 0;

    public HackMenu() {
        super(Text.literal("Hack Menu"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.fillGradient(matrices, 0, 0, this.width, this.height, 0xFF000000, 0xFF000000);
        this.textRenderer.draw(matrices, "Hack Menu", 10, 10, 0xFFFFFF);

        int y = 30;
        for (Module module : ModuleManager.getModules()) {
            int color = module.isEnabled() ? 0xFF00FF00 : 0xFFFF0000;
            this.textRenderer.draw(matrices, module.getName(), 20, y, color);
            y += 20;
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        scrollY += (int) verticalAmount * 10;
        return true;
    }

    @Override
    public void close() {
        this.client.setScreen(null);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
