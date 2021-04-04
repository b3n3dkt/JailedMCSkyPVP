package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.Inventorys;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Kit implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (args.length == 0) {
            Inventorys.openKits(p);
         } else {
            p.sendMessage(SkyPvP.getPrefix() + "§cBitte nutze /kit!");
         }
      }

      return false;
   }
}
