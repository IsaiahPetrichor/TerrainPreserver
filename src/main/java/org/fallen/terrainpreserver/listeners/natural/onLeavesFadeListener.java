package org.fallen.terrainpreserver.listeners.natural;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class onLeavesFadeListener implements Listener {
    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        event.setCancelled(true);
    }
}
