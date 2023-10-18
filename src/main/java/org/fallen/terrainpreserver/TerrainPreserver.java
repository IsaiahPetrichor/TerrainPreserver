package org.fallen.terrainpreserver;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TerrainPreserver extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new onBlockFormationListener(),  this);
        getServer().getPluginManager().registerEvents(new onBlockSpreadsListener(),  this);
        getServer().getPluginManager().registerEvents(new onCropGrowthListener(),  this);
    }

}
