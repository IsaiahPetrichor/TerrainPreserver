package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.spreadBlocksList.*;

public class onBlockSpreadsListener implements Listener {
    @EventHandler
    public void onBlockSpreads(BlockSpreadEvent event) {
        Material spreadSource = event.getSource().getBlockData().getMaterial();
        Material newState = event.getNewState().getType();
        String location = "X: " + event.getBlock().getLocation().getBlockX() + ", Y: " + event.getBlock().getLocation().getBlockY() + ", Z: " + event.getBlock().getLocation().getBlockZ();

        // Check if block is excluded because excluded blocks can spread
        if (!getExcludedSpreadableBlocks().contains(spreadSource)) {
            // If block is not known, unknown blocks output logs when they try to spread/grow
            if (!getKnownSpreadableBlocks().contains(spreadSource) && !getIncludedSpreadableBlocks().contains(
                    spreadSource) && newState != Material.RED_MUSHROOM && newState != Material.BROWN_MUSHROOM) {
                GlobalLogger.info(
                        "Block tried to spread. Source: " + spreadSource + ", Location: " + location + ", New Block: " + newState);
            }
            event.setCancelled(!event.isCancelled());
        }
    }
}
