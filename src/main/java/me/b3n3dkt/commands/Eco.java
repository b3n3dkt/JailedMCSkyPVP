package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.Score;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Eco implements CommandExecutor {
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender.hasPermission("jailedmc.command.eco")) {

                if (args.length != 3) {
                    sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§cNutze /eco <add/set/remove> <Spieler> <Anzahl>!");
                } else if (args.length == 3) {

                    OfflinePlayer offlinetarget = Bukkit.getOfflinePlayer(args[1]);
                    String uuid = offlinetarget.getUniqueId().toString();
                    Score sb = new Score((Player) offlinetarget);
                    Player t = Bukkit.getPlayer(args[1]);
                    Double amount = Double.valueOf(Double.parseDouble(args[2]));

                    if (args[0].equalsIgnoreCase("add")) {
                        if (MySQL.isRegistered(uuid)) {
                            Double money = Double.valueOf(MySQL.getcoins(uuid) + amount);
                            MySQL.setcoins(uuid, money);
                            sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§7Der Kontostand von dem Spieler §8'§e" + offlinetarget.getName() + "§8' §7beträgt nun §8'§e" + money + "$§8'§7!");
                            if (t != null) {
                                sb.update();
                            }
                        } else {
                            sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§cDer Angegebene Spieler ist nicht registriert!");
                        }
                    } else if (args[0].equalsIgnoreCase("set")) {
                        if (MySQL.isRegistered(uuid)) {
                            MySQL.setcoins(uuid, amount);
                            sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§7Der Kontostand von dem Spieler §8'§e" + offlinetarget.getName() + "§8' §7beträgt nun §8'§e" + amount + "$§8'§7!");
                            if (t != null) {
                                sb.update();
                            }
                        } else {
                            sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§cDer Angegebene Spieler ist nicht registriert!");
                        }
                    } else if (args[0].equalsIgnoreCase("remove")) {
                        if (MySQL.isRegistered(uuid)) {
                            Double money = Double.valueOf(MySQL.getcoins(uuid) - amount);
                            MySQL.setcoins(uuid, money);
                            sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§7Der Kontostand von dem Spieler §8'§e" + offlinetarget.getName() + "§8' §7beträgt nun §8'§e" + money + "$§8'§7!");
                            if (t != null) {
                                sb.update();
                            }
                        } else {
                            sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§cDer Angegebene Spieler ist nicht registriert!");
                        }
                    } else {
                        sender.sendMessage(String.valueOf(SkyPvP.getPrefix()) + "§cNutze bitte /eco <add/set/remove> <Spieler> <Anzahl>!");
                    }
                }
            } else {
                sender.sendMessage(SkyPvP.getNoperm());
            }

        return false;
    }
}
