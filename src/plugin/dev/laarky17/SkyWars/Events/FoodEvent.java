package plugin.dev.laarky17.SkyWars.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

public class FoodEvent implements Listener {
    @EventHandler
    private final void onFood(FoodLevelChangeEvent Event) {
        if (StageManager.getGameStage == Stage.AGUARDANDO) {
            Event.setCancelled(true);
        }
    }
}
