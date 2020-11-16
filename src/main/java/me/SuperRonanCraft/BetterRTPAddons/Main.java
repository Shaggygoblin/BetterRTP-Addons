package me.SuperRonanCraft.BetterRTPAddons;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private final AddonsHandler addonsHandler = new AddonsHandler();
    private final Files files = new Files();

    @Override
    public void onEnable() {
        instance = this;
        new ReloadListener(this);
        load();
    }

    @Override
    public void onDisable() {
        addonsHandler.unload();
    }

    void load() {
        files.load();
        addonsHandler.load();
    }

    public Files getFiles() {
        return files;
    }

    public AddonsHandler getAddonsHandler() {
        return addonsHandler;
    }

    public static Main getInstance() {
        return instance;
    }
}
