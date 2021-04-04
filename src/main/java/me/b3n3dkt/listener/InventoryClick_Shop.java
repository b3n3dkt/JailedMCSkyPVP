package me.b3n3dkt.listener;

import java.util.Arrays;
import java.util.UUID;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.Inventorys;
import me.b3n3dkt.utils.ItemBuilder;
import me.b3n3dkt.utils.Score;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClick_Shop implements Listener {
   @EventHandler
   public void onHandle(InventoryClickEvent e) {

      if(e.getInventory() == null){
         return;
      }
      if(e.getInventory().getTitle() == null){
         return;
      }
      if(e.getCurrentItem() == null){
         return;
      }
      Player p = (Player)e.getWhoClicked();
      String uuid = p.getUniqueId().toString();
      Score scoreBoard = new Score(p);
      Inventory inv;
      ItemStack glas;
      ItemMeta glasmeta;
      ItemStack greenglas;
      ItemMeta greenglasmeta;
      ItemStack redglas;
      ItemMeta redglasmeta;
      if(e.getInventory().getTitle().equalsIgnoreCase("§6§lShop")){
         e.setCancelled(true);
         if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kit-Gutscheine")){
            Inventorys.openShop(p);
            Inventorys.openKitG(p);
         }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Essen")){
            Inventorys.openShop(p);
            Inventorys.openEssen(p);
         }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Rüstungen")){
            Inventorys.openShop(p);
            Inventorys.openRüstung(p);
         }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Waffen")){
            Inventorys.openShop(p);
            Inventorys.openSchwerter(p);
         }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Tränke")){
            Inventorys.openShop(p);
            Inventorys.openTränke(p);
         }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Packs")){
            Inventorys.openShop(p);
            Inventorys.openPack(p);
         }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Rang-Gutscheine")){
            Inventorys.openShop(p);
            Inventorys.openRang(p);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ranggutschein §8× §6Premium")) {
            if (MySQL.getcoins(uuid) < 12000.0D) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
            } else {
               inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rang §6Premium §7kaufen?");
               p.closeInventory();
               p.openInventory(inv);
               glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
               glasmeta = glas.getItemMeta();
               glasmeta.setDisplayName("§e§l");
               glas.setItemMeta(glasmeta);
               greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
               greenglasmeta = greenglas.getItemMeta();
               greenglasmeta.setDisplayName("§aJa");
               greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §a12.000$"));
               greenglas.setItemMeta(greenglasmeta);
               redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
               redglasmeta = redglas.getItemMeta();
               redglasmeta.setDisplayName("§cNein");
               redglas.setItemMeta(redglasmeta);

               for(int i = 0; i < 27; ++i) {
                  inv.setItem(i, glas);
               }

               inv.setItem(11, greenglas);
               inv.setItem(15, redglas);
               p.updateInventory();
            }
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ranggutschein §8× §dObsidian")) {
            if (MySQL.getcoins(uuid) < 25000.0D) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
            } else {
               inv = Bukkit.createInventory(p, 27, "§7Rang §dObsidian §7kaufen?");
               p.closeInventory();
               p.openInventory(inv);
               glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
               glasmeta = glas.getItemMeta();
               glasmeta.setDisplayName("§e§l");
               glas.setItemMeta(glasmeta);
               greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
               greenglasmeta = greenglas.getItemMeta();
               greenglasmeta.setDisplayName("§aJa");
               greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §a25.000$"));
               greenglas.setItemMeta(greenglasmeta);
               redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
               redglasmeta = redglas.getItemMeta();
               redglasmeta.setDisplayName("§cNein");
               redglas.setItemMeta(redglasmeta);

               for(int i = 0; i < 27; ++i) {
                  inv.setItem(i, glas);
               }

               inv.setItem(11, greenglas);
               inv.setItem(15, redglas);
               p.updateInventory();
            }
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ranggutschein §8× §9Titan")) {
            if (MySQL.getcoins(uuid) < 40000.0D) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
            } else {
               inv = Bukkit.createInventory(p, 27, "§7Rang §9Titan §7kaufen?");
               p.closeInventory();
               p.openInventory(inv);
               glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
               glasmeta = glas.getItemMeta();
               glasmeta.setDisplayName("§e§l");
               glas.setItemMeta(glasmeta);
               greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
               greenglasmeta = greenglas.getItemMeta();
               greenglasmeta.setDisplayName("§aJa");
               greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §a40.000$"));
               greenglas.setItemMeta(greenglasmeta);
               redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
               redglasmeta = redglas.getItemMeta();
               redglasmeta.setDisplayName("§cNein");
               redglas.setItemMeta(redglasmeta);

               for(int i = 0; i < 27; ++i) {
                  inv.setItem(i, glas);
               }

               inv.setItem(11, greenglas);
               inv.setItem(15, redglas);
               p.updateInventory();
            }
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ranggutschein §8× §5Bedrock")) {
            if (MySQL.getcoins(uuid) < 75000.0D) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
            } else {
               inv = Bukkit.createInventory(p, 27, "§7Rang §5Bedrock §7kaufen?");
               p.closeInventory();
               p.openInventory(inv);
               glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
               glasmeta = glas.getItemMeta();
               glasmeta.setDisplayName("§e§l");
               glas.setItemMeta(glasmeta);
               greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
               greenglasmeta = greenglas.getItemMeta();
               greenglasmeta.setDisplayName("§aJa");
               greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §75.000$"));
               greenglas.setItemMeta(greenglasmeta);
               redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
               redglasmeta = redglas.getItemMeta();
               redglasmeta.setDisplayName("§cNein");
               redglas.setItemMeta(redglasmeta);

               for(int i = 0; i < 27; ++i) {
                  inv.setItem(i, glas);
               }

               inv.setItem(11, greenglas);
               inv.setItem(15, redglas);
               p.updateInventory();
            }
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ranggutschein §8× §c§lLegende")) {
            if (MySQL.getcoins(uuid) < 175000.0D) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
            } else {
               inv = Bukkit.createInventory(p, 27, "§7Rang §c§lLegende §7kaufen?");
               p.closeInventory();
               p.openInventory(inv);
               glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
               glasmeta = glas.getItemMeta();
               glasmeta.setDisplayName("§e§l");
               glas.setItemMeta(glasmeta);
               greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
               greenglasmeta = greenglas.getItemMeta();
               greenglasmeta.setDisplayName("§aJa");
               greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §175.000$"));
               greenglas.setItemMeta(greenglasmeta);
               redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
               redglasmeta = redglas.getItemMeta();
               redglasmeta.setDisplayName("§cNein");
               redglas.setItemMeta(redglasmeta);

               for(int i = 0; i < 27; ++i) {
                  inv.setItem(i, glas);
               }

               inv.setItem(11, greenglas);
               inv.setItem(15, redglas);
               p.updateInventory();
            }
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Ranggutschein §8× §e§lPhoenix")) {
            if (MySQL.getcoins(uuid) < 200000.0D) {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
            } else {
               inv = Bukkit.createInventory(p, 27, "§7Rang §e§lPhoenix §7kaufen?");
               p.closeInventory();
               p.openInventory(inv);
               glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
               glasmeta = glas.getItemMeta();
               glasmeta.setDisplayName("§e§l");
               glas.setItemMeta(glasmeta);
               greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
               greenglasmeta = greenglas.getItemMeta();
               greenglasmeta.setDisplayName("§aJa");
               greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §a200.000$"));
               greenglas.setItemMeta(greenglasmeta);
               redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
               redglasmeta = redglas.getItemMeta();
               redglasmeta.setDisplayName("§cNein");
               redglas.setItemMeta(redglasmeta);

               for(int i = 0; i < 27; ++i) {
                  inv.setItem(i, glas);
               }

               inv.setItem(11, greenglas);
               inv.setItem(15, redglas);
               p.updateInventory();
            }

            // ESSEN

         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Steaks")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.COOKED_BEEF, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Goldener Apfel")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.GOLDEN_APPLE, 5), 20, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Brot")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.BREAD, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Suppe")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.MUSHROOM_SOUP, 1), 5, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Cookie")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.COOKIE, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schweine Fleisch")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.GRILLED_PORK, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kürbis Kuchen")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.PUMPKIN_PIE, 1), 5, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gebratene Kartoffel")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.BAKED_POTATO, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Karotten")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.CARROT, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gebratenes Hünchen")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.COOKED_CHICKEN, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gebratener Hase")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.COOKED_RABBIT, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gebratenes Schaaf")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.COOKED_MUTTON, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Melone")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.MELON, 32), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Verzauberter Goldener Apfel")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.GOLDEN_APPLE, 1, (short)1), 150, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Gebratener Fisch")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.COOKED_FISH, 32), 50, false);

            // RÜSTUNG

         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e1 §7Helm")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e1 §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 250, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e1 §7Brustpanzer")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e1 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 250, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e1 §7Hose")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e1 §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 250, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e1 §7Schuhe")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e1 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 250, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e2 §7Helm")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e2 §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 400, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e2 §7Brustpanzer")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e2 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 400, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e2 §7Hose")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e2 §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 400, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e2 §7Schuhe")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e2 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 400, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e3 §7Helm")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e3 §7Helm").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 550, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e3 §7Brustpanzer")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e3 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 550, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e3 §7Hose")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e3 §7Hose").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 550, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e3 §7Schuhe")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e3 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 550, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e4 §7Helm")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e4 §7Helm").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 700, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e4 §7Brustpanzer")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e4 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 700, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e4 §7Hose")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e4 §7Hose").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 700, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e4 §7Schuhe")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e4 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 700, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRasor §7Helm")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§b§lRasor §7Helm").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 2000, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRasor §7Brustpanzer")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§b§lRasor §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 2000, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRasor §7Hose")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§b§lRasor §7Hose").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 2000, true);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRasor §7Schuhe")) {
            ItemStack stack = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§b§lRasor §7Schuhe").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).build();
            this.buy(p.getUniqueId(), p, p.getName(), stack, 2000, true);

            //Waffen

         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRasor §7Sword")) {
            ItemStack rasorsword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§b§lRasor §7Sword").setEnchantment(Enchantment.FIRE_ASPECT, 1).setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.DAMAGE_ALL, 20).setLore("§7Kosten: §a3.500$").build();
            this.buy(p.getUniqueId(), p, p.getName(), rasorsword, 3500, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e1 §7Schwert")) {
            ItemStack sword1 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e1 §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 3).setEnchantment(Enchantment.FIRE_ASPECT, 1).setLore("§7Kosten: §a250$").build();
            this.buy(p.getUniqueId(), p, p.getName(), sword1, 250, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e2 §7Schwert")) {
            ItemStack sword2 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e2 §7Schwert").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.DAMAGE_ALL, 5).setLore("§7Kosten: §a400$").build();
            this.buy(p.getUniqueId(), p, p.getName(), sword2, 400, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e3 §7Schwert")) {
            ItemStack sword3 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e3 §7Schwert").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.DAMAGE_ALL, 5).setEnchantment(Enchantment.FIRE_ASPECT, 1).setLore("§7Kosten: §a600$").build();
            this.buy(p.getUniqueId(), p, p.getName(), sword3, 600, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e4 §7Schwert")) {
            ItemStack sword4 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e4 §7Schwert").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.DAMAGE_ALL, 7).setLore("§7Kosten: §a750$").build();
            this.buy(p.getUniqueId(), p, p.getName(), sword4, 750, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e5 §7Schwert")) {
            ItemStack sword5 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e5 §7Schwert").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.DAMAGE_ALL, 7).setEnchantment(Enchantment.FIRE_ASPECT, 1).setLore("§7Kosten: §a900$").build();
            this.buy(p.getUniqueId(), p, p.getName(), sword5, 900, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRasor §7Bogen")) {
            ItemStack rasorbow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§b§lRasor §7Bogen").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.ARROW_INFINITE, 1).setEnchantment(Enchantment.ARROW_DAMAGE, 5).setEnchantment(Enchantment.ARROW_FIRE, 1).setEnchantment(Enchantment.ARROW_KNOCKBACK, 3).setLore("§7Kosten: §a4.000$").build();
            this.buy(p.getUniqueId(), p, p.getName(), rasorbow, 4000, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e1 §7Bogen")) {
            ItemStack bow1 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e1 §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setLore("§7Kosten: §a200$").build();
            this.buy(p.getUniqueId(), p, p.getName(), bow1, 200, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e2 §7Bogen")) {
            ItemStack bow2 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e2 §7Bogen").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.ARROW_DAMAGE, 3).setLore("§7Kosten: §a400$").build();
            this.buy(p.getUniqueId(), p, p.getName(), bow2, 400, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e3 §7Bogen")) {
            ItemStack bow3 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e3 §7Bogen").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.ARROW_DAMAGE, 4).setLore("§7Kosten: §a600$").build();
            this.buy(p.getUniqueId(), p, p.getName(), bow3, 600, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e4 §7Bogen")) {
            ItemStack bow4 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e4 §7Bogen").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).setLore("§7Kosten: §a850$").build();
            this.buy(p.getUniqueId(), p, p.getName(), bow4, 850, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Stufe §e5 §7Bogen")) {
            ItemStack bow5 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e5 §7Bogen").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.ARROW_DAMAGE, 4).setEnchantment(Enchantment.ARROW_KNOCKBACK, 2).setLore("§7Kosten: §a1.050$").build();
            this.buy(p.getUniqueId(), p, p.getName(), bow5, 1050, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Pfeile")) {
            ItemStack arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").setLore("§7Kosten: §a50").build();
            this.buy(p.getUniqueId(), p, p.getName(), arrow, 50, true);

            //  TRÄNKE

         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Regenerations Trank 1")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)8193), 100, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Werfbarer Regenerations Trank 1")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)16385), 75, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Werfbarer Regenerations Trank 2")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)16417), 50, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Schnelligkeitstrank")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)8194), 150, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Werfbarer Schennligkeits Trank")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)16386), 100, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Heilungstrank 1")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)8261), 25, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Werfbarer Heilungstrank 1")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)16453), 75, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Werfbarer Heilungstrank 2")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)16421), 100, false);
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Werfbarer Langsamkeits Trank")) {
            this.buy(p.getUniqueId(), p, p.getName(), new ItemStack(Material.POTION, 1, (short)16426), 100, false);

            //KIT GUTSCHEINE

         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kitgutschein §8× §6Premium")) {
            DyeColor orange = DyeColor.ORANGE;
            byte orangedata = (byte)(15 - orange.getData());
            ItemStack premium = new ItemStack(Material.INK_SACK, 1, orangedata);
            ItemMeta premiummeta = premium.getItemMeta();
            premiummeta.setDisplayName("§7Kitgutschein §8× §6Premium");
            premiummeta.setLore(Arrays.asList(" ", "§7Kosten: §a500$"));
            premium.setItemMeta(premiummeta);this.buy(p.getUniqueId(), p, p.getName(), premium, 500, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kitgutschein §8× §dObsidian")) {
            DyeColor pink = DyeColor.PINK;
            byte pinkdata = (byte)(15 - pink.getData());
            ItemStack obsidian = new ItemStack(Material.INK_SACK, 1, pinkdata);
            ItemMeta obsidianmeta = obsidian.getItemMeta();
            obsidianmeta.setDisplayName("§7Kitgutschein §8× §dObsidian");
            obsidianmeta.setLore(Arrays.asList(" ", "§7Kosten: §a750$"));
            obsidian.setItemMeta(obsidianmeta);this.buy(p.getUniqueId(), p, p.getName(), obsidian, 750, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kitgutschein §8× §9Titan")) {
            DyeColor blue = DyeColor.BLUE;
            byte bluedata = (byte)(15 - blue.getData());
            ItemStack titan = new ItemStack(Material.INK_SACK, 1, bluedata);
            ItemMeta titanmeta = titan.getItemMeta();
            titanmeta.setDisplayName("§7Kitgutschein §8× §9Titan");
            titanmeta.setLore(Arrays.asList(" ", "§7Kosten: §a1.000$"));
            titan.setItemMeta(titanmeta); this.buy(p.getUniqueId(), p, p.getName(), titan, 1000, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kitgutschein §8× §5Bedrock")) {
            DyeColor purple = DyeColor.PURPLE;
            byte purpledata = (byte)(15 - purple.getData());
            ItemStack bedrock = new ItemStack(Material.INK_SACK, 1, purpledata);
            ItemMeta bedrockmeta = bedrock.getItemMeta();
            bedrockmeta.setDisplayName("§7Kitgutschein §8× §5Bedrock");
            bedrockmeta.setLore(Arrays.asList(" ", "§7Kosten: §a1.250$"));
            bedrock.setItemMeta(bedrockmeta); this.buy(p.getUniqueId(), p, p.getName(), bedrock, 1250, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kitgutschein §8× §c§lLegende")) {
            DyeColor red = DyeColor.RED;
            byte reddata = (byte)(15 - red.getData());
            ItemStack legende = new ItemStack(Material.INK_SACK, 1, reddata);
            ItemMeta legendemeta = legende.getItemMeta();
            legendemeta.setDisplayName("§7Kitgutschein §8× §c§lLegende");
            legendemeta.setLore(Arrays.asList(" ", "§7Kosten: §a1.500$"));
            legende.setItemMeta(legendemeta);this.buy(p.getUniqueId(), p, p.getName(), legende, 1500, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kitgutschein §8× §e§lPhoenix")) {
            DyeColor yellow = DyeColor.YELLOW;
            byte yellowdata = (byte)(15 - yellow.getData());
            ItemStack phoenix = new ItemStack(Material.INK_SACK, 1, yellowdata);
            ItemMeta phoenixmeta = phoenix.getItemMeta();
            phoenixmeta.setDisplayName("§7Kitgutschein §8× §e§lPhoenix");
            phoenixmeta.setLore(Arrays.asList(" ", "§7Kosten: §a2.250$"));
            phoenix.setItemMeta(phoenixmeta);this.buy(p.getUniqueId(), p, p.getName(), phoenix, 2250, true);

            // PACKS

         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kit Pack")) {
            ItemStack kits = new ItemStack(Material.BOOK, 1);
            ItemMeta kmeta = kits.getItemMeta();
            kmeta.setDisplayName("§6Kit Pack");
            kmeta.setLore(Arrays.asList(" ", "§7Kosten: §a750$"));
            kits.setItemMeta(kmeta);this.buy(p.getUniqueId(), p, p.getName(), kits, 750, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Rang Pack")) {
            ItemStack rang = new ItemStack(Material.BOOK, 1);
            ItemMeta rmeta = rang.getItemMeta();
            rmeta.setDisplayName("§6Rang Pack");
            rmeta.setLore(Arrays.asList(" ", "§7Kosten: §a5000$"));
            rang.setItemMeta(rmeta);this.buy(p.getUniqueId(), p, p.getName(), rang, 5000, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Waffen Pack")) {
            ItemStack waffen = new ItemStack(Material.BOOK, 1);
            ItemMeta wmeta = waffen.getItemMeta();
            wmeta.setDisplayName("§6Waffen Pack");
            wmeta.setLore(Arrays.asList(" ", "§7Kosten: §a1000$"));
            waffen.setItemMeta(wmeta);this.buy(p.getUniqueId(), p, p.getName(), waffen, 1000, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Rüstung Pack")) {
            ItemStack rüstung = new ItemStack(Material.BOOK, 1);
            ItemMeta rümeta = rüstung.getItemMeta();
            rümeta.setDisplayName("§6Rüstung Pack");
            rümeta.setLore(Arrays.asList(" ", "§7Kosten: §a1000$"));
            rüstung.setItemMeta(rümeta);
            this.buy(p.getUniqueId(), p, p.getName(), rüstung, 1000, true);
         }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Alles Oder Nichts Pack")) {
            ItemStack aon = new ItemStack(Material.BOOK, 1);
            ItemMeta aonmeta = aon.getItemMeta();
            aonmeta.setDisplayName("§6Alles Oder Nichts Pack");
            aonmeta.setLore(Arrays.asList(" ", "§7Kosten: §a2500$"));
            aon.setItemMeta(aonmeta); this.buy(p.getUniqueId(), p, p.getName(), aon, 2500, true);
         }
      }else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rang §6Premium §7kaufen?")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 12000.0D);
            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta stackmeta = stack.getItemMeta();
            stackmeta.setDisplayName("§7Ranggutschein §8× §6Premium");
            stackmeta.setLore(Arrays.asList(" ", "§7Rechtsklick zum Einlösen!"));
            stack.setItemMeta(stackmeta);
            p.getInventory().addItem(new ItemStack[]{stack});
            scoreBoard.update();
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rang §dObsidian §7kaufen?")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 25000.0D);
            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta stackmeta = stack.getItemMeta();
            stackmeta.setDisplayName("§7Ranggutschein §8× §dObsidian");
            stackmeta.setLore(Arrays.asList(" ", "§7Rechtsklick zum Einlösen!"));
            stack.setItemMeta(stackmeta);
            p.getInventory().addItem(new ItemStack[]{stack});
            scoreBoard.update();
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rang §9Titan §7kaufen?")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 40000.0D);
            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta stackmeta = stack.getItemMeta();
            stackmeta.setDisplayName("§7Ranggutschein §8× §9Titan");
            stackmeta.setLore(Arrays.asList(" ", "§7Rechtsklick zum Einlösen!"));
            stack.setItemMeta(stackmeta);
            p.getInventory().addItem(new ItemStack[]{stack});
            scoreBoard.update();
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rang §5Bedrock §7kaufen?")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 75000.0D);
            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta stackmeta = stack.getItemMeta();
            stackmeta.setDisplayName("§7Ranggutschein §8× §5Bedrock");
            stackmeta.setLore(Arrays.asList(" ", "§7Rechtsklick zum Einlösen!"));
            stack.setItemMeta(stackmeta);
            p.getInventory().addItem(new ItemStack[]{stack});
            scoreBoard.update();
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rang §c§lLegende §7kaufen?")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 175000.0D);
            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta stackmeta = stack.getItemMeta();
            stackmeta.setDisplayName("§7Ranggutschein §8× §c§lLegende");
            stackmeta.setLore(Arrays.asList(" ", "§7Rechtsklick zum Einlösen!"));
            stack.setItemMeta(stackmeta);
            p.getInventory().addItem(new ItemStack[]{stack});
            scoreBoard.update();
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      }else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rang §e§lPhoenix §7kaufen?")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 200000.0D);
            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta stackmeta = stack.getItemMeta();
            stackmeta.setDisplayName("§7Ranggutschein §8× §e§lPhoenix");
            stackmeta.setLore(Arrays.asList(" ", "§7Rechtsklick zum Einlösen!"));
            stack.setItemMeta(stackmeta);
            p.getInventory().addItem(new ItemStack[]{stack});
            scoreBoard.update();
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      }else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rangupgrade §6Premium")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            p.getInventory().remove(p.getInventory().getItemInHand());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " premium");
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rangupgrade §dObsidian")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            p.getInventory().remove(p.getInventory().getItemInHand());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " obsidian");
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rangupgrade §9Titan")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            p.getInventory().remove(p.getInventory().getItemInHand());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " titan");
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rangupgrade §5Bedrock")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            p.getInventory().remove(p.getInventory().getItemInHand());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " bedrock");
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      } else if (e.getInventory().getTitle().equalsIgnoreCase("§7Rangupgrade §c§lLegende")) {
         e.setCancelled(true);
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJa")) {
            p.closeInventory();
            p.getInventory().remove(p.getInventory().getItemInHand());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " legende");
         } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNein")) {
            p.closeInventory();
         }
      }

   }

   public void buy(UUID uuid, Player player, String name, ItemStack stack, int moneyamount, Boolean bool) {
      int f = 0;
      Score score = new Score(player);
      for(int i = 0; i < player.getInventory().getContents().length; ++i) {
         if (player.getInventory().getContents()[i] != null) {
            ++f;
         }
      }

      if (MySQL.getcoins(uuid.toString()) >= (double)moneyamount) {
         if (f > 35) {
            player.sendMessage(SkyPvP.getPrefix() + "§cDein Inventar ist voll!");
         } else {
            MySQL.setcoins(uuid.toString(), MySQL.getcoins(uuid.toString())-(double)moneyamount);
            player.closeInventory();
            player.getInventory().addItem(new ItemStack[]{stack});
            if (!bool) {
               player.sendMessage(SkyPvP.getPrefix() + "§7Du hast §a" + stack.getAmount() + " §7mal §a" + stack.getType().toString() + " §7gekauft!");
            } else if (bool) {
               player.sendMessage(SkyPvP.getPrefix() + "§7Du hast §a" + stack.getAmount() + " §7mal §a" + stack.getItemMeta().getDisplayName() + " §7gekauft!");
            }
         }
      } else {
         player.sendMessage(SkyPvP.getPrefix() + "§cDu hast nicht genug Geld!");
      }
      score.update();
   }
}
