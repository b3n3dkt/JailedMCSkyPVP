package me.b3n3dkt.commands;

import java.util.Iterator;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.Pack;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_Pack implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (p.hasPermission("jailedmc.command.pack")) {
            if (args.length == 1) {
               if (args[0].equalsIgnoreCase("give")) {
                  if (args[0].equalsIgnoreCase("give")) {
                     p.sendMessage(SkyPvP.getPrefix() + "§7Alle Packs:");
                     for(Pack pack : Pack.getPacks()){
                        p.sendMessage("§8-§7" + pack.getName());
                     }
                  }
               } else {
                  p.sendMessage(SkyPvP.getPrefix() + "§cNutze /pack <create/delete/give> <Name>!");
               }
            } else if (args.length == 2) {
               String name = args[1];
               Pack packs = new Pack(name);
               if (args[0].equalsIgnoreCase("create")) {
                  if (!packs.packExists()) {
                     packs.create();
                     packs.setItems(p.getInventory());
                     p.sendMessage(SkyPvP.getPrefix() + "§7Du hast erfolgreich das Pack§8'§b" + name + "§8' §7erstellt!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDas Pack existiert bereits!");
                  }
               } else if (args[0].equalsIgnoreCase("delete")) {
                  if (packs.packExists()) {
                     packs.delete();
                     p.sendMessage(SkyPvP.getPrefix() + "§7Du hast erfolgreich das Pack §8'§b" + name + "§8' §7gelöscht!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDas Pack existiert nicht!");
                  }
               } else if (args[0].equalsIgnoreCase("give")) {
                  if (packs.packExists()) {
                     ItemStack display = new ItemStack(packs.getDisplayMaterial());
                     ItemMeta displaymeta = display.getItemMeta();
                     displaymeta.setLore(packs.getLore());
                     displaymeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', packs.getName()));
                     display.setItemMeta(displaymeta);
                     p.getInventory().addItem(new ItemStack[]{display});
                     p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Pack §8'§b" + name + "§8' §7gegeben!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDas Pack existiert nicht!");
                  }
               } else {
                  p.sendMessage(SkyPvP.getPrefix() + "§cNutze /pack <create/delete/give> <Name> !");
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cNutze /pack <create/delete/give> <Name>!");
            }
         } else {
            p.sendMessage(SkyPvP.getNoperm());
         }
      }

      return false;
   }
}
