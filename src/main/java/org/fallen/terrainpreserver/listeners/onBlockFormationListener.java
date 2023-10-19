package org.fallen.terrainpreserver.listeners;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getLogger;

public class onBlockFormationListener implements Listener {
    @EventHandler
    public void onBlockFormation(BlockFormEvent event) {
        BlockData newBlock = event.getNewState().getBlockData();

        ArrayList<Material> excludedBlocks = new ArrayList<>();
        excludedBlocks.add(Material.STONE);
        excludedBlocks.add(Material.OBSIDIAN);
        excludedBlocks.add(Material.COBBLESTONE);

        ArrayList<Material> knownBlocks = new ArrayList<>();
        knownBlocks.add(Material.ICE);

        // Don't cancel formation if the block is excluded
        if (!excludedBlocks.contains(newBlock.getMaterial())) {
            // If the block is not known then log its formation
            if (!knownBlocks.contains(newBlock.getMaterial())) {
                getLogger().info("A new block tried to form: " + newBlock.getMaterial());
            }

            event.setCancelled(true);
        }

    }
}
