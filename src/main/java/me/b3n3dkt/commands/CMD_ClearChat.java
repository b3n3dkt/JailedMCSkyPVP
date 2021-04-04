package me.b3n3dkt.commands;

import java.util.Iterator;

import me.b3n3dkt.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_ClearChat implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (p.hasPermission("jailedmc.command.chatclear")) {
            for(Player all : Bukkit.getOnlinePlayers()){
               for(int i = 0; i < 200; ++i) {
                     if (!all.hasPermission("jailedmc.command.chatclear.bypass")) {
                        all.sendMessage(" ");
                     }
               }
            }
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Chat wurde von §e" + p.getName() + " §7geleert!");
         } else {
            p.sendMessage(SkyPvP.getNoperm());
         }
      }

      return false;
   }
}
