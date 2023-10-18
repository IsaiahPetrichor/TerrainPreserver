package org.fallen.terrainpreserver;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import java.util.ArrayList;

public class onBlockFormationListener implements Listener {
    @EventHandler
    public void onBlockFormation(BlockFormEvent event) {
        BlockData newBlock = event.getNewState().getBlockData();

        ArrayList<Material> excludedBlocks = new ArrayList<>();
        excludedBlocks.add(Material.STONE);
        excludedBlocks.add(Material.OBSIDIAN);

        ArrayList<Material> knownBlocks = new ArrayList<>();
        knownBlocks.add(Material.ICE);

        if (!excludedBlocks.contains(newBlock.getMaterial())) {
            if (!knownBlocks.contains(newBlock.getMaterial())) {
                System.out.println("New state: " + newBlock.getMaterial());
            }

            event.setCancelled(true);
        }

    }
}
