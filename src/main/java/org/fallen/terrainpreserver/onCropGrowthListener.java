package org.fallen.terrainpreserver;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

import java.util.ArrayList;

public class onCropGrowthListener implements Listener {
    @EventHandler
    public void onCropsGrow(BlockGrowEvent event) {
        BlockData newCrop = event.getNewState().getBlockData();

        ArrayList<Material> excludedBlocks = new ArrayList<>();
        excludedBlocks.add(Material.GRASS);
        excludedBlocks.add(Material.CACTUS);

        if (!excludedBlocks.contains(newCrop.getMaterial())) {
            System.out.println("Crop tried to grow: " + newCrop.getMaterial());
            event.setCancelled(true);
        }

    }
}
