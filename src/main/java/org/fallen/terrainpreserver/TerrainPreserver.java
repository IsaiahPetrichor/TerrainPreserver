package org.fallen.terrainpreserver;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.fallen.terrainpreserver.listeners.*;

public final class TerrainPreserver extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new onBlockFormationListener(),  this);
        getServer().getPluginManager().registerEvents(new onBlockSpreadsListener(),  this);
        getServer().getPluginManager().registerEvents(new onBlockFadesListener(), this);
        getServer().getPluginManager().registerEvents(new onCropGrowthListener(),  this);
        getServer().getPluginManager().registerEvents(new onPlayerBonemealsListener(), this);
    }

}
