package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.Inventorys;
import me.b3n3dkt.utils.Utility;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CMD_EnderChest implements CommandExecutor {

   public static ArrayList<Player> inEc = new ArrayList<>();

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (args.length == 0) {
            Inventorys.openEnderChest(p);
         } else if(args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null){
               if(target.getName().equalsIgnoreCase(p.getName())){
                  Inventorys.openEnderChest(p);
                  return true;
               }
               Inventorys.openOtherEnderChest(p, target);
               inEc.add(p);
               p.sendMessage(SkyPvP.getPrefix() + "§7Du siehst nun die Enderchest von §8'§e" + target.getName() +"§8'§7.");
            }else{
               OfflinePlayer ot = Bukkit.getOfflinePlayer(Utility.getUUIDFromName(args[0]));
               if(MySQL.isRegistered(ot.getUniqueId().toString()) == true){
                  Inventorys.openOtherEnderChest(p, (Player) ot);
                  inEc.add(p);
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du siehst nun die Enderchest von §8'§e" + ot.getName() +"§8'§7.");
               }else{
                  p.sendMessage(SkyPvP.getPrefix() + "§cDer Spieler war noch nie auf diesem Server!");
               }
            }
         }else{
            p.sendMessage(SkyPvP.getPrefix() + "§cNutze /enderchest <Spieler>");
         }
      }

      return false;
   }
}
