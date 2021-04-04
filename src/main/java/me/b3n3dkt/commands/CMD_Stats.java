package me.b3n3dkt.commands;

import java.text.DecimalFormat;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.SkyPvPStats;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Stats implements CommandExecutor {
   private static DecimalFormat df2 = new DecimalFormat("#.##");

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (args.length == 1) {
            if (args[0].equalsIgnoreCase("SkyPvP")) {
               double KD = (double) SkyPvPStats.getKills(p.getUniqueId().toString()) / (double)SkyPvPStats.getTode(p.getUniqueId().toString());
               p.sendMessage("§8§m-----§r§8(§eStats§8)§m§8-----");
               p.sendMessage("§7Money: §e" + MySQL.getcoins(p.getUniqueId().toString()));
               p.sendMessage("§7Kills: §e" + SkyPvPStats.getKills(p.getUniqueId().toString()));
               p.sendMessage("§7Tode: §e" + SkyPvPStats.getTode(p.getUniqueId().toString()));
               p.sendMessage("§7KD: §e" + df2.format(KD));
               p.sendMessage("§7Killstreak: §e" + SkyPvPStats.getKillstreak(p.getUniqueId().toString()));
               p.sendMessage("§8§m-----§r§8(§eStats§8)§m§8-----");
            } else if (args[0].equalsIgnoreCase("Citybuild")) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDer Stats Befehl von dem Spielmodus ist in bearbeitung!");
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cBitte gebe einen existierenden Spielmodus an!");
            }
         } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("SkyPvP")) {
               OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
               if (!SkyPvPStats.isUserExists(t.getUniqueId().toString())) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDer Spieler hat den Spielmodus noch nie gespielt!");
                  return true;
               }

               double KD = (double)SkyPvPStats.getKills(t.getUniqueId().toString()) / (double)SkyPvPStats.getTode(t.getUniqueId().toString());
               p.sendMessage("§8§m-----§r§8(§eStats von " + t.getName() + "§8)§m§8-----");
               p.sendMessage("§7Money: §e" + MySQL.getcoins(t.getUniqueId().toString()));
               p.sendMessage("§7Kills: §e" + SkyPvPStats.getKills(t.getUniqueId().toString()));
               p.sendMessage("§7Tode: §e" + SkyPvPStats.getTode(t.getUniqueId().toString()));
               p.sendMessage("§7KD: §e" + df2.format(KD));
               p.sendMessage("§7Killstreak: §e" + SkyPvPStats.getKillstreak(t.getUniqueId().toString()));
               p.sendMessage("§8§m-----§r§8(§eStats von " + t.getName() + "§8)§m§8-----");
            } else if (args[0].equalsIgnoreCase("Citybuild")) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDer Stats Befehl von dem Spielmodus ist in bearbeitung!");
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cBitte gebe einen existierenden Spielmodus an!");
            }
         } else {
            p.sendMessage(SkyPvP.getPrefix() + "§cNutze bitte /stats <Spielmodus> <Spieler>");
         }
      }

      return false;
   }
}
