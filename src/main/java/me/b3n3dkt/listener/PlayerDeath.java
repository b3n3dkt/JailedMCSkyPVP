package me.b3n3dkt.listener;

import java.util.HashMap;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.Combat;
import me.b3n3dkt.utils.Score;
import me.b3n3dkt.utils.SkyPvPStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerDeath implements Listener {

   public HashMap<Player, Integer> killstreak = new HashMap<>();

   @EventHandler
   public void onHandle(PlayerDeathEvent e) {
      e.setDeathMessage(null);
      if(e.getEntity().getLastDamageCause() instanceof EntityDamageByBlockEvent){
         EntityDamageByBlockEvent cause = (EntityDamageByBlockEvent) e.getEntity().getLastDamageCause();
         if(cause.getCause() == EntityDamageEvent.DamageCause.VOID){
            Entity entity = EntityDamage.lastDamager.get(e.getEntity());
               if(entity instanceof Player) {
                  final Player player = (Player) entity;
                  Score score = new Score(player);
                  setStats(player, e.getEntity());
                  player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
                  player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
                  Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§8'§e" + e.getEntity().getDisplayName() + "§8' §7wurde von §8'§e" + player.getName() + "§8' §7von der Welt gestoßen!§8(§a+20 §7Coins§8)");
                  score.update();
               }else{
                  SkyPvPStats.setTode(e.getEntity().getPlayer().getUniqueId().toString(), SkyPvPStats.getTode(e.getEntity().getPlayer().getUniqueId().toString()) + 1);
                  if(killstreak.containsKey(e.getEntity().getPlayer())){
                     killstreak.remove(e.getEntity().getPlayer());
                  }
                  Combat.untagPlayer(e.getEntity().getPlayer());
                  e.getEntity().getPlayer().sendMessage(SkyPvP.getPrefix() + "§7Du bist gestorben!");
               }
         }
      }else{
         if (e.getEntity().getKiller() instanceof Player) {
            Player p = e.getEntity().getKiller();
            Player t = e.getEntity().getPlayer();
            Score score = new Score(p);
            setStats(p, t);
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§8'§e" + t.getName() + "§8' §7wurde von §8'§e" + p.getName() + "§8' §7getötet!§8(§a+20 §7Coins§8)");
            score.update();
         }
      }

   }

   public void setStats(Player killer, Player target){
      MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 20);
      SkyPvPStats.setKills(killer.getUniqueId().toString(), SkyPvPStats.getKills(killer.getUniqueId().toString()) + 1);
      SkyPvPStats.setTode(target.getUniqueId().toString(), SkyPvPStats.getTode(target.getUniqueId().toString()) + 1);
      if(killstreak.containsKey(target)){
         killstreak.remove(target);
      }
      if(!killstreak.containsKey(killer)){
         killstreak.put(killer, 1);
      }else if(killstreak.containsKey(killer)){
         int kills = killstreak.get(killer) +1;
         killstreak.remove(killer);
         killstreak.put(killer, kills);
         if(kills > SkyPvPStats.getKillstreak(killer.getUniqueId().toString())) {
            SkyPvPStats.setKillstreak(killer.getUniqueId().toString(), kills);
         }
         if (kills == 5) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 5er Killstreak!§8(§a+15 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 150.0D);
         } else if (kills == 10) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 10er Killstrea!§8(§a+30 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 300.0D);
         } else if (kills == 15) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 15er Killstrea!§8(§a+45 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 450.0D);
         } else if (kills == 20) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 20er Killstreak!§8(§a+60 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 600.0D);
         } else if (kills == 25) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 25er Killstreak!§8(§a+75 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 750.0D);
         } else if (kills == 30) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 30er Killstreak!§8(§a+90 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 900.0D);
         } else if (kills == 35) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 35er Killstreak!§8(§a+105 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 1050.0D);
         } else if (kills == 40) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 40er Killstreak!§8(§a+120 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 1200.0D);
         } else if (kills == 45) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 45er Killstreak!§8(§a+135 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 1350.0D);
         } else if (kills == 50) {
            Bukkit.broadcastMessage(SkyPvP.getPrefix() + "§7Der Spieler §b" + killer.getName() + " §7hat eine 50er Killstreak!§8(§a+150 §7Coins§8)");
            MySQL.setcoins(killer.getUniqueId().toString(), MySQL.getcoins(killer.getUniqueId().toString()) + 1500.0D);
         }
      }
      Combat.untagPlayer(killer);
      Combat.untagPlayer(target);
   }

}
