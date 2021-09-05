package plugin.dev.laarky17.SkyWars.Events;

import me.DevTec.GUI.GUICreatorAPI;
import me.DevTec.TheAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerInteractEvent;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

public class InteractEvent implements Listener {
    @EventHandler
    private final void onInteract(PlayerInteractEvent Event) {
        Player EntityPlayer = Event.getPlayer();

        if (StageManager.getGameStage == Stage.AGUARDANDO) {
            if (EntityPlayer.getInventory().getItemInHand().getType() == Material.CHEST) {
                if (EntityPlayer.getInventory().getItemInHand().hasItemMeta()) {
                    if (EntityPlayer.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Habilidades")) {
                        GUICreatorAPI GCKits = new GUICreatorAPI(ChatColor.YELLOW + "Habilidades", 54, EntityPlayer) {
                            @Override
                            public void onClose(Player player) {
                            }
                        };

                        GCKits.open(EntityPlayer);
                    }
                }
            }
        }
    }
}