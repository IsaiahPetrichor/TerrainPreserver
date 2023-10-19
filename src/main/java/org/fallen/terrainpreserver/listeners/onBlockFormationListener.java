package org.fallen.terrainpreserver.listeners;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import java.util.ArrayList;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;

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

        // Cancel formation unless excludedBlocks contains the block
        if (!excludedBlocks.contains(newBlock.getMaterial())) {
            // If the block is not known then log its formation attempt
            if (!knownBlocks.contains(newBlock.getMaterial())) {
                GlobalLogger.info("A new block tried to form: " + newBlock.getMaterial());
            }

            event.setCancelled(true);
        }

    }
}
