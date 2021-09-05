package plugin.dev.laarky17.SkyWars.Scoreboard;

import me.DevTec.ScoreboardAPI;
import me.DevTec.TheAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import plugin.dev.laarky17.SkyWars.Database.DatabaseManager;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Stage.Stages.Waiting;
import plugin.dev.laarky17.SkyWars.Utils.Utils;

public class Scoreboard implements Listener {
    private static Boolean isCreated = false;
    private static ScoreboardAPI SBAPI = null;

    private static BukkitTask titleAnim = null;
    private static BukkitTask linesUpdate = null;

    @EventHandler
    private final void runScoreboard(PlayerJoinEvent Event) {
        if (this.isCreated)
            return;

        Player EntityPlayer = Event.getPlayer();
        SBAPI = TheAPI.getScoreboardAPI(EntityPlayer, true, false);

        this.titleAnim = new BukkitRunnable() {
            int Anim = 16;

            @Override
            public void run() {
                this.Anim--;

                switch (this.Anim) {
                    case 15:
                        SBAPI.setDisplayName("§a§lSKY WARS");
                        break;
                    case 10:
                        SBAPI.setDisplayName("§a§lSKY WARS");
                        break;
                    case 9:
                        SBAPI.setDisplayName("§f§lS§a§lKY WARS");
                        break;
                    case 8:
                        SBAPI.setDisplayName("§2§lS§f§lK§a§lY WARS");
                        break;
                    case 7:
                        SBAPI.setDisplayName("§2§lSK§f§lY §a§lWARS");
                        break;
                    case 6:
                        SBAPI.setDisplayName("§2§lSKY §f§lW§a§lARS");
                        break;
                    case 5:
                        SBAPI.setDisplayName("§2§lSKY W§f§lA§a§lRS");
                        break;
                    case 4:
                        SBAPI.setDisplayName("§2§lSKY WA§f§lR§a§lS");
                        break;
                    case 3:
                        SBAPI.setDisplayName("§2§lSKY WAR§f§lS");
                        break;
                    case 2:
                        SBAPI.setDisplayName("§a§lSKY WARS");
                        break;
                    case 1:
                        SBAPI.setDisplayName("§f§lSKY WARS");
                        break;
                }

                if (this.Anim == 0)
                    this.Anim = 16;
            }
        }.runTaskTimer(EntryPoint.getPInstance(), 0, 2);

        SBAPI.setLine(11, "   ");

        this.linesUpdate = new BukkitRunnable() {
            @Override
            public void run() {
                SBAPI.setLine(10, ChatColor.WHITE + " Jogadores: " + ChatColor.GRAY + EntryPoint.getPInstance().getServer().getOnlinePlayers().size() + "/" + EntryPoint.getPInstance().getServer().getMaxPlayers());
                SBAPI.setLine(9, ChatColor.WHITE + " Mapa: " + ChatColor.GRAY + EntityPlayer.getWorld().getName());
                SBAPI.setLine(8, ChatColor.WHITE + " Nível: " + ChatColor.GRAY + DatabaseManager.getPlayerLevelName(EntityPlayer));

                if (Waiting.WaitingTime < 15) {
                    SBAPI.setLine(6, ChatColor.WHITE + " Iniciando, em: " + ChatColor.GREEN + Utils.FormatTime(Waiting.WaitingTime));
                } else {
                    SBAPI.setLine(6, ChatColor.WHITE + " Aguardando...");
                }
            }
        }.runTaskTimer(EntryPoint.getPInstance(), 0, 0);

        SBAPI.setLine(7, "  ");
        SBAPI.setLine(5, " ");
        SBAPI.setLine(4, ChatColor.GRAY + " Retorne ao lobby");
        SBAPI.setLine(3, ChatColor.GRAY + " Utilizando /lobby");
        SBAPI.setLine(2, "");
        SBAPI.setLine(1, ChatColor.GREEN + "   rhzgames.xyz");

        this.isCreated = true;
    }

    @EventHandler
    private final void destroyScoreboard(PlayerQuitEvent Event) {
        if (!this.isCreated)
            return;

        Player EntityPlayer = Event.getPlayer();
        SBAPI = TheAPI.getScoreboardAPI(EntityPlayer, true, false);

        this.titleAnim.cancel();
        this.linesUpdate.cancel();
        this.titleAnim = null;
        this.linesUpdate = null;

        SBAPI.destroy();

        this.isCreated = false;
    }

    public static final void destroyScoreboard(Player EntityPlayer) {
        if (!isCreated)
            return;

        SBAPI = TheAPI.getScoreboardAPI(EntityPlayer, true, false);

        titleAnim.cancel();
        linesUpdate.cancel();
        titleAnim = null;
        linesUpdate = null;

        SBAPI.destroy();

        isCreated = false;
    }
}
