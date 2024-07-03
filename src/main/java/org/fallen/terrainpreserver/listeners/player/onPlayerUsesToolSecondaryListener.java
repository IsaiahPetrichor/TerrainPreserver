package org.fallen.terrainpreserver.listeners.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.bukkit.Bukkit.getLogger;

public class onPlayerUsesToolSecondaryListener implements Listener {
    @EventHandler
    public void onPlayerUsesToolSecondary(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        boolean playerRightClicked = event.getAction() == Action.RIGHT_CLICK_BLOCK;
        Material item = player.getInventory().getItemInMainHand().getType();
        boolean itemIsTool = item.toString().contains("_HOE") || item.toString().contains(
                "_AXE") || item.toString().contains("_SHOVEL") || item.toString().contains(
                "BUCKET") || item.toString().contains("SHEARS") || item.toString().contains("AND_STEEL");

        if (block != null && playerRightClicked && itemIsTool) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
            } else {
                getLogger().info("Block info: " + block.getBlockData());
            }
        }
    }
}
