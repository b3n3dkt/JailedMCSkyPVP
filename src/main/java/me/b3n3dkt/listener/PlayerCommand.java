package me.b3n3dkt.listener;

import me.b3n3dkt.SkyPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommand implements Listener {
   @EventHandler
   public void onAntiPlugins(PlayerCommandPreprocessEvent e) {
      Player p = e.getPlayer();
      if (!e.getMessage().equalsIgnoreCase("/pl") && !e.getMessage().equalsIgnoreCase("/plugins") && !e.getMessage().equalsIgnoreCase("/bukkit") && !e.getMessage().equalsIgnoreCase("/?") && !e.getMessage().equalsIgnoreCase("/help") && !e.getMessage().equalsIgnoreCase("/bukkit:help") && !e.getMessage().equalsIgnoreCase("/reload") && !e.getMessage().equalsIgnoreCase("/rl")) {
      } else if (p.isOp()) {
         e.setCancelled(false);
      } else {
         e.setCancelled(true);
         p.sendMessage(SkyPvP.getNoperm());
      }

   }
}
