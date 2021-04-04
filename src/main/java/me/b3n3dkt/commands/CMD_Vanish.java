package me.b3n3dkt.commands;

import java.util.Iterator;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Vanish implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (p.hasPermission("jailedmc.command.vanish")) {
            if (args.length == 0) {
               PlayerData data = new PlayerData(p.getUniqueId());
               if (data.getVanish()) {
                  data.setUnVanished();
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du bist nun §cnicht §7mehr im Vanish!");
                  for(Player all : Bukkit.getOnlinePlayers()){
                     all.showPlayer(p);
                  }
               } else if (!data.getVanish()) {
                  data.setVanished();
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du bist nun §aim §7Vanish!");
                  for(Player all : Bukkit.getOnlinePlayers()){
                     all.hidePlayer(p);
                  }
               }
            } else if (args.length == 1) {
               Player t = Bukkit.getPlayer(args[0]);
               if (t != null) {
                  PlayerData tdata = new PlayerData(t.getUniqueId());
                  if (tdata.getVanish()) {
                     tdata.setUnVanished();
                     p.sendMessage(SkyPvP.getPrefix() + "§7Der Spieler §8'§3" + t.getName() + "§8' §7ist nun §cnicht §7mehr im Vanish!");
                     t.sendMessage(SkyPvP.getPrefix() + "§7Du bist nun §cnicht §7mehr im Vanish!");
                     for(Player all : Bukkit.getOnlinePlayers()){
                        all.showPlayer(t);
                     }
                  } else if (!tdata.getVanish()) {
                     tdata.setVanished();
                     p.sendMessage(SkyPvP.getPrefix() + "§7Der Spieler §8'§e" + t.getName() + "§8' §7ist nun §aim §7Vanish!");
                     t.sendMessage(SkyPvP.getPrefix() + "§7Du bist nun §aim §7Vanish!");
                     for(Player all : Bukkit.getOnlinePlayers()){
                        all.hidePlayer(t);
                     }
                  }
               } else {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDer Spieler ist nicht online!");
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cNutze/vanish <Spieler>");
            }
         } else {
            p.sendMessage(SkyPvP.getNoperm());
         }
      }

      return false;
   }
}
