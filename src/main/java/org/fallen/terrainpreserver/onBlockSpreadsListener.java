package org.fallen.terrainpreserver;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class onBlockSpreadsListener implements Listener {
    @EventHandler
    public void onBlockSpreads(BlockSpreadEvent e) {
        Material spreadSource = e.getSource().getBlockData().getMaterial();

        if (spreadSource != Material.VINE) {
            System.out.println("Block tried to spread: " + spreadSource);
        }

        e.setCancelled(true);
    }
}
