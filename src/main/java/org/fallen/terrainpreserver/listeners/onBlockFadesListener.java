package org.fallen.terrainpreserver.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.fadingBlockList.getExcludedBlocks;
import static org.fallen.terrainpreserver.materiallists.fadingBlockList.getKnownBlocks;

public class onBlockFadesListener implements Listener {
    @EventHandler
    public void onBlockFades(BlockFadeEvent e) {
        Material fadingBlock = e.getBlock().getBlockData().getMaterial();

        if (!getExcludedBlocks().contains(fadingBlock)) {
            if (!getKnownBlocks().contains(fadingBlock)) {
                GlobalLogger.info("Block tried to fade: " + fadingBlock);
            }

            e.setCancelled(true);
        }
    }
}
