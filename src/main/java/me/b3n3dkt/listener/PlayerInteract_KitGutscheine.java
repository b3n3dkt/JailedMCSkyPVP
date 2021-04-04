package me.b3n3dkt.listener;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract_KitGutscheine implements Listener {
   @EventHandler
   public void onHandle(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
         Integer amount = p.getItemInHand().getAmount();
         int f = 0;

         for(int i = 0; i < p.getInventory().getContents().length; ++i) {
            if (p.getInventory().getContents()[i] != null) {
               ++f;
            }
         }

         if (e.getItem() == null || e.getItem() == new ItemStack(Material.AIR) || e.getItem().getItemMeta() == null || e.getItem().getItemMeta().getDisplayName() == null) {
            return;
         }

         ItemStack stack = e.getItem();
         String name = stack.getItemMeta().getDisplayName();
         ItemStack helmet;
         ItemStack chestplate;
         ItemStack leggings;
         ItemStack boots;
         ItemStack sword;
         ItemStack apple;
         ItemStack arrow;
         ItemStack bow;
         ItemStack pearls;
         if (name.equals("§7Kitgutschein §8× §6Premium")) {
            if (f > 27) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
            } else {
               if (amount == 1) {
                  p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
               } else {
                  p.getItemInHand().setAmount(amount - 1);
               }

               helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§6Premium §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();
               chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§6Premium §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
               leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§6Premium §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
               boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§6Premium §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build();
               sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§6Premium §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 4).build();
               apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(15).setDisplayName("§eGoldener Apfel").build();
               arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
               bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§6Premium §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).build();
               pearls = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(10).setDisplayName("§7Enderperlen").build();
               p.getInventory().addItem(new ItemStack[]{helmet});
               p.getInventory().addItem(new ItemStack[]{chestplate});
               p.getInventory().addItem(new ItemStack[]{leggings});
               p.getInventory().addItem(new ItemStack[]{boots});
               p.getInventory().addItem(new ItemStack[]{sword});
               p.getInventory().addItem(new ItemStack[]{pearls});
               p.getInventory().addItem(new ItemStack[]{apple});
               p.getInventory().addItem(new ItemStack[]{arrow});
               p.getInventory().addItem(new ItemStack[]{bow});
               p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§6Premium§8' §7geholt");
            }
         } else {
            ItemStack steak;
            if (name.equals("§7Kitgutschein §8× §dObsidian")) {
               if (f > 26) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
               } else {
                  if (amount == 1) {
                     p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  } else {
                     p.getItemInHand().setAmount(amount - 1);
                  }

                  helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§dObsidian §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
                  chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§dObsidian §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                  leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§dObsidian §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                  boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§dObsidian §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
                  sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§dObsidian §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 4).build();
                  apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(20).setDisplayName("§eGoldener §Apfel").build();
                  arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                  bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§dObsidian §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                  pearls = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(15).setDisplayName("§7Enderperlen").build();
                  steak = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{pearls});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{steak});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§dObsidian§8' §7geholt");
               }
            } else if (name.equals("§7Kitgutschein §8× §9Titan")) {
               if (f > 26) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
               } else {
                  if (amount == 1) {
                     p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  } else {
                     p.getItemInHand().setAmount(amount - 1);
                  }

                  helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§9Titan §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                  chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§9Titan §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                  leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§9Titan §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                  boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§9Titan §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
                  sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§9Titan §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 5).build();
                  apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(25).setDisplayName("§eGoldener §Apfel").build();
                  arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                  bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§9Titan §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                  pearls = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(20).setDisplayName("§7Enderperlen").build();
                  steak = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{pearls});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{steak});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§9Titan§8' §7geholt");
               }
            } else if (name.equals("§7Kitgutschein §8× §5Bedrock")) {
               if (f > 26) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
               } else {
                  if (amount == 1) {
                     p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  } else {
                     p.getItemInHand().setAmount(amount - 1);
                  }

                  helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§5Bedrock §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                  chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§5Bedrock §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                  leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§5Bedrock §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                  boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§5Bedrock §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
                  sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§5Bedrock §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 6).build();
                  apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(30).setDisplayName("§eGoldener §Apfel").build();
                  arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").build();
                  bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§5Bedrock §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                  pearls = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(25).setDisplayName("§7Enderperlen").build();
                  steak = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{pearls});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{steak});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§5Bedrock§8' §7geholt");
               }
            } else if (name.equals("§7Kitgutschein §8× §c§lLegende")) {
               if (f > 26) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
               } else {
                  if (amount == 1) {
                     p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  } else {
                     p.getItemInHand().setAmount(amount - 1);
                  }

                  helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§c§lLegende §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                  chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§c§lLegende §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7).build();
                  leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§c§lLegende §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7).build();
                  boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§c§lLegende §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build();
                  sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§c§lLegende §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 7).build();
                  apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(30).setDisplayName("§eGoldener §Apfel").build();
                  arrow = (new ItemBuilder(Material.ARROW)).setAmount(1).setDisplayName("§7Pfeile").build();
                  bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§c§lLegende §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_INFINITE, 1).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                  pearls = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(25).setDisplayName("§7Enderperlen").build();
                  steak = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(20).setDisplayName("§7Steaks").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{pearls});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{steak});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§c§lLegende§8' §7geholt");
               }
            } else if (name.equals("§7Kitgutschein §8× §e§lPhoenix")){
               if (f > 26) {
                  p.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist zu voll, leere dein Inventar.");
               } else {
                  if (amount == 1) {
                     p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  } else {
                     p.getItemInHand().setAmount(amount - 1);
                  }

                  helmet = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§e§lPhoenix §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 9).build();
                  chestplate = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§e§lPhoenix §7Brustplatte").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).build();
                  leggings = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§e§lPhoenix §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).build();
                  boots = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§e§lPhoenix §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 9).build();
                  sword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§e§lPhoenix §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 9).build();
                  apple = (new ItemBuilder(Material.GOLDEN_APPLE)).setAmount(32).setDisplayName("§eGoldener §Apfel").build();
                  arrow = (new ItemBuilder(Material.ARROW)).setAmount(1).setDisplayName("§7Pfeile").build();
                  bow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§e§lPhoenix §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_INFINITE, 1).setEnchantment(Enchantment.ARROW_FIRE, 1).build();
                  pearls = (new ItemBuilder(Material.ENDER_PEARL)).setAmount(32).setDisplayName("§7Enderperlen").build();
                  steak = (new ItemBuilder(Material.COOKED_BEEF)).setAmount(32).setDisplayName("§7Steaks").build();
                  p.getInventory().addItem(new ItemStack[]{helmet});
                  p.getInventory().addItem(new ItemStack[]{chestplate});
                  p.getInventory().addItem(new ItemStack[]{leggings});
                  p.getInventory().addItem(new ItemStack[]{boots});
                  p.getInventory().addItem(new ItemStack[]{sword});
                  p.getInventory().addItem(new ItemStack[]{pearls});
                  p.getInventory().addItem(new ItemStack[]{apple});
                  p.getInventory().addItem(new ItemStack[]{steak});
                  p.getInventory().addItem(new ItemStack[]{arrow});
                  p.getInventory().addItem(new ItemStack[]{bow});
                  p.sendMessage(SkyPvP.getPrefix() + "§7Du hast dir das Kit §8'§e§lPhoenix§8' §7geholt");
               }
            }
         }
      }

   }
}
