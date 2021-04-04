package me.b3n3dkt.listener;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.Inventorys;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract_EnderChest implements Listener {
   @EventHandler
   public void onHandle(PlayerInteractEvent e) {
      final Player p = e.getPlayer();
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
         if (e.getClickedBlock().getType() == Material.ENDER_CHEST) {
            Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
               public void run() {
                  Inventorys.openEnderChest(p);
               }
            }, 1L);
         } else {
            e.setCancelled(false);
         }
      }

   }
}
