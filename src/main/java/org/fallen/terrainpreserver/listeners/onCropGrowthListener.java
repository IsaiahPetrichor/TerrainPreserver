package org.fallen.terrainpreserver.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getLogger;
import static org.fallen.terrainpreserver.utils.cropList.getExcludedCrops;
import static org.fallen.terrainpreserver.utils.cropList.getIncludedCrops;

public class onCropGrowthListener implements Listener {
    @EventHandler
    public void onCropsGrow(BlockGrowEvent event) {
        BlockData newCrop = event.getNewState().getBlockData();

        getLogger().info("Included crops: " + getIncludedCrops());
        getLogger().info("Excluded crops: " + getExcludedCrops());

        // If we don't exclude the block it does not grow.
        if (!getExcludedCrops().contains(newCrop.getMaterial())) {
            // If we stop growth but the block is not listed in includedCrops, log it.
            if (!getIncludedCrops().contains(newCrop.getMaterial())) {
                getLogger().info("Unlisted crop tried to grow: " + newCrop.getMaterial());
            }

            event.setCancelled(true);
        }

    }
}
