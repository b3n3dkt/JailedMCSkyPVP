package me.b3n3dkt.listener;

import me.b3n3dkt.utils.Combat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.util.HashMap;
import java.util.Map;

public class EntityDamage implements Listener {

   public static Map<Player, Entity> lastDamager = new HashMap<>();

   @EventHandler
   public void onHandle(EntityDamageByBlockEvent e){
      if (e.getEntity() instanceof Player) {
         if(e.getCause() == EntityDamageEvent.DamageCause.VOID){
            if(e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
               EntityDamageByEntityEvent cause = (EntityDamageByEntityEvent) e.getEntity().getLastDamageCause();
               lastDamager.put((Player) e.getEntity(), cause.getDamager());
            }
         }

      }
   }

   @EventHandler
   public void onHandle(EntityDamageByEntityEvent e) {
      if (e.getEntity() == null || e.getDamager() == null) {
         return;
      }
      if (e.getEntity() instanceof Player || e.getDamager() instanceof Player) {
         return;
      }
      Player t = (Player) e.getEntity();
      Player p = (Player) e.getDamager();

      Combat.tagPlayer(p, 400);
      Combat.tagPlayer(t, 400);
   }

   @EventHandler
   public void onEntityDamageEvent(EntityDamageEvent e) {
      if (e.getEntity().getType() == EntityType.PLAYER && e.getCause() == DamageCause.FALL) {
         e.setCancelled(true);
      } else if (e.getEntity().getLocation().getY() > 100.0D) {
         e.setCancelled(true);
      }

   }
}
