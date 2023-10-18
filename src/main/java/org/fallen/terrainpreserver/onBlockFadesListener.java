package org.fallen.terrainpreserver;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import java.util.ArrayList;

public class onBlockFadesListener implements Listener {
    @EventHandler
    public void onBlockFades(BlockFadeEvent e) {
        Material fadingBlock = e.getBlock().getBlockData().getMaterial();

        ArrayList<Material> excludedBlocks = new ArrayList<>();

        ArrayList<Material> knownBlocks = new ArrayList<>();

        if (!excludedBlocks.contains(fadingBlock)) {
            if (!knownBlocks.contains(fadingBlock)) {
                System.out.println("Block tried to spread: " + fadingBlock);
            }
//            e.setCancelled(true);
        }
    }
}
