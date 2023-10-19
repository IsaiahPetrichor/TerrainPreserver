package org.fallen.terrainpreserver.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getLogger;

public class onBlockFadesListener implements Listener {
    @EventHandler
    public void onBlockFades(BlockFadeEvent e) {
        Material fadingBlock = e.getBlock().getBlockData().getMaterial();

        ArrayList<Material> excludedBlocks = new ArrayList<>();
        excludedBlocks.add(Material.GRASS_BLOCK);

        ArrayList<Material> knownBlocks = new ArrayList<>();
        knownBlocks.add(Material.ICE);
        knownBlocks.add(Material.SNOW);
        knownBlocks.add(Material.BRAIN_CORAL);
        knownBlocks.add(Material.BRAIN_CORAL_BLOCK);
        knownBlocks.add(Material.BRAIN_CORAL_FAN);
        knownBlocks.add(Material.BRAIN_CORAL_WALL_FAN);
        knownBlocks.add(Material.BUBBLE_CORAL);
        knownBlocks.add(Material.BUBBLE_CORAL_BLOCK);
        knownBlocks.add(Material.BUBBLE_CORAL_FAN);
        knownBlocks.add(Material.BUBBLE_CORAL_WALL_FAN);
        knownBlocks.add(Material.FIRE_CORAL);
        knownBlocks.add(Material.FIRE_CORAL_BLOCK);
        knownBlocks.add(Material.FIRE_CORAL_FAN);
        knownBlocks.add(Material.FIRE_CORAL_WALL_FAN);
        knownBlocks.add(Material.HORN_CORAL);
        knownBlocks.add(Material.HORN_CORAL_BLOCK);
        knownBlocks.add(Material.HORN_CORAL_FAN);
        knownBlocks.add(Material.HORN_CORAL_WALL_FAN);
        knownBlocks.add(Material.TUBE_CORAL);
        knownBlocks.add(Material.TUBE_CORAL_BLOCK);
        knownBlocks.add(Material.TUBE_CORAL_FAN);
        knownBlocks.add(Material.TUBE_CORAL_WALL_FAN);

        if (!excludedBlocks.contains(fadingBlock)) {
            if (!knownBlocks.contains(fadingBlock)) {
                getLogger().info("Block tried to fade: " + fadingBlock);
            }

            e.setCancelled(true);
        }
    }
}
