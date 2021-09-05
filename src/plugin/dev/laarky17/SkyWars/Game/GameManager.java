package plugin.dev.laarky17.SkyWars.Game;

import me.DevTec.ItemCreatorAPI;
import me.DevTec.TheAPI;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Game.Cages.Cages;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

public class GameManager {
    public static void runGameManager(Player EntityPlayer) {
        if (StageManager.getGameStage == Stage.AGUARDANDO) {
            switch (TheAPI.getOnlinePlayers().size()) {
                case 1:
                    EntityPlayer.teleport(new Location(EntityPlayer.getWorld(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.1").getX(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.1").getY(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.1").getZ()));
                    Cages.buildCage(EntityPlayer, 3, Material.GLASS);
                    break;
                case 2:
                    EntityPlayer.teleport(new Location(EntityPlayer.getWorld(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.2").getX(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.2").getY(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.2").getZ()));
                    Cages.buildCage(EntityPlayer, 3, Material.GLASS);
                    break;
                case 3:
                    EntityPlayer.teleport(new Location(EntityPlayer.getWorld(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.3").getX(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.3").getY(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.3").getZ()));
                    Cages.buildCage(EntityPlayer, 3, Material.GLASS);
                    break;
                case 4:
                    EntityPlayer.teleport(new Location(EntityPlayer.getWorld(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.4").getX(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.4").getY(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.4").getZ()));
                    Cages.buildCage(EntityPlayer, 3, Material.GLASS);
                    break;
                case 5:
                    EntityPlayer.teleport(new Location(EntityPlayer.getWorld(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.5").getX(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.5").getY(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.5").getZ()));
                    Cages.buildCage(EntityPlayer, 3, Material.GLASS);
                    break;
                case 6:
                    EntityPlayer.teleport(new Location(EntityPlayer.getWorld(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.6").getX(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.6").getY(), EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spawns.6").getZ()));
                    Cages.buildCage(EntityPlayer, 3, Material.GLASS);
                    break;
            }

            ItemCreatorAPI ICChest = TheAPI.getItemCreatorAPI(Material.CHEST);
            ICChest.setDisplayName(ChatColor.YELLOW + "Habilidades");
            ICChest.addLore("");
            ICChest.addLore(ChatColor.GRAY + "Todas as habilidades do");
            ICChest.addLore(ChatColor.GRAY + "SkyWars disponíveis.");
            ICChest.addLore("");
            ICChest.addLore(ChatColor.GREEN + "Clique com o botão direito.");

            EntityPlayer.getInventory().setItem(4, ICChest.create());
        }
    }
}
