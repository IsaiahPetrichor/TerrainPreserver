package org.fallen.terrainpreserver.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onPlayerDamagedByPlayerListener implements Listener {
    @EventHandler
    public void onPlayerDamagedByPlayer(EntityDamageByEntityEvent event) {
        // check if both entities involved are players, assign victim to 'player' and attacker to 'attacker'
        if (event.getEntity() instanceof Player player && event.getDamager() instanceof Player attacker) {
            // allow attack if attacker is an op unless other player is also an op
            if (!attacker.isOp() || player.isOp()) {
                event.setCancelled(true);
            }
        }
    }
}
