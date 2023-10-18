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
        excludedBlocks.add(Material.SUGAR_CANE);
        // Flowers
        excludedBlocks.add(Material.POPPY);
        excludedBlocks.add(Material.DANDELION);
        excludedBlocks.add(Material.ORANGE_TULIP);
        excludedBlocks.add(Material.PINK_TULIP);
        excludedBlocks.add(Material.RED_TULIP);
        excludedBlocks.add(Material.WHITE_TULIP);
        excludedBlocks.add(Material.BLUE_ORCHID);
        excludedBlocks.add(Material.AZURE_BLUET);
        excludedBlocks.add(Material.ALLIUM);
        excludedBlocks.add(Material.OXEYE_DAISY);
        excludedBlocks.add(Material.CORNFLOWER);
        excludedBlocks.add(Material.LILY_OF_THE_VALLEY);

        if (!excludedBlocks.contains(newCrop.getMaterial())) {
            System.out.println("Crop tried to grow: " + newCrop.getMaterial());
            event.setCancelled(true);
        }

    }
}
