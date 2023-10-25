package org.fallen.terrainpreserver;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;
import org.fallen.terrainpreserver.commands.terpRouterCommand;
import org.fallen.terrainpreserver.listeners.natural.*;
import org.fallen.terrainpreserver.listeners.player.*;

import java.util.logging.Logger;

public final class TerrainPreserver extends JavaPlugin implements Listener {
    // Create Logger
    public static Logger GlobalLogger = PluginLogger.getLogger("TerrainPreserver");

    @Override
    public void onEnable() {
        // Register Listeners
        getServer().getPluginManager().registerEvents(new onBlockFormationListener(), this);
        getServer().getPluginManager().registerEvents(new onBlockSpreadsListener(), this);
        getServer().getPluginManager().registerEvents(new onBlockFadesListener(), this);
        getServer().getPluginManager().registerEvents(new onCropGrowthListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerBonemealsListener(), this);
        getServer().getPluginManager().registerEvents(new onLeavesFadeListener(), this);
        getServer().getPluginManager().registerEvents(new onWaterBreaksItemListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerPlacesBlockListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerBreaksBlockListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerDamagedByPlayerListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerUsesToolSecondaryListener(), this);
        // TODO: explosions, fire, fall-damage, mob-greifing

        // Register Commands
        getCommand("terp").setExecutor(new terpRouterCommand());
    }
}
