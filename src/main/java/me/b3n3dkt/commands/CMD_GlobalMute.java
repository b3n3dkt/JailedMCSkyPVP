package me.b3n3dkt.commands;

import java.util.Iterator;

import me.b3n3dkt.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_GlobalMute implements CommandExecutor {
   public static boolean globalmute = false;

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
         if(sender.hasPermission("jailedmc.command.globalmute")){
            if(args.length == 0){
               if(globalmute == true){
                  for(Player all : Bukkit.getOnlinePlayers()){
                     globalmute = false;
                     all.sendMessage(SkyPvP.getPrefix() + "§7Der Chat wurde §aaktiviert§7!");
                  }
               }else if(globalmute == false){
                  for(Player all : Bukkit.getOnlinePlayers()){
                     globalmute = true;
                     all.sendMessage(SkyPvP.getPrefix() + "§7Der Chat wurde §4deaktiviert§7!");
                  }
               }
            }else{
               sender.sendMessage(SkyPvP.getPrefix() + "§cNutze bitte /globalmute");
            }
         }else{
            sender.sendMessage(SkyPvP.getNoperm());
         }

      return false;
   }
}
