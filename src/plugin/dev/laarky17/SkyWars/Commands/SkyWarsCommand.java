package plugin.dev.laarky17.SkyWars.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.dev.laarky17.SkyWars.EntryPoint;
import plugin.dev.laarky17.SkyWars.Stage.Stage;
import plugin.dev.laarky17.SkyWars.Stage.StageManager;
import plugin.dev.laarky17.SkyWars.Stage.Stages.Waiting;

import java.io.IOException;

public class SkyWarsCommand implements CommandExecutor {
    private int playerNumber = 0;
    private int chestNumber = 0;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String cmdName, String[] cmdArgs) {
        if (commandSender instanceof Player) {
            Player EntityPlayer = (Player) commandSender;
            if (cmdName.equalsIgnoreCase("skywars")) {
                if (EntityPlayer.isOp()) {
                    if (cmdArgs.length == 0) {
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars game " + ChatColor.GRAY + "(possibilita ou impede o início da partida)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars minp <quantidade> " + ChatColor.GRAY + "(mínimo de jogadores em uma partida)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars maxp <quantidade> " + ChatColor.GRAY + "(máximo de jogadores em uma partida)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars killxp <quantidade> " + ChatColor.GRAY + "(quantidade de xp recebida em uma eliminação)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars deathxp <quantidade> " + ChatColor.GRAY + "(quantidade de xp perdida em uma morte)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars spawn " + ChatColor.GRAY + "(localização de spawn dos jogadores)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars chest " + ChatColor.GRAY + "(localização de spawn dos baús)" + ChatColor.LIGHT_PURPLE + ".");
                        EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars spectator " + ChatColor.GRAY + "(localização de spawn dos espectadores)" + ChatColor.LIGHT_PURPLE + ".");
                        return true;
                    } else {
                        if (cmdArgs[0].equalsIgnoreCase("game")) {
                            if (StageManager.getGameStage == Stage.AGUARDANDO) {
                                if (!Waiting.isForced) {
                                    Waiting.isForced = true;
                                    EntityPlayer.sendMessage(ChatColor.GREEN + "A partida foi forçada à iniciar!");
                                    return true;
                                } else {
                                    Waiting.isForced = false;
                                    EntityPlayer.sendMessage(ChatColor.GREEN + "A partida foi parada à iniciar!");
                                    return true;
                                }
                            } else {
                                EntityPlayer.sendMessage(ChatColor.RED + "A partida já está em andamento!");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("minp")) {
                            Integer minP = Integer.valueOf(cmdArgs[1]);
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.min-players", minP);

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Quantidade mínima de jogadores alterada para " + minP + ".");
                                return true;
                            } catch (IOException Ex) {
                                Ex.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível alterar a quantidade mínima de jogadores.");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("maxp")) {
                            Integer maxP = Integer.valueOf(cmdArgs[1]);
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.max-players", maxP);

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Quantidade máxima de jogadores alterada para " + maxP + ".");
                                return true;
                            } catch (IOException Ex) {
                                Ex.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível alterar a quantidade máxima de jogadores.");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("killxp")) {
                            Integer killXP = Integer.valueOf(cmdArgs[1]);
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.level.kill-xp", killXP);

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Quantidade de XP adquirida à cada eliminação alterada para " + killXP + ".");
                                return true;
                            } catch (IOException Ex) {
                                Ex.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível alterar a quantidade de XP adquirida.");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("deathxp")) {
                            Integer deathXP = Integer.valueOf(cmdArgs[1]);
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.level.death-xp", deathXP);

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Quantidade de XP perdida à cada morte alterada para " + deathXP + ".");
                                return true;
                            } catch (IOException Ex) {
                                Ex.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível alterar a quantidade de XP perdida.");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("spawn")) {
                            playerNumber += 1;

                            Location playerLoc = EntityPlayer.getLocation();
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.spawns." + playerNumber, playerLoc.toVector());

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Spawn do jogador " + playerNumber + " adicionado, em: " + playerLoc.toVector() + ".");
                                return true;
                            } catch (IOException e) {
                                e.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível adicionar o spawn daquele jogador.");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("chest")) {
                            chestNumber += 1;

                            Location playerLoc = EntityPlayer.getLocation();
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.chests." + chestNumber, playerLoc.toVector());

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Baú " + chestNumber + " adicionado, em: " + playerLoc.toVector() + ".");
                                return true;
                            } catch (IOException e) {
                                e.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível adicionar aquele baú.");
                                return true;
                            }
                        } else if (cmdArgs[0].equalsIgnoreCase("spectator")) {
                            Location playerLoc = EntityPlayer.getLocation();
                            EntryPoint.getPInstance().getConfigConfig().set("skywars.spec-spawn", playerLoc.toVector());

                            try {
                                EntryPoint.getPInstance().getConfigConfig().save(EntryPoint.getPInstance().getConfigFile());
                                EntityPlayer.sendMessage(ChatColor.GREEN + "Spawn do espectador adicionado, em: " + playerLoc.toVector() + ".");
                                return true;
                            } catch (IOException e) {
                                e.printStackTrace();
                                EntityPlayer.sendMessage(ChatColor.RED + "Não foi possível adicionar aquele spawn do espectador.");
                                return true;
                            }
                        } else {
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars game " + ChatColor.GRAY + "(possibilita ou impede o início da partida)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars minp <quantidade> " + ChatColor.GRAY + "(mínimo de jogadores em uma partida)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars maxp <quantidade> " + ChatColor.GRAY + "(máximo de jogadores em uma partida)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars killxp <quantidade> " + ChatColor.GRAY + "(quantidade de xp recebida em uma eliminação)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars deathxp <quantidade> " + ChatColor.GRAY + "(quantidade de xp perdida em uma morte)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars spawn " + ChatColor.GRAY + "(localização de spawn dos jogadores)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars chest " + ChatColor.GRAY + "(localização de spawn dos baús)" + ChatColor.LIGHT_PURPLE + ".");
                            EntityPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "/skywars spectator " + ChatColor.GRAY + "(localização de spawn dos espectadores)" + ChatColor.LIGHT_PURPLE + ".");
                            return true;
                        }
                    }
                } else {
                    EntityPlayer.sendMessage(ChatColor.RED + "Comando inexistente!");
                    return true;
                }
            }
        } else {
            commandSender.sendMessage(ChatColor.YELLOW + "Impossível executar comandos!");
            return true;
        }

        return false;
    }
}
