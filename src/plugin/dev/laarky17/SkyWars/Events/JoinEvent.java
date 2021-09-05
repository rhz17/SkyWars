package plugin.dev.laarky17.SkyWars.Events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Game.GameData;
import plugin.dev.laarky17.SkyWars.Game.GameManager;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;
import plugin.dev.laarky17.SkyWars.Utils.GameUtils;

public class JoinEvent implements Listener {
    @EventHandler
    private final void onJoin(PlayerJoinEvent Event) {
        Player EntityPlayer = Event.getPlayer();

        if (StageManager.getGameStage == Stage.AGUARDANDO) {
            GameUtils.playerRestore(EntityPlayer);
            GameManager.runGameManager(EntityPlayer);
        } else {
            EntityPlayer.kickPlayer(ChatColor.RED + "A partida está em andamento!");
        }

        Event.setJoinMessage(ChatColor.GRAY + EntityPlayer.getDisplayName() + ChatColor.GREEN + " conectou-se à partida. " + ChatColor.GRAY + "(" + ChatColor.GREEN + EntryPoint.getPInstance().getServer().getOnlinePlayers().size() + ChatColor.GRAY + "/" + ChatColor.GREEN + EntryPoint.getPInstance().getServer().getMaxPlayers() + ChatColor.GRAY + ")");
    }
}
