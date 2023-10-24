package org.fallen.terrainpreserver.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.fallen.terrainpreserver.materiallists.cropList.getIncludedCrops;
import static org.fallen.terrainpreserver.materiallists.spreadBlocksList.getIncludedSpreadableBlocks;

public class onPlayerBonemealsListener implements Listener {
    public Player playerInitialized = null;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerBonemealsCrop(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        boolean playerRightClicked = event.getAction() == Action.RIGHT_CLICK_BLOCK;
        Material item = player.getInventory().getItemInMainHand().getType();
        boolean itemIsBonemeal = item == Material.BONE_MEAL;
        Block block = event.getClickedBlock();

        if (!playerRightClicked || !itemIsBonemeal || block == null) return;

        Material blockMaterial = block.getType();
        boolean playerOp = player.isOp();

        // Crops are bonemeal-ed
        if (playerOp && getIncludedCrops().contains(blockMaterial)) {
            String originalBlockData = block.getBlockData().getAsString();

            String originalCropAge = String.valueOf(originalBlockData.charAt(originalBlockData.length() - 2));
            int newCropAgeInt = Integer.parseInt(originalCropAge);
            if (Integer.parseInt(originalCropAge) < 7) {
                newCropAgeInt += 1;
            }
            String newCropAge = String.valueOf(newCropAgeInt);

            String newBlockDataString = originalBlockData.replace(originalCropAge, newCropAge);

            BlockData newBlockData = Bukkit.createBlockData(newBlockDataString);

            if (Integer.parseInt(newCropAge) < 8) {
                block.setBlockData(newBlockData);
            }
        }

        // Spreadable block is bonemeal-ed
        if (playerOp && getIncludedSpreadableBlocks().contains(blockMaterial)) {
            // set player that is used in onBlockSpreadsFromBonemeal
            playerInitialized = player;
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockSpreadsFromBonemeal(BlockSpreadEvent event) {
        if (getIncludedSpreadableBlocks().contains(event.getSource().getType()) && playerInitialized != null) {
            playerInitialized = null;
            event.setCancelled(true);
        }
    }
}
