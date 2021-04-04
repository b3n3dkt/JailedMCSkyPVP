package me.b3n3dkt.listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
   @EventHandler
   public void onHandle(BlockPlaceEvent e) {
      if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
         e.setCancelled(true);
      }

   }
}
