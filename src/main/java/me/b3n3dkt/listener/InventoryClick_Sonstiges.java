package me.b3n3dkt.listener;

import me.b3n3dkt.commands.CMD_EnderChest;
import me.b3n3dkt.commands.CMD_Invsee;
import me.b3n3dkt.utils.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClick_Sonstiges implements Listener {
   @EventHandler
   public void onClick(InventoryClickEvent e) {
      if(e.getInventory() == null){
         return;
      }
      if(e.getInventory().getTitle() == null){
         return;
      }
      if(e.getCurrentItem() == null){
         return;
      }
      if (CMD_Invsee.getuser.contains(e.getWhoClicked())) {
         if (!e.getWhoClicked().hasPermission("jailedmc.command.invsee.click")) {
            e.setCancelled(true);
         }

      }
      if(CMD_EnderChest.inEc.contains(e.getWhoClicked())){
         if(!e.getWhoClicked().hasPermission("jailedmc.command.enderchest.click")) {
            e.setCancelled(true);
         }
      }
   }

   @EventHandler
   public void onLeave(InventoryCloseEvent e) {
      if(e.getInventory().getTitle().equalsIgnoreCase("§5EnderChest")){
         EnderChest ec = new EnderChest((Player) e.getPlayer());
         ec.saveEnderChest((Player) e.getPlayer());
      }
      if (CMD_Invsee.getuser.contains(e.getPlayer())) {
         CMD_Invsee.getuser.remove(e.getPlayer());
      }
      if(CMD_EnderChest.inEc.contains(e.getPlayer())){
         CMD_EnderChest.inEc.remove(e.getPlayer());
      }

   }
}
