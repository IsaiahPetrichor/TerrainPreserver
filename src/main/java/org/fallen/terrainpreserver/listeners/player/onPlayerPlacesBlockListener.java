package org.fallen.terrainpreserver.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class onPlayerPlacesBlockListener implements Listener {
    @EventHandler
    public void onPlayerPlacesBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!player.isOp()) {
            event.setCancelled(true);
        }
    }
}
