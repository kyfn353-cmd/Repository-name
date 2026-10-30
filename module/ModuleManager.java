package com.myclient.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public void register(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() { return modules; }

    public Module get(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public void tick() {
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick();
        }
    }
}
