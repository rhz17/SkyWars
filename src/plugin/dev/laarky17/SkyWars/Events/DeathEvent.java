package plugin.dev.laarky17.SkyWars.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Utils.GameUtils;

public class DeathEvent implements Listener {
    @EventHandler
    private final void onDeath(PlayerDeathEvent Event) {
        Event.setDeathMessage(ChatColor.GRAY + Event.getEntity().getDisplayName() + ChatColor.YELLOW + " foi eliminado por " + ChatColor.GRAY + Event.getEntity().getLastDamageCause().getCause().name() + ChatColor.YELLOW + ".");
        Event.getEntity().sendMessage(ChatColor.YELLOW + "-" + ChatColor.LIGHT_PURPLE + EntryPoint.getPInstance().getConfigConfig().get("skywars.level.death-xp") + ChatColor.YELLOW + " pontos de nível.");
        GameUtils.playerSpectator(Event.getEntity());

        /*Player EntityDeath = Event.getEntity();
        Player EntityKiller = Event.getEntity().getKiller();

        if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado por " + ChatColor.GRAY + EntityKiller.getName() + ChatColor.YELLOW + ".");
        else if (EntityKiller.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.PROJECTILE)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado por um" + ChatColor.GRAY + "projétil" + ChatColor.YELLOW + ".");
        else if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUFFOCATION)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado" + ChatColor.GRAY + "sufocado" + ChatColor.YELLOW + ".");
        else if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado por " + ChatColor.GRAY + "dano de queda" + ChatColor.YELLOW + ".");
        else if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado por " + ChatColor.GRAY + "dano de queda" + ChatColor.YELLOW + ".");
        else if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado " + ChatColor.GRAY + "queimado" + ChatColor.YELLOW + ".");
        else if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado pela " + ChatColor.GRAY + "lava" + ChatColor.YELLOW + ".");
        else if (EntityDeath.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.VOID)
            Event.setDeathMessage(ChatColor.GRAY + EntityDeath.getName() + ChatColor.YELLOW + " foi eliminado no " + ChatColor.GRAY + "void" + ChatColor.YELLOW + ".");

        EntityKiller.sendMessage(ChatColor.YELLOW + "+" + ChatColor.GRAY + EntryPoint.getPInstance().getConfigConfig().get("skywars.level.kill-xp") + ChatColor.YELLOW + " pontos de nível.");*/
    }
}