package org.fallen.terrainpreserver.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onPlayerBreaksBlockListener implements Listener {
    @EventHandler
    public void onPlayerBreaksBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!player.isOp()) {
            event.setCancelled(true);
        }
    }
}
