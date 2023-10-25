package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;

public class onBlockBurnsListener implements Listener {
    @EventHandler
    public void onBlockBurns(BlockBurnEvent event) {
        event.setCancelled(true);
    }
}
