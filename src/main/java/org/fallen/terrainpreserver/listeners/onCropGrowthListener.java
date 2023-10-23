package org.fallen.terrainpreserver.listeners;

import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

import static org.fallen.terrainpreserver.TerrainPreserver.GlobalLogger;
import static org.fallen.terrainpreserver.materiallists.cropList.getExcludedCrops;
import static org.fallen.terrainpreserver.materiallists.cropList.getIncludedCrops;

public class onCropGrowthListener implements Listener {
    @EventHandler
    public void onCropsGrow(BlockGrowEvent event) {
        BlockData newCrop = event.getNewState().getBlockData();

        // If we don't exclude the block it does not grow.
        if (!getExcludedCrops().contains(newCrop.getMaterial())) {
            // If we stop growth but the block is not listed in includedCrops, log it.
            if (!getIncludedCrops().contains(newCrop.getMaterial())) {
                GlobalLogger.info("Unlisted crop tried to grow: " + newCrop.getMaterial());
            }

            event.setCancelled(true);
        }

    }
}
