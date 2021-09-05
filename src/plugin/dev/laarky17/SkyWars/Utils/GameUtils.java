package plugin.dev.laarky17.SkyWars.Utils;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import plugin.dev.laarky17.SkyWars.EntryPoint;

public class GameUtils {
    public static final void playerRestore(Player EntityPlayer) {
        EntityPlayer.setGameMode(GameMode.SURVIVAL);

        EntityPlayer.getInventory().clear();
        EntityPlayer.getInventory().setArmorContents(null);

        EntityPlayer.setHealth(20);
        EntityPlayer.setFoodLevel(20);
    }

    public static final void playerSpectator(Player EntityPlayer) {
        EntityPlayer.spigot().respawn();

        EntityPlayer.setGameMode(GameMode.SPECTATOR);

        EntityPlayer.getInventory().clear();
        EntityPlayer.getInventory().setArmorContents(null);

        EntityPlayer.setHealth(20);
        EntityPlayer.setFoodLevel(20);

        Vector locVec = EntryPoint.getPInstance().getConfigConfig().getVector("skywars.spec-spawn");
        Location locSpec = locVec.toLocation(EntityPlayer.getWorld());
        EntityPlayer.teleport(locSpec);
    }
}
