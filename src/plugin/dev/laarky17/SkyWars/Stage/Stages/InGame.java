package plugin.dev.laarky17.SkyWars.Stage.Stages;

import me.DevTec.TheAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Scoreboard.Scoreboard;
import plugin.dev.laarky17.SkyWars.Scoreboard.ScoreboardInGame;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

public class InGame {
    public static InGame InGameInstance = new InGame();

    public static int InGameTime = 300;
    public static int InGameRefilTime = 90;
    public static BukkitTask InGameTimer = null;
    public static BukkitTask InGameRefilTimer = null;

    public static Boolean isForced = false;

    public static void runInGame() {
        StageManager.getGameStage = Stage.JOGO;

        for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
            Scoreboard.destroyScoreboard(EntityPlayer);
            ScoreboardInGame.runScoreboard(EntityPlayer);
        }

        InGameRefilTimer = new BukkitRunnable() {
            @Override
            public void run() {
                InGameRefilTime--;

                switch (InGameRefilTime) {
                    case 60:
                        TheAPI.broadcastMessage(ChatColor.YELLOW + "Os baús serão abastecidos, em: " + ChatColor.GRAY + "1 minuto" + ChatColor.YELLOW + ".");
                        break;
                    case 30:
                        TheAPI.broadcastMessage(ChatColor.YELLOW + "Os baús serão abastecidos, em: " + ChatColor.GRAY + "30 segundos" + ChatColor.YELLOW + ".");
                        break;
                    case 10:
                        TheAPI.broadcastMessage(ChatColor.YELLOW + "Os baús serão abastecidos, em: " + ChatColor.GRAY + "10 segundos" + ChatColor.YELLOW + ".");
                        break;
                    case 0:
                        TheAPI.broadcastMessage(ChatColor.YELLOW + "Todos os baús foram abastecidos!");

                        InGameRefilTime = 120;
                        break;
                }
            }
        }.runTaskTimer(EntryPoint.getPInstance(), 0, 20);
    }
}
