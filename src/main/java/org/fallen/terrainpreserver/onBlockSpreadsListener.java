package org.fallen.terrainpreserver;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

import java.util.ArrayList;

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
                System.out.println("Block tried to spread: " + spreadSource);
            }
            e.setCancelled(true);
        }
    }
}
