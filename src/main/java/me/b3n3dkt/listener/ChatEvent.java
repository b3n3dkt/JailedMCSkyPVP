package me.b3n3dkt.listener;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.commands.CMD_Event;
import me.b3n3dkt.commands.CMD_GlobalMute;
import me.b3n3dkt.utils.Rang;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
   @EventHandler
   public void onChat(AsyncPlayerChatEvent e) {
      Player p = e.getPlayer();
      if (SkyPvP.activeVote != null) {
         if (p.hasPermission("jailedmc.command.votekick.bypass")) {
            e.setCancelled(false);
         } else {
            e.setCancelled(true);
            p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst momentan nicht schreiben, weil ein VoteKick aktiv ist!");
            p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1.0F, 1.0F);
         }
      } else if (CMD_GlobalMute.globalmute) {
         if (!p.hasPermission("jailedmc.command.globalmute.bypass")) {
            e.setCancelled(true);
            p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst momentan nicht schreiben, weil der Chat gemuted ist!");
            p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1.0F, 1.0F);
         }
      } else if (CMD_Event.event && !p.hasPermission("jailedmc.command.globalmute.bypass")) {
         e.setCancelled(true);
         p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst momentan nicht schreiben, weil in Event aktiv ist!");
         p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1.0F, 1.0F);
      }

      if (e.getMessage().equalsIgnoreCase("/pl") || e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().equalsIgnoreCase("/bukkit") || e.getMessage().equalsIgnoreCase("/?") || e.getMessage().equalsIgnoreCase("/help") || e.getMessage().equalsIgnoreCase("/bukkit:help") || e.getMessage().startsWith("//") || e.getMessage().equalsIgnoreCase("/hawk")) {
         if (!p.isOp()) {
            e.setCancelled(true);
            p.sendMessage(SkyPvP.getNoperm());
         } else {
            e.setCancelled(false);
         }
      }
      e.setFormat(Rang.getSuffix(p.getUniqueId().toString()) + " §8× §7" + p.getName() + " §8→ §7" + ChatColor.translateAlternateColorCodes('&', e.getMessage()));

   }
}
