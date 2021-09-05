package plugin.dev.laarky17.SkyWars.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import plugin.dev.laarky17.SkyWars.EntryPoint;

public class QuitEvent implements Listener {
    @EventHandler
    private final void onQuit(PlayerQuitEvent Event) {
        Player EntityPlayer = Event.getPlayer();

        Event.setQuitMessage(ChatColor.GRAY + EntityPlayer.getDisplayName() + ChatColor.GREEN + " desconectou-se à partida " + ChatColor.GRAY + "(" + ChatColor.GREEN + EntryPoint.getPInstance().getServer().getOnlinePlayers().size() + ChatColor.GRAY + "/" + ChatColor.GREEN + EntryPoint.getPInstance().getServer().getMaxPlayers() + ChatColor.GRAY + ").");
    }
}
