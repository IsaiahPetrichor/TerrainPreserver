package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.formingBlocksList.getExcludedBlocks;
import static org.fallen.terrainpreserver.materiallists.formingBlocksList.getKnownBlocks;

public class onBlockFormationListener implements Listener {
    @EventHandler
    public void onBlockFormation(BlockFormEvent event) {
        BlockData newBlock = event.getNewState().getBlockData();
        String location = "X: " + event.getBlock().getLocation().getBlockX() + ", Y: " + event.getBlock().getLocation().getBlockY() + ", Z: " + event.getBlock().getLocation().getBlockZ();

        // Cancel formation unless block is excluded
        if (!getExcludedBlocks().contains(newBlock.getMaterial())) {
            // If the block is not known then log its formation attempt
            if (!getKnownBlocks().contains(newBlock.getMaterial())) {
                GlobalLogger.info("Block tried to form: " + newBlock.getMaterial() + ", Location: " + location);
            }

            event.setCancelled(true);
        }

    }
}
