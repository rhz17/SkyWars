package plugin.dev.laarky17.SkyWars.Game.Cages;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Cages {
    public static final void buildCage(Player EntityPlayer, int H, Material Block) {
        Location loc0 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ());
        Location loc1 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX() + 1,
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ());
        Location loc2 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX() - 1,
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ());
        Location loc3 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ() + 1);
        Location loc4 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ() - 1);
        Location loc5 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() + H, EntityPlayer.getLocation().getZ());

        loc0.getBlock().setType(Block);

        for (int i = 1; i <= H; i++) {
            loc1.add(0, 1, 0);
            loc1.getBlock().setType(Block);
        }

        for (int i = 1; i <= H; i++) {
            loc2.add(0, 1, 0);
            loc2.getBlock().setType(Block);
        }

        for (int i = 1; i <= H; i++) {
            loc3.add(0, 1, 0);
            loc3.getBlock().setType(Block);
        }

        for (int i = 1; i <= H; i++) {
            loc4.add(0, 1, 0);
            loc4.getBlock().setType(Block);
        }

        loc5.getBlock().setType(Block);
    }

    public static final void destroyCage(Player EntityPlayer, int H) {
        Location loc0 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ());
        Location loc1 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX() + 1,
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ());
        Location loc2 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX() - 1,
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ());
        Location loc3 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ() + 1);
        Location loc4 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() - 1, EntityPlayer.getLocation().getZ() - 1);
        Location loc5 = new Location(EntityPlayer.getWorld(), EntityPlayer.getLocation().getX(),
                EntityPlayer.getLocation().getY() + H, EntityPlayer.getLocation().getZ());

        loc0.getBlock().setType(Material.AIR);

        for (int i = 1; i <= H; i++) {
            loc1.add(0, 1, 0);
            loc1.getBlock().setType(Material.AIR);
        }

        for (int i = 1; i <= H; i++) {
            loc2.add(0, 1, 0);
            loc2.getBlock().setType(Material.AIR);
        }

        for (int i = 1; i <= H; i++) {
            loc3.add(0, 1, 0);
            loc3.getBlock().setType(Material.AIR);
        }

        for (int i = 1; i <= H; i++) {
            loc4.add(0, 1, 0);
            loc4.getBlock().setType(Material.AIR);
        }

        loc5.getBlock().setType(Material.AIR);
    }
}
