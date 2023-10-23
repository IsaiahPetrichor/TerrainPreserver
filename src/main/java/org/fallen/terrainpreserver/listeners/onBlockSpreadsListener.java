package org.fallen.terrainpreserver.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.spreadBlocksList.*;

public class onBlockSpreadsListener implements Listener {
    @EventHandler
    public void onBlockSpreads(BlockSpreadEvent e) {
        Material spreadSource = e.getSource().getBlockData().getMaterial();

        // Check if block is excluded because excluded blocks can spread
        if (!getExcludedSpreadableBlocks().contains(spreadSource)) {
            // If block is not known, unknown blocks output logs when they try to spread/grow
            if (!getKnownSpreadableBlocks().contains(spreadSource) && !getIncludedSpreadableBlocks().contains(
                    spreadSource)) {
                GlobalLogger.info("Block tried to spread: " + spreadSource);
            }
            e.setCancelled(!e.isCancelled());
        }
    }
}
