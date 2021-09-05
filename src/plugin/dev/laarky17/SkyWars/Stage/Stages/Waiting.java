package plugin.dev.laarky17.SkyWars.Stage.Stages;

import me.DevTec.TheAPI;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Game.Cages.Cages;
import plugin.dev.laarky17.SkyWars.Game.Chests.Chests;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;
import plugin.dev.laarky17.SkyWars.Utils.GameUtils;

public class Waiting {
    public static Waiting WaitingInstance = new Waiting();

    public static int WaitingTime = 15;
    public static BukkitTask WaitingTimer = null;

    public static Boolean isForced = false;

    public static void runWaiting() {
        StageManager.getGameStage = Stage.AGUARDANDO;

        WaitingTimer = new BukkitRunnable() {
            int minP = EntryPoint.getPInstance().getConfigConfig().getInt("skywars.min-players");

            @Override
            public void run() {
                if (TheAPI.getOnlinePlayers().size() >= this.minP || isForced) {
                    WaitingTime--;

                    switch (WaitingTime) {
                        case 10:
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                TheAPI.sendTitle(EntityPlayer, "", ChatColor.RED + "" + ChatColor.BOLD + "10");
                                EntityPlayer.playSound(EntityPlayer.getLocation(), Sound.ANVIL_LAND, 10, 10);
                            }
                            TheAPI.broadcastMessage(ChatColor.YELLOW + "A partida irá iniciar, em: " + ChatColor.GRAY + "10 segundos" + ChatColor.YELLOW + ".");
                            break;
                        case 5:
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                TheAPI.sendTitle(EntityPlayer, "", ChatColor.RED + "" + ChatColor.BOLD + "5");
                                EntityPlayer.playSound(EntityPlayer.getLocation(), Sound.ANVIL_LAND, 10, 10);
                            }
                            TheAPI.broadcastMessage(ChatColor.YELLOW + "A partida irá iniciar, em: " + ChatColor.GRAY + "5 segundos" + ChatColor.YELLOW + ".");
                            break;
                        case 4:
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                TheAPI.sendTitle(EntityPlayer, "", ChatColor.RED + "" + ChatColor.BOLD + "4");
                                EntityPlayer.playSound(EntityPlayer.getLocation(), Sound.ANVIL_LAND, 10, 10);
                            }
                            TheAPI.broadcastMessage(ChatColor.YELLOW + "A partida irá iniciar, em: " + ChatColor.GRAY + "4 segundos" + ChatColor.YELLOW + ".");
                            break;
                        case 3:
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                TheAPI.sendTitle(EntityPlayer, "", ChatColor.RED + "" + ChatColor.BOLD + "3");
                                EntityPlayer.playSound(EntityPlayer.getLocation(), Sound.ANVIL_LAND, 10, 10);
                            }
                            TheAPI.broadcastMessage(ChatColor.YELLOW + "A partida irá iniciar, em: " + ChatColor.GRAY + "3 segundos" + ChatColor.YELLOW + ".");
                            break;
                        case 2:
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                TheAPI.sendTitle(EntityPlayer, "", ChatColor.RED + "" + ChatColor.BOLD + "2");
                                EntityPlayer.playSound(EntityPlayer.getLocation(), Sound.ANVIL_LAND, 10, 10);
                            }
                            TheAPI.broadcastMessage(ChatColor.YELLOW + "A partida irá iniciar, em: " + ChatColor.GRAY + "2 segundos" + ChatColor.YELLOW + ".");
                            break;
                        case 1:
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                TheAPI.sendTitle(EntityPlayer, "", ChatColor.RED + "" + ChatColor.BOLD + "1");
                                EntityPlayer.playSound(EntityPlayer.getLocation(), Sound.ANVIL_LAND, 10, 10);
                            }
                            TheAPI.broadcastMessage(ChatColor.YELLOW + "A partida irá iniciar, em: " + ChatColor.GRAY + "1 segundo" + ChatColor.YELLOW + ".");
                            break;
                        case 0:
                            TheAPI.broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "ATENÇÃO " + ChatColor.RESET + ChatColor.YELLOW + "cross-teaming em SkyWars Solo resultará em banimentos, sem aviso prévio!");
                            
                            for (Player EntityPlayer : EntryPoint.getPInstance().getServer().getOnlinePlayers()) {
                                Cages.destroyCage(EntityPlayer, 3);
                                GameUtils.playerRestore(EntityPlayer);
                            }

                            Chests.fillChests(EntryPoint.getPInstance().getServer().getWorld("World"));
                            InGame.runInGame();

                            this.cancel();
                            break;
                    }
                } else
                    WaitingTime = 15;
            }
        }.runTaskTimer(EntryPoint.getPInstance(), 0, 20);
    }
}
