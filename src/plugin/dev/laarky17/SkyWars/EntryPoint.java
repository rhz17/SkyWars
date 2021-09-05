package plugin.dev.laarky17.SkyWars;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.dev.laarky17.SkyWars.Commands.SkyWarsCommand;
import plugin.dev.laarky17.SkyWars.Database.Database;
import plugin.dev.laarky17.SkyWars.Events.*;
import plugin.dev.laarky17.SkyWars.Game.GameSettings;
import plugin.dev.laarky17.SkyWars.Scoreboard.Scoreboard;
import plugin.dev.laarky17.SkyWars.Scoreboard.ScoreboardInGame;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;

import java.io.File;
import java.io.IOException;

public class EntryPoint extends JavaPlugin {
    private static EntryPoint PInstance = null;
    public static EntryPoint getPInstance() {
        return PInstance;
    }

    private File configFile = new File(this.getDataFolder(), "skywars.yml");
    private FileConfiguration configConfig = YamlConfiguration.loadConfiguration(this.getConfigFile());

    public File getConfigFile() {
        return configFile;
    }
    public FileConfiguration getConfigConfig() {
        return configConfig;
    }

    private File databaseFile = new File(this.getDataFolder(), "database.yml");
    private FileConfiguration databaseConfig = YamlConfiguration.loadConfiguration(this.getDatabaseFile());

    public File getDatabaseFile() {
        return databaseFile;
    }
    public FileConfiguration getDatabaseConfig() {
        return databaseConfig;
    }

    @Override
    public void onLoad() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SKYWARS] Carregando...");

        if (!this.getConfigFile().exists() || !this.getDatabaseFile().exists()){
            saveResource("skywars.yml", false);
            saveResource("database.yml", false);
        }
        else {
            try {
                this.getConfigConfig().save(this.getConfigFile());
                this.getDatabaseConfig().save(this.getDatabaseFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onEnable() {
        try {
            if (this.getServer().getPluginManager().getPlugin("TheAPI") == null) {
                this.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[SKYWARS] TheAPI não encontrado!");
                this.getServer().getPluginManager().disablePlugin(this);
            } else {
                this.PInstance = this;

                World mapWorld = EntryPoint.getPInstance().getServer().getWorld("World");
                mapWorld.setAutoSave(false);

                this.getServer().getPluginManager().registerEvents(new BreakEvent(), this);
                this.getServer().getPluginManager().registerEvents(new BurnEvent(), this);
                this.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
                this.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
                this.getServer().getPluginManager().registerEvents(new FoodEvent(), this);
                this.getServer().getPluginManager().registerEvents(new IgniteEvent(), this);
                this.getServer().getPluginManager().registerEvents(new InteractEvent(), this);
                this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
                this.getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
                this.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
                this.getServer().getPluginManager().registerEvents(new Scoreboard(), this);
                this.getServer().getPluginManager().registerEvents(new ScoreboardInGame(), this);

                this.getCommand("skywars").setExecutor(new SkyWarsCommand());

                Database.openSQLConnection();

                GameSettings.runGameSettings();
                StageManager.runGameStage();

                this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SKYWARS] Finalizado!");
            }
        } catch (NullPointerException | ReflectiveOperationException Ex) {
            Ex.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        try {
            if (this.getServer().getPluginManager().getPlugin("TheAPI") == null) {
                this.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[SKYWARS] TheAPI não encontrado!");
                this.getServer().getPluginManager().disablePlugin(this);
            } else {
                World mapWorld = EntryPoint.getPInstance().getServer().getWorld("World");
                mapWorld.setAutoSave(false);

                this.PInstance = null;
                HandlerList.unregisterAll(new BreakEvent());
                HandlerList.unregisterAll(new BurnEvent());
                HandlerList.unregisterAll(new DamageEvent());
                HandlerList.unregisterAll(new DeathEvent());
                HandlerList.unregisterAll(new FoodEvent());
                HandlerList.unregisterAll(new IgniteEvent());
                HandlerList.unregisterAll(new InteractEvent());
                HandlerList.unregisterAll(new JoinEvent());
                HandlerList.unregisterAll(new PlaceEvent());
                HandlerList.unregisterAll(new QuitEvent());
                HandlerList.unregisterAll(new Scoreboard());
                HandlerList.unregisterAll(new ScoreboardInGame());

                this.getCommand("skywars").setExecutor(null);

                Database.closeSQLConnection();

                this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SKYWARS] Finalizado!");
            }
        } catch (NullPointerException Ex) {
            Ex.printStackTrace();
        }
    }
}
