package me.b3n3dkt.utils;

import java.util.ArrayList;

import me.b3n3dkt.SkyPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
   public static ArrayList<Player> spawn = new ArrayList();

   @EventHandler
   public void onHandle(PlayerMoveEvent e) {
      Player p = e.getPlayer();
      if (spawn.contains(p)) {
         spawn.remove(p);
         p.sendMessage(SkyPvP.getPrefix() + "§cDer teleportier vorgang wurde abgebrochen!");
      }

   }
}
