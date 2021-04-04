package me.b3n3dkt.listener;

import java.util.ArrayList;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.ItemBuilder;
import me.b3n3dkt.utils.Score;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick_Kits implements Listener {
   ArrayList<Player> spieler = new ArrayList();
   ArrayList<Player> premium = new ArrayList();
   ArrayList<Player> obsidian = new ArrayList();
   ArrayList<Player> titan = new ArrayList();
   ArrayList<Player> bedrock = new ArrayList();
   ArrayList<Player> legende = new ArrayList();
   ArrayList<Player> phoenix = new ArrayList();

   @EventHandler
   public void onHandle(InventoryClickEvent e) {
      final Player p = (Player)e.getWhoClicked();
      Score scoreBoard = new Score(p);
      int f = 0;

      if(e.getInventory() == null){
         return;
      }
      if(e.getInventory().getTitle() == null){
         return;
      }
      if(e.getCurrentItem() == null){
         return;
      }

      for(int i = 0; i < p.getInventory().getContents().length; ++i) {
         if (p.getInventory().getContents()[i] != null) {
            ++f;
         }
      }

      if (e.getInventory() != null && e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
         if (e.getInventory().getTitle().equalsIgnoreCase("§6§lKits")) {
            e.setCancelled(true);
            ItemStack helmet;
            ItemStack chestplate;
            ItemStack leggings;
            ItemStack boots;
            ItemStack sword;
            ItemStack apple;
            ItemStack arrow;
            ItemStack bow;
            ItemStack enderpearl = null;
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Spieler")) {
               if (this.spieler.contains(p)) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
               } else if (f > 27) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
               } else {
                  helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Spieler Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();
                  chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Spieler Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
                  leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Spieler Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
                  boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Spieler Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();
                  sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Spieler Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 5).build();
                  apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(5).setDisplayName("§eGoldener Apfel").build();
                  arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                  bow =(new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Spieler Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 1).build();
                  enderpearl = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(5).setDisplayName("§7Enderperlen").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{enderpearl});
                  p.closeInventory();
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§7Spieler§8' §7geholt");
                  this.spieler.add(p);
                  Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                     public void run() {
                        InventoryClick_Kits.this.spieler.remove(p);
                        p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§7Spieler§8' §7Kit abholen! ");
                     }
                  }, 3600L);
               }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium")) {
               if (this.premium.contains(p)) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
               } else {
                  if (!p.hasPermission("jailedmc.command.kit.premium")) {
                     p.sendMessage(SkyPvP.getPrefix());
                     return;
                  }

                  if (f > 27) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
                  } else {
                     helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§6Premium §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
                     chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§6Premium §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                     leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§6Premium §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                     boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§6Premium §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
                     sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§6Premium §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 5).build();
                     apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(15).setDisplayName("§eGoldener Apfel").build();
                     arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                     bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§6Premium §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).build();
                     enderpearl = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(10).setDisplayName("§7Enderperlen").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{enderpearl});
                     p.closeInventory();
                     p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§6Premium§8' §7geholt");
                     this.premium.add(p);
                     Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                        public void run() {
                           InventoryClick_Kits.this.premium.remove(p);
                           p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§6Premium§8' §7Kit abholen! ");
                        }
                     }, 3600L);
                  }
               }
            } else {
               ItemStack steaks;
               if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dObsidian")) {
                  if (this.obsidian.contains(p)) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
                  } else {
                     if (!p.hasPermission("jailedmc.command.kit.obsidian")) {
                        p.sendMessage(SkyPvP.getPrefix());
                        return;
                     }

                     if (f > 26) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
                     } else {
                        helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§dObsidian §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                        chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§dObsidian §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                        leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§dObsidian §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                        boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§dObsidian §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                        sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§dObsidian §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 5).build();
                        apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(20).setDisplayName("§eGoldener §7Apfel").build();
                        arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                        bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§dObsidian §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                        enderpearl = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(15).setDisplayName("§7Enderperlen").build();
                        steaks = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                        p.getInventory().addItem(new ItemStack[]{helmet});
                        p.getInventory().addItem(new ItemStack[]{enderpearl});
                        p.getInventory().addItem(new ItemStack[]{chestplate});
                        p.getInventory().addItem(new ItemStack[]{leggings});
                        p.getInventory().addItem(new ItemStack[]{boots});
                        p.getInventory().addItem(new ItemStack[]{bow});
                        p.getInventory().addItem(new ItemStack[]{sword});
                        p.getInventory().addItem(new ItemStack[]{steaks});
                        p.getInventory().addItem(new ItemStack[]{apple});
                        p.getInventory().addItem(new ItemStack[]{arrow});
                        p.closeInventory();
                        p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§dObsidian§8' §7geholt");
                        this.obsidian.add(p);
                        Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                           public void run() {
                              InventoryClick_Kits.this.obsidian.remove(p);
                              p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§dObsidian§8' §7Kit abholen! ");
                           }
                        }, 3600L);
                     }
                  }
               } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Titan")) {
                  if (this.titan.contains(p)) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
                  } else {
                     if (!p.hasPermission("jailedmc.command.kit.titan")) {
                        p.sendMessage(SkyPvP.getPrefix());
                        return;
                     }

                     if (f > 26) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
                     } else {
                        helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§9Titan §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                        chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§9Titan §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                        leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§9Titan §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                        boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§9Titan §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                        sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§9Titan §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 6).build();
                        apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(25).setDisplayName("§eGoldener §7Apfel").build();
                        arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                        bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§9Titan §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                        enderpearl= (new ItemBuilder(Material.ENDER_PEARL)).setAmount(20).setDisplayName("§7Enderperlen").build();
                        steaks = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                        p.getInventory().addItem(new ItemStack[]{helmet});
                        p.getInventory().addItem(new ItemStack[]{enderpearl});
                        p.getInventory().addItem(new ItemStack[]{chestplate});
                        p.getInventory().addItem(new ItemStack[]{leggings});
                        p.getInventory().addItem(new ItemStack[]{boots});
                        p.getInventory().addItem(new ItemStack[]{bow});
                        p.getInventory().addItem(new ItemStack[]{sword});
                        p.getInventory().addItem(new ItemStack[]{steaks});
                        p.getInventory().addItem(new ItemStack[]{apple});
                        p.getInventory().addItem(new ItemStack[]{arrow});
                        p.closeInventory();
                        p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§9Titan§8' §7geholt");
                        this.titan.add(p);
                        Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                           public void run() {
                              InventoryClick_Kits.this.titan.remove(p);
                              p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§9Titan§8' §7Kit abholen! ");
                           }
                        }, 3600L);
                     }
                  }
               } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Bedrock")) {
                  if (this.bedrock.contains(p)) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
                  } else {
                     if (!p.hasPermission("jailedmc.command.kit.bedrock")) {
                        p.sendMessage(SkyPvP.getNoperm());
                        return;
                     }

                     if (f > 26) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
                     } else {
                        helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§5Bedrock §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                        chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§5Bedrock §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7).build();
                        leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§5Bedrock §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7).build();
                        boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§5Bedrock §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                        sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§5Bedrock §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 7).build();
                        apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(30).setDisplayName("§eGoldener §7Apfel").build();
                        arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                        bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§5Bedrock §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                        enderpearl = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(25).setDisplayName("§7Enderperlen").build();
                        steaks = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                        p.getInventory().addItem(new ItemStack[]{helmet});
                        p.getInventory().addItem(new ItemStack[]{enderpearl});
                        p.getInventory().addItem(new ItemStack[]{chestplate});
                        p.getInventory().addItem(new ItemStack[]{leggings});
                        p.getInventory().addItem(new ItemStack[]{boots});
                        p.getInventory().addItem(new ItemStack[]{bow});
                        p.getInventory().addItem(new ItemStack[]{sword});
                        p.getInventory().addItem(new ItemStack[]{steaks});
                        p.getInventory().addItem(new ItemStack[]{apple});
                        p.getInventory().addItem(new ItemStack[]{arrow});
                        p.closeInventory();
                        p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§5Bedrock§8' §7geholt");
                        this.bedrock.add(p);
                        Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                           public void run() {
                              InventoryClick_Kits.this.bedrock.remove(p);
                              p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§5Bedrock§8' §7Kit abholen! ");
                           }
                        }, 3600L);
                     }
                  }
               } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lLegende")) {
                  if (this.legende.contains(p)) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
                  } else {
                     if (!p.hasPermission("jailedmc.command.kit.legende")) {
                        p.sendMessage(SkyPvP.getNoperm());
                        return;
                     }

                     if (f > 26) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
                     } else {
                        helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§c§lLegende §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7).build();
                        chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§c§lLegende §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).build();
                        leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§c§lLegende §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).build();
                        boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§c§lLegende §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7).build();
                        sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§c§lLegende §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 8).build();
                        apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(30).setDisplayName("§eGoldener §7Apfel").build();
                        arrow = (new ItemBuilder(Material.ARROW)).setAmount(1).setDisplayName("§7Pfeile").build();
                        bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§c§lLegende §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_INFINITE, 1).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                        enderpearl = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(25).setDisplayName("§7Enderperlen").build();
                        steaks = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                        p.getInventory().addItem(new ItemStack[]{helmet});
                        p.getInventory().addItem(new ItemStack[]{enderpearl});
                        p.getInventory().addItem(new ItemStack[]{chestplate});
                        p.getInventory().addItem(new ItemStack[]{leggings});
                        p.getInventory().addItem(new ItemStack[]{boots});
                        p.getInventory().addItem(new ItemStack[]{bow});
                        p.getInventory().addItem(new ItemStack[]{sword});
                        p.getInventory().addItem(new ItemStack[]{steaks});
                        p.getInventory().addItem(new ItemStack[]{apple});
                        p.getInventory().addItem(new ItemStack[]{arrow});
                        p.closeInventory();
                        p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§c§lLegende§8' §7geholt");
                        this.legende.add(p);
                        Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                           public void run() {
                              InventoryClick_Kits.this.legende.remove(p);
                              p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§c§lLegende§8' §7Kit abholen! ");
                           }
                        }, 3600L);
                     }
                  }
               } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPhoenix")) {
                  if (this.phoenix.contains(p)) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst das Kit alle 3 Minuten abholen!");
                  } else {
                     if (!p.hasPermission("jailedmc.command.kit.phoenix")) {
                        p.sendMessage(SkyPvP.getNoperm());
                        return;
                     }

                     if (f > 26) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
                     } else {
                        helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§e§lPhoenix §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).build();
                        chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§e§lPhoenix §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 11).build();
                        leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§e§lPhoenix §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 11).build();
                        boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§e§lPhoenix §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).build();
                        sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§e§lPhoenix §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 11).build();
                        apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(32).setDisplayName("§eGoldener §7Apfel").build();
                        arrow = (new ItemBuilder(Material.ARROW)).setAmount(1).setDisplayName("§7Pfeile").build();
                        bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§e§lPhoenix §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_INFINITE, 1).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                        enderpearl = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(32).setDisplayName("§7Enderperlen").build();
                        steaks = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(32).setDisplayName("§7Steaks").build();
                        p.getInventory().addItem(new ItemStack[]{helmet});
                        p.getInventory().addItem(new ItemStack[]{enderpearl});
                        p.getInventory().addItem(new ItemStack[]{chestplate});
                        p.getInventory().addItem(new ItemStack[]{leggings});
                        p.getInventory().addItem(new ItemStack[]{boots});
                        p.getInventory().addItem(new ItemStack[]{bow});
                        p.getInventory().addItem(new ItemStack[]{sword});
                        p.getInventory().addItem(new ItemStack[]{steaks});
                        p.getInventory().addItem(new ItemStack[]{apple});
                        p.getInventory().addItem(new ItemStack[]{arrow});
                        p.closeInventory();
                        p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§e§lPhoenix§8' §7geholt");
                        this.phoenix.add(p);
                        Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                           public void run() {
                              InventoryClick_Kits.this.phoenix.remove(p);
                              p.sendMessage(SkyPvP.getPrefix() + "§7Du kannst dir wieder ein §8'§e§lPhoenix§8' §7Kit abholen! ");
                           }
                        }, 3600L);
                     }
                  }
               }
            }
         }

         scoreBoard.update();
      }

   }
}
