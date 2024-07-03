package org.fallen.terrainpreserver.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class onPlayerWorldDamageListener implements Listener {
    @EventHandler
    public void onPlayerWorldDamage(EntityDamageEvent event) {
        if (event.getCause() != EntityDamageEvent.DamageCause.SUFFOCATION) {
            getLogger().info("Entity Damaged! Cause: " + event.getCause() + ", Entity: " + event.getEntity());
        }

        List<EntityDamageEvent.DamageCause> excludedCauses = List.of(EntityDamageEvent.DamageCause.FALL,
                                                                     EntityDamageEvent.DamageCause.DROWNING,
                                                                     EntityDamageEvent.DamageCause.HOT_FLOOR,
                                                                     EntityDamageEvent.DamageCause.SUFFOCATION);

        if (event.getEntity() instanceof Player) {
            if (excludedCauses.contains(event.getCause())) {
                event.setCancelled(true);
            }
        } else {
            if (event.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR) {
                event.setCancelled(true);
            }
        }
    }
}
