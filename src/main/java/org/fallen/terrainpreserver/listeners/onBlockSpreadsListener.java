package org.fallen.terrainpreserver.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getLogger;

public class onBlockSpreadsListener implements Listener {
    @EventHandler
    public void onBlockSpreads(BlockSpreadEvent e) {
        Material spreadSource = e.getSource().getBlockData().getMaterial();

        ArrayList<Material> excludedBlocks = new ArrayList<>();
        excludedBlocks.add(Material.GRASS_BLOCK);

        ArrayList<Material> knownBlocks = new ArrayList<>();
        knownBlocks.add(Material.VINE);

        if (!excludedBlocks.contains(spreadSource)) {
            if (!knownBlocks.contains(spreadSource)) {
                getLogger().info("Block tried to spread: " + spreadSource);
            }
            e.setCancelled(true);
        }
    }
}
