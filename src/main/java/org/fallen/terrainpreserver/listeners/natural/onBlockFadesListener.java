package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.fadingBlockList.getExcludedBlocks;
import static org.fallen.terrainpreserver.materiallists.fadingBlockList.getKnownBlocks;

public class onBlockFadesListener implements Listener {
    @EventHandler
    public void onBlockFades(BlockFadeEvent event) {
        Material fadingBlock = event.getBlock().getBlockData().getMaterial();
        String location = "X: " + event.getBlock().getLocation().getBlockX() + ", Y: " + event.getBlock().getLocation().getBlockY() + ", Z: " + event.getBlock().getLocation().getBlockZ();

        if (!getExcludedBlocks().contains(fadingBlock)) {
            if (!getKnownBlocks().contains(fadingBlock)) {
                GlobalLogger.info("Block tried to fade: " + fadingBlock + ", Location: " + location);
            }

            event.setCancelled(true);
        }
    }
}
