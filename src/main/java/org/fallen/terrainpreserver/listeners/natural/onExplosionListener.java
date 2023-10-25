package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class onExplosionListener implements Listener {
    @EventHandler
    public void onBlockExplosion(BlockExplodeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityExplosion(EntityExplodeEvent event) {
        event.setCancelled(true);
    }
}
