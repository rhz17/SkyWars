package plugin.dev.laarky17.SkyWars.Game.Chests;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Chests {
    public static final void fillChests(World EntityWorld) {
        for (Chunk C : EntityWorld.getLoadedChunks()) {
            for (BlockState BS : C.getTileEntities()) {
                if (BS instanceof Chest) {
                    Chest GetChest = (Chest) BS;
                    Inventory ChestInv = GetChest.getBlockInventory();

                    Material[] BlockItems = {Material.WOOD, Material.STONE, Material.SPONGE};
                    Material[] WeaponItems = {Material.DIAMOND_SWORD, Material.IRON_CHESTPLATE, Material.IRON_BOOTS, Material.IRON_HELMET, Material.IRON_LEGGINGS, Material.BOW, Material.ARROW, Material.DIAMOND_CHESTPLATE};
                    Random rand = new Random();

                    /*for (int i = 1; i <= BlockItems.length; i++) {
                        ChestInv.addItem(new ItemStack(BlockItems[rand.nextInt(BlockItems.length)], randInt(1, 2)));
                    }

                    for (int i = 1; i <= WeaponItems.length; i++) {
                        ChestInv.addItem(new ItemStack(WeaponItems[rand.nextInt(WeaponItems.length)], randInt(1, 2)));
                    }*/

                    ChestInv.clear();
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(BlockItems[0], rand.nextInt(5)));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(BlockItems[1], rand.nextInt(5)));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(BlockItems[2], rand.nextInt(5)));

                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[0], 1));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[1], 1));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[2], 1));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[3], 1));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[4], 1));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[5], 1));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[6], 16));
                    ChestInv.setItem(rand.nextInt(27), new ItemStack(WeaponItems[7], 1));
                }
            }
        }
    }
}