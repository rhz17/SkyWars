package plugin.dev.laarky17.SkyWars.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

public class BreakEvent implements Listener {
    @EventHandler
    private final void onBreak(BlockBreakEvent Event) {
        if (StageManager.getGameStage == Stage.AGUARDANDO) {
            Event.setCancelled(true);
        }
    }
}
