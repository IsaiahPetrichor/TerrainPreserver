package org.fallen.terrainpreserver;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;
import org.fallen.terrainpreserver.commands.terpRouterCommand;
import org.fallen.terrainpreserver.listeners.*;

import java.util.logging.Logger;

public final class TerrainPreserver extends JavaPlugin implements Listener {
    // Create Logger
    public static Logger GlobalLogger = PluginLogger.getLogger("TerrainPreserver");

    @Override
    public void onEnable() {
        // Register Listeners
        getServer().getPluginManager().registerEvents(new onBlockFormationListener(),  this);
        getServer().getPluginManager().registerEvents(new onBlockSpreadsListener(),  this);
        getServer().getPluginManager().registerEvents(new onBlockFadesListener(), this);
        getServer().getPluginManager().registerEvents(new onCropGrowthListener(),  this);
        getServer().getPluginManager().registerEvents(new onPlayerBonemealsListener(), this);

        // Register Commands
        getCommand("terp").setExecutor(new terpRouterCommand());
    }

}
