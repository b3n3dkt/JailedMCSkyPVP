package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Feed implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (p.hasPermission("jailedmc.command.feed")) {
            if (args.length == 0) {
               p.setFoodLevel(20);
               p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dich gefüttert!");
            } else if (args.length == 1) {
               Player t = Bukkit.getPlayer(args[0]);
               if (t != null) {
                  t.setFoodLevel(20);
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast §8'§3" + t.getName() + "§8' §7gefüttert!");
                  t.sendMessage(SkyPvP.getPrefix() + "§7Du wurdest von §8'§3" + p.getName() + "§8' §7gefüttert!");
               } else {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDer angegebene Spieler ist nicht online!");
               }
            } else if (args.length != 0 || args.length != 1) {
               p.sendMessage(SkyPvP.getPrefix() + "§cNutze /feed <Spieler>!");
            }
         } else {
            p.sendMessage(SkyPvP.getNoperm());
         }
      }

      return false;
   }
}
