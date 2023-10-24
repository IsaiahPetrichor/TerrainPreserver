package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import static org.bukkit.Bukkit.getLogger;
import static org.fallen.terrainpreserver.materiallists.waterProtectedBlocksList.getWaterProtectedBlocks;

public class onWaterBreaksItemListener implements Listener {
    @EventHandler
    public void onWaterBreaksItem(BlockFromToEvent event) {
        Material block = event.getToBlock().getType();

        if (!getWaterProtectedBlocks().contains(block) && block != Material.AIR) {
            getLogger().info("Water tried to flow into block: " + block);
        }

        // check if block is included in waterProtectedBlocks
        if (getWaterProtectedBlocks().contains(block)) {
            event.setCancelled(true);
        }
    }
}
