package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Money implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){
                double coins = MySQL.getcoins(player.getUniqueId().toString());
                player.sendMessage(SkyPvP.getPrefix() + "§7Du hast §8'§e" + coins +"§8' §7Coins.");
            }else if(args.length == 1){
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                if(MySQL.isRegistered(offlinePlayer.getUniqueId().toString()) == true){
                    double coins = MySQL.getcoins(offlinePlayer.getUniqueId().toString());
                    player.sendMessage(SkyPvP.getPrefix() + "§7Der Spieler §8'§e" + offlinePlayer.getName() + "§8' §7hat §8'§e" + coins + "§8' §7Coins.");
                }else{
                    player.sendMessage(SkyPvP.getPrefix() + "§cDer Spieler existiert nicht!");
                }
               }else{
                player.sendMessage(SkyPvP.getPrefix() + "§cNutze /money <Spieler>");
            }
        }else{
            if(args.length == 1){
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                if(MySQL.isRegistered(offlinePlayer.getUniqueId().toString()) == true){
                    double coins = MySQL.getcoins(offlinePlayer.getUniqueId().toString());
                    Bukkit.getConsoleSender().sendMessage(SkyPvP.getPrefix() + "§7Der Spieler §8'§e" + offlinePlayer.getName() + "§8' §7hat §8'§e" + coins + "§8' §7Coins.");

                }else{
                    Bukkit.getConsoleSender().sendMessage(SkyPvP.getPrefix() + "§cDer Spieler existiert nicht!");
                }
            }else{
                Bukkit.getConsoleSender().sendMessage(SkyPvP.getPrefix() + "§cSynatx: /money <Spieler>");
            }
        }
        return false;
    }
}
