package com.myclient;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class HackMenu extends Screen {
    public HackMenu() {
        super(Text.literal("My Hack Menu"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.fillGradient(0, 0, this.width, this.height, -1072689136, -804253680);
        
        drawCenteredTextWithShadow(matrices, this.textRenderer, "My Hack Menu", 
            this.width / 2, 20, 16777215);

        int y = 50;
        for (Module module : ModuleManager.getModules()) {
            String text = module.getName() + ": " + (module.isEnabled() ? "ON" : "OFF");
            drawTextWithShadow(matrices, this.textRenderer, text, 50, y, 
                module.isEnabled() ? 65280 : 16711680);
            y += 20;
        }
        
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int y = 50;
        for (Module module : ModuleManager.getModules()) {
            if (mouseX > 50 && mouseX < 200 && mouseY > y && mouseY < y + 20) {
                module.setEnabled(!module.isEnabled());
            }
            y += 20;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
