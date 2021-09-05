package plugin.dev.laarky17.SkyWars.Game;

import plugin.dev.laarky17.SkyWars.EntryPoint;

import java.lang.reflect.Field;

public class GameSettings {
    public static final void runGameSettings() throws ReflectiveOperationException {
        int maxP = EntryPoint.getPInstance().getConfigConfig().getInt("skywars.max-players");

        String BV = EntryPoint.getPInstance().getServer().getClass().getPackage().getName().substring(23);
        Object PL = Class.forName("org.bukkit.craftbukkit." + BV + ".CraftServer").getDeclaredMethod("getHandle", null).invoke(EntryPoint.getPInstance().getServer(), null);
        Field MP = PL.getClass().getSuperclass().getDeclaredField("maxPlayers");

        MP.setAccessible(true);
        MP.set(PL, maxP);
    }
}
