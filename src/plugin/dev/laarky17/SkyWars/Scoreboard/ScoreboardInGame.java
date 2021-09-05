package plugin.dev.laarky17.SkyWars.Scoreboard;

import me.DevTec.ScoreboardAPI;
import me.DevTec.TheAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Stage.Stages.InGame;
import plugin.dev.laarky17.SkyWars.Stage.Stages.Waiting;
import plugin.dev.laarky17.SkyWars.Utils.Utils;

public class ScoreboardInGame implements Listener {
    private static Boolean isCreated = false;
    private static ScoreboardAPI SBAPI = null;

    private static BukkitTask titleAnim = null;
    private static BukkitTask linesUpdate = null;

    public static final void runScoreboard(Player EntityPlayer) {
        if (isCreated)
            return;

        SBAPI = TheAPI.getScoreboardAPI(EntityPlayer, true, false);

        titleAnim = new BukkitRunnable() {
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
        SBAPI.setLine(8, "  ");

        linesUpdate = new BukkitRunnable() {
            @Override
            public void run() {
                if (InGame.InGameRefilTime > 0) {
                    SBAPI.setLine(10, ChatColor.WHITE + " Abastecimento");
                    SBAPI.setLine(9, ChatColor.WHITE + " de baús, em: " + ChatColor.GREEN + Utils.FormatTime(InGame.InGameRefilTime));
                }
                SBAPI.setLine(7, ChatColor.WHITE + " Restantes: " + ChatColor.GRAY + EntryPoint.getPInstance().getServer().getOnlinePlayers().size());
                SBAPI.setLine(6, ChatColor.WHITE + " Mapa: " + ChatColor.GRAY + EntityPlayer.getWorld().getName());
                SBAPI.setLine(3, ChatColor.WHITE + " Eliminações: " + ChatColor.GRAY + 0);
            }
        }.runTaskTimer(EntryPoint.getPInstance(), 0, 0);

        SBAPI.setLine(4, " ");
        SBAPI.setLine(2, "");
        SBAPI.setLine(1, ChatColor.GREEN + "   rhzgames.xyz");

        isCreated = true;
    }

    @EventHandler
    public static final void destroyScoreboard(PlayerQuitEvent Event) {
        if (!isCreated)
            return;

        Player EntityPlayer = Event.getPlayer();
        SBAPI = TheAPI.getScoreboardAPI(EntityPlayer, true, false);

        titleAnim.cancel();
        linesUpdate.cancel();
        titleAnim = null;
        linesUpdate = null;

        SBAPI.destroy();

        isCreated = false;
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
