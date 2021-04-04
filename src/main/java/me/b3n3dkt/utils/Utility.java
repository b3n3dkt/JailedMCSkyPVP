package me.b3n3dkt.utils;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Utility {
   public static UUID getUUIDFromName(String name) {
      Player p = Bukkit.getPlayer(name);
      if (p != null) {
         return p.getUniqueId();
      } else {
         OfflinePlayer op = Bukkit.getOfflinePlayer(name);
         return op != null ? op.getUniqueId() : null;
      }
   }
}
