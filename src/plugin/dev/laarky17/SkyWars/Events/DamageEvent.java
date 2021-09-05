package plugin.dev.laarky17.SkyWars.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

public class DamageEvent implements Listener {
    @EventHandler
    private final void onDamage(EntityDamageEvent Event) {
        if (StageManager.getGameStage == Stage.AGUARDANDO) {
            Event.setCancelled(true);
        }
    }
}
