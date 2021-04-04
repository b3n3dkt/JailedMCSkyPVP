package me.b3n3dkt.utils;

import java.util.Arrays;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;

public class Inventorys {
   public static Inventory maininv;

   public static void openShop(Player player) {
      maininv = Bukkit.createInventory((InventoryHolder)null, 54, "§6§lShop");
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack beef = new ItemStack(Material.COOKED_BEEF);
      ItemMeta beefmeta = beef.getItemMeta();
      beefmeta.setDisplayName("§6Essen");
      beef.setItemMeta(beefmeta);
      ItemStack rüstung = new ItemStack(Material.DIAMOND_CHESTPLATE);
      ItemMeta rüstungmeta = rüstung.getItemMeta();
      rüstungmeta.setDisplayName("§6Rüstungen");
      rüstung.setItemMeta(rüstungmeta);
      ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
      ItemMeta schwertmeta = schwert.getItemMeta();
      schwertmeta.setDisplayName("§6Waffen");
      schwert.setItemMeta(schwertmeta);
      ItemStack tränke = new ItemStack(Material.POTION);
      ItemMeta tränkemeta = tränke.getItemMeta();
      tränkemeta.setDisplayName("§6Tränke");
      tränke.setItemMeta(tränkemeta);
      ItemStack kits = new ItemStack(Material.PAPER);
      ItemMeta kitsmeta = kits.getItemMeta();
      kitsmeta.setDisplayName("§6Kit-Gutscheine");
      kits.setItemMeta(kitsmeta);
      ItemStack pack = new ItemStack(Material.BOOK);
      ItemMeta packmeta = pack.getItemMeta();
      packmeta.setDisplayName("§6Packs");
      pack.setItemMeta(packmeta);
      DyeColor blue = DyeColor.BLUE;
      byte bluedata = (byte)(15 - blue.getData());
      ItemStack rang = new ItemStack(Material.INK_SACK, 1, bluedata);
      ItemMeta rangmeta = rang.getItemMeta();
      rangmeta.setDisplayName("§6Rang-Gutscheine");
      rang.setItemMeta(rangmeta);
      ItemStack glas1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
      ItemMeta glas1meta = glas1.getItemMeta();
      glas1meta.setDisplayName("§8???");
      glas1.setItemMeta(glas1meta);
      player.openInventory(maininv);

      for(int i = 0; i < 54; ++i) {
         maininv.setItem(i, glas);
      }

      maininv.setItem(0, kits);
      maininv.setItem(9, beef);
      maininv.setItem(18, rüstung);
      maininv.setItem(27, schwert);
      maininv.setItem(36, tränke);
      maininv.setItem(45, pack);
      maininv.setItem(8, rang);
      maininv.setItem(17, glas1);
      maininv.setItem(26, glas1);
      maininv.setItem(35, glas1);
      maininv.setItem(44, glas1);
      maininv.setItem(53, glas1);
      player.updateInventory();
   }

   public static void openBelohnungen(Player player) {
      Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§6§lBelohnungen");
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack tskull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta tmeta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
      tmeta.setDisplayName("§6§lTägliche Belohnungen");
      tmeta.setOwner("MHF_Chest");
      tskull.setItemMeta(tmeta);
      ItemStack wskull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta wmeta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
      wmeta.setDisplayName("§6§lWöchentliche Belohnungen");
      wmeta.setOwner("MHF_Chest");
      wskull.setItemMeta(wmeta);
      ItemStack mskull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta mmeta = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
      mmeta.setDisplayName("§6§lMonatliche Belohnungen");
      mmeta.setOwner("MHF_Chest");
      mskull.setItemMeta(mmeta);
      player.openInventory(inv);

      for(int i = 0; i < 27; ++i) {
         inv.setItem(i, glas);
      }

      inv.setItem(11, tskull);
      inv.setItem(13, wskull);
      inv.setItem(15, mskull);
      player.updateInventory();
   }

   public static void openRang(Player player) {
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      DyeColor yellow = DyeColor.YELLOW;
      byte yellowdata = (byte)(15 - yellow.getData());
      ItemStack phoenix = new ItemStack(Material.INK_SACK, 1, yellowdata);
      ItemMeta phoenixmeta = phoenix.getItemMeta();
      phoenixmeta.setDisplayName("§7Ranggutschein §8× §e§lPhoenix");
      phoenixmeta.setLore(Arrays.asList(" ", "§7Kosten: §a200.000$"));
      phoenix.setItemMeta(phoenixmeta);
      DyeColor red = DyeColor.RED;
      byte reddata = (byte)(15 - red.getData());
      ItemStack legende = new ItemStack(Material.INK_SACK, 1, reddata);
      ItemMeta legendemeta = legende.getItemMeta();
      legendemeta.setDisplayName("§7Ranggutschein §8× §c§lLegende");
      legendemeta.setLore(Arrays.asList(" ", "§7Kosten: §a175.000$"));
      legende.setItemMeta(legendemeta);
      DyeColor purple = DyeColor.PURPLE;
      byte purpledata = (byte)(15 - purple.getData());
      ItemStack bedrock = new ItemStack(Material.INK_SACK, 1, purpledata);
      ItemMeta bedrockmeta = bedrock.getItemMeta();
      bedrockmeta.setDisplayName("§7Ranggutschein §8× §5Bedrock");
      bedrockmeta.setLore(Arrays.asList(" ", "§7Kosten: §a75.000$"));
      bedrock.setItemMeta(bedrockmeta);
      DyeColor blue = DyeColor.BLUE;
      byte bluedata = (byte)(15 - blue.getData());
      ItemStack titan = new ItemStack(Material.INK_SACK, 1, bluedata);
      ItemMeta titanmeta = titan.getItemMeta();
      titanmeta.setDisplayName("§7Ranggutschein §8× §9Titan");
      titanmeta.setLore(Arrays.asList(" ", "§7Kosten: §a40.000$"));
      titan.setItemMeta(titanmeta);
      DyeColor pink = DyeColor.PINK;
      byte pinkdata = (byte)(15 - pink.getData());
      ItemStack obsidian = new ItemStack(Material.INK_SACK, 1, pinkdata);
      ItemMeta obsidianmeta = obsidian.getItemMeta();
      obsidianmeta.setDisplayName("§7Ranggutschein §8× §dObsidian");
      obsidianmeta.setLore(Arrays.asList(" ", "§7Kosten: §a25.000$"));
      obsidian.setItemMeta(obsidianmeta);
      DyeColor orange = DyeColor.ORANGE;
      byte orangedata = (byte)(15 - orange.getData());
      ItemStack premium = new ItemStack(Material.INK_SACK, 1, orangedata);
      ItemMeta premiummeta = premium.getItemMeta();
      premiummeta.setDisplayName("§7Ranggutschein §8× §6Premium");
      premiummeta.setLore(Arrays.asList(" ", "§7Kosten: §a12.000$"));
      premium.setItemMeta(premiummeta);
      maininv.setItem(11, premium);
      maininv.setItem(13, obsidian);
      maininv.setItem(15, titan);
      maininv.setItem(29, bedrock);
      maininv.setItem(33, legende);
      maininv.setItem(40, phoenix);
      maininv.setItem(7, glas);
   }

   public static void openPack(Player player) {
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack kits = new ItemStack(Material.BOOK, 1);
      ItemMeta kmeta = kits.getItemMeta();
      kmeta.setDisplayName("§6Kit Pack");
      kmeta.setLore(Arrays.asList(" ", "§7Kosten: §a750$"));
      kits.setItemMeta(kmeta);
      ItemStack rang = new ItemStack(Material.BOOK, 1);
      ItemMeta rmeta = rang.getItemMeta();
      rmeta.setDisplayName("§6Rang Pack");
      rmeta.setLore(Arrays.asList(" ", "§7Kosten: §a5000$"));
      rang.setItemMeta(rmeta);
      ItemStack waffen = new ItemStack(Material.BOOK, 1);
      ItemMeta wmeta = waffen.getItemMeta();
      wmeta.setDisplayName("§6Waffen Pack");
      wmeta.setLore(Arrays.asList(" ", "§7Kosten: §a1000$"));
      waffen.setItemMeta(wmeta);
      ItemStack rüstung = new ItemStack(Material.BOOK, 1);
      ItemMeta rümeta = rüstung.getItemMeta();
      rümeta.setDisplayName("§6Rüstung Pack");
      rümeta.setLore(Arrays.asList(" ", "§7Kosten: §a1000$"));
      rüstung.setItemMeta(rümeta);
      ItemStack aon = new ItemStack(Material.BOOK, 1);
      ItemMeta aonmeta = aon.getItemMeta();
      aonmeta.setDisplayName("§6Alles Oder Nichts Pack");
      aonmeta.setLore(Arrays.asList(" ", "§7Kosten: §a2500$"));
      aon.setItemMeta(aonmeta);
      maininv.setItem(46, glas);
      maininv.setItem(20, aon);
      maininv.setItem(21, rüstung);
      maininv.setItem(22, waffen);
      maininv.setItem(23, rang);
      maininv.setItem(24, kits);
   }

   public static void openKitG(Player player) {
      ItemStack glas1 = new ItemStack(Material.STAINED_GLASS_PANE, 1);
      ItemMeta glas1meta = glas1.getItemMeta();
      glas1meta.setDisplayName("§e§l");
      glas1.setItemMeta(glas1meta);
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      DyeColor orange = DyeColor.ORANGE;
      byte orangedata = (byte)(15 - orange.getData());
      ItemStack premium = new ItemStack(Material.INK_SACK, 1, orangedata);
      ItemMeta premiummeta = premium.getItemMeta();
      premiummeta.setDisplayName("§7Kitgutschein §8× §6Premium");
      premiummeta.setLore(Arrays.asList(" ", "§7Kosten: §a500$"));
      premium.setItemMeta(premiummeta);
      DyeColor pink = DyeColor.PINK;
      byte pinkdata = (byte)(15 - pink.getData());
      ItemStack obsidian = new ItemStack(Material.INK_SACK, 1, pinkdata);
      ItemMeta obsidianmeta = obsidian.getItemMeta();
      obsidianmeta.setDisplayName("§7Kitgutschein §8× §dObsidian");
      obsidianmeta.setLore(Arrays.asList(" ", "§7Kosten: §a750$"));
      obsidian.setItemMeta(obsidianmeta);
      DyeColor blue = DyeColor.BLUE;
      byte bluedata = (byte)(15 - blue.getData());
      ItemStack titan = new ItemStack(Material.INK_SACK, 1, bluedata);
      ItemMeta titanmeta = titan.getItemMeta();
      titanmeta.setDisplayName("§7Kitgutschein §8× §9Titan");
      titanmeta.setLore(Arrays.asList(" ", "§7Kosten: §a1.000$"));
      titan.setItemMeta(titanmeta);
      DyeColor purple = DyeColor.PURPLE;
      byte purpledata = (byte)(15 - purple.getData());
      ItemStack bedrock = new ItemStack(Material.INK_SACK, 1, purpledata);
      ItemMeta bedrockmeta = bedrock.getItemMeta();
      bedrockmeta.setDisplayName("§7Kitgutschein §8× §5Bedrock");
      bedrockmeta.setLore(Arrays.asList(" ", "§7Kosten: §a1.250$"));
      bedrock.setItemMeta(bedrockmeta);
      DyeColor red = DyeColor.RED;
      byte reddata = (byte)(15 - red.getData());
      ItemStack legende = new ItemStack(Material.INK_SACK, 1, reddata);
      ItemMeta legendemeta = legende.getItemMeta();
      legendemeta.setDisplayName("§7Kitgutschein §8× §c§lLegende");
      legendemeta.setLore(Arrays.asList(" ", "§7Kosten: §a1.500$"));
      legende.setItemMeta(legendemeta);
      DyeColor yellow = DyeColor.YELLOW;
      byte yellowdata = (byte)(15 - yellow.getData());
      ItemStack phoenix = new ItemStack(Material.INK_SACK, 1, yellowdata);
      ItemMeta phoenixmeta = phoenix.getItemMeta();
      phoenixmeta.setDisplayName("§7Kitgutschein §8× §e§lPhoenix");
      phoenixmeta.setLore(Arrays.asList(" ", "§7Kosten: §a2.250$"));
      phoenix.setItemMeta(phoenixmeta);
      DyeColor green = DyeColor.LIME;
      byte greendata = (byte)(15 - green.getData());
      ItemStack vote = new ItemStack(Material.INK_SACK, 1, greendata);
      ItemMeta votemeta = vote.getItemMeta();
      votemeta.setDisplayName("§7Kitgutschein §8× §aVote");
      votemeta.setLore(Arrays.asList(" ", "§cBald Verfügbar durch Voten!"));
      vote.setItemMeta(votemeta);
      maininv.setItem(1, glas);
      maininv.setItem(12, premium);
      maininv.setItem(13, obsidian);
      maininv.setItem(14, titan);
      maininv.setItem(21, bedrock);
      maininv.setItem(22, legende);
      maininv.setItem(23, phoenix);
      maininv.setItem(30, vote);
      player.updateInventory();
   }

   public static void openEssen(Player player) {
      ItemStack glas1 = new ItemStack(Material.STAINED_GLASS_PANE, 1);
      ItemMeta glas1meta = glas1.getItemMeta();
      glas1meta.setDisplayName("§e§l");
      glas1.setItemMeta(glas1meta);
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack beef = new ItemStack(Material.COOKED_BEEF, 32);
      ItemMeta beefmeta = beef.getItemMeta();
      beefmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      beefmeta.setDisplayName("§7Steaks");
      beef.setItemMeta(beefmeta);
      ItemStack gapple5 = new ItemStack(Material.GOLDEN_APPLE, 5);
      ItemMeta gapple5meta = gapple5.getItemMeta();
      gapple5meta.setLore(Arrays.asList(" ", "§7Kosten: §a20$"));
      gapple5meta.setDisplayName("§7Goldener Apfel");
      gapple5.setItemMeta(gapple5meta);
      ItemStack bread = new ItemStack(Material.BREAD, 32);
      ItemMeta breadmeta = bread.getItemMeta();
      breadmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      breadmeta.setDisplayName("§7Brot");
      bread.setItemMeta(breadmeta);
      ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP, 1);
      ItemMeta soupmeta = soup.getItemMeta();
      soupmeta.setLore(Arrays.asList(" ", "§7Kosten: §a5$"));
      soupmeta.setDisplayName("§7Suppe");
      soup.setItemMeta(soupmeta);
      ItemStack cookie = new ItemStack(Material.COOKIE, 32);
      ItemMeta cookiemeta = cookie.getItemMeta();
      cookiemeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      cookiemeta.setDisplayName("§7Cookie");
      cookie.setItemMeta(cookiemeta);
      ItemStack porkchop = new ItemStack(Material.GRILLED_PORK, 32);
      ItemMeta porkchopmeta = porkchop.getItemMeta();
      porkchopmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      porkchopmeta.setDisplayName("§7Schweine Fleisch");
      porkchop.setItemMeta(porkchopmeta);
      ItemStack cake = new ItemStack(Material.PUMPKIN_PIE, 1);
      ItemMeta cakemeta = cake.getItemMeta();
      cakemeta.setLore(Arrays.asList(" ", "§7Kosten: §a5$"));
      cakemeta.setDisplayName("§7Kürbis Kuchen");
      cake.setItemMeta(cakemeta);
      ItemStack potatoe = new ItemStack(Material.BAKED_POTATO, 32);
      ItemMeta potatoemeta = potatoe.getItemMeta();
      potatoemeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      potatoemeta.setDisplayName("§7Gebratene Kartoffel");
      potatoe.setItemMeta(potatoemeta);
      ItemStack carrot = new ItemStack(Material.CARROT, 32);
      ItemMeta carrotmeta = carrot.getItemMeta();
      carrotmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      carrotmeta.setDisplayName("§7Karotten");
      carrot.setItemMeta(carrotmeta);
      ItemStack chicken = new ItemStack(Material.COOKED_CHICKEN, 32);
      ItemMeta chickenmeta = chicken.getItemMeta();
      chickenmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      chickenmeta.setDisplayName("§7Gebratenes Hünchen");
      chicken.setItemMeta(chickenmeta);
      ItemStack rabbit = new ItemStack(Material.COOKED_RABBIT, 32);
      ItemMeta rabbitmeta = rabbit.getItemMeta();
      rabbitmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      rabbitmeta.setDisplayName("§7Gebratener Hase");
      rabbit.setItemMeta(rabbitmeta);
      ItemStack sheep = new ItemStack(Material.COOKED_MUTTON, 32);
      ItemMeta sheepmeta = sheep.getItemMeta();
      sheepmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      sheepmeta.setDisplayName("§7Gebratenes Schaaf");
      sheep.setItemMeta(sheepmeta);
      ItemStack melon = new ItemStack(Material.MELON, 32);
      ItemMeta melonmeta = melon.getItemMeta();
      melonmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      melonmeta.setDisplayName("§7Melone");
      melon.setItemMeta(melonmeta);
      ItemStack opgapple = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
      ItemMeta opgapplemeta = opgapple.getItemMeta();
      opgapplemeta.setLore(Arrays.asList(" ", "§7Kosten: §a150$"));
      opgapplemeta.setDisplayName("§7Verzauberter Goldener Apfel");
      opgapple.setItemMeta(opgapplemeta);
      ItemStack salmon = new ItemStack(Material.COOKED_FISH, 32);
      ItemMeta salmonmeta = salmon.getItemMeta();
      salmonmeta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      salmonmeta.setDisplayName("§7Gebratener Fisch");
      salmon.setItemMeta(salmonmeta);
      maininv.setItem(10, glas);
      maininv.setItem(11, beef);
      maininv.setItem(12, gapple5);
      maininv.setItem(13, salmon);
      maininv.setItem(14, bread);
      maininv.setItem(15, soup);
      maininv.setItem(20, cookie);
      maininv.setItem(21, porkchop);
      maininv.setItem(22, cake);
      maininv.setItem(23, potatoe);
      maininv.setItem(24, carrot);
      maininv.setItem(29, chicken);
      maininv.setItem(30, rabbit);
      maininv.setItem(31, sheep);
      maininv.setItem(32, melon);
      maininv.setItem(33, opgapple);
      player.updateInventory();
   }

   public static void openRüstung(Player player) {
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack helm1 = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e1 §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setLore("§7Kosten: §a250$").build();
      ItemStack helm2 = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e2 §7Helm").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).setLore("§7Kosten: §a400$").build();
      ItemStack helm3 = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e3 §7Helm").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setLore("§7Kosten: §a550$").build();
      ItemStack helm4 = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§7Stufe §e4 §7Helm").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).setLore("§7Kosten: §a700$").build();
      ItemStack rasorhelm = (new ItemBuilder(Material.DIAMOND_HELMET)).setAmount(1).setDisplayName("§b§lRasor §7Helm").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).setLore("§7Kosten: §a2.000$").build();
      ItemStack brust1 = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e1 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setLore("§7Kosten: §a250$").build();
      ItemStack brust2 = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e2 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).setLore("§7Kosten: §a400$").build();
      ItemStack brust3 = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e3 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setLore("§7Kosten: §a550$").build();
      ItemStack brust4 = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§7Stufe §e4 §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).setLore("§7Kosten: §a700$").build();
      ItemStack rasorbrust = (new ItemBuilder(Material.DIAMOND_CHESTPLATE)).setAmount(1).setDisplayName("§b§lRasor §7Brustpanzer").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).setLore("§7Kosten: §a2.000$").build();
      ItemStack hose1 = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e1 §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setLore("§7Kosten: §a250$").build();
      ItemStack hose2 = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e2 §7Hose").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).setLore("§7Kosten: §a400$").build();
      ItemStack hose3 = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e3 §7Hose").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setLore("§7Kosten: §a550$").build();
      ItemStack hose4 = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§7Stufe §e4 §7Hose").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).setLore("§7Kosten: §a700$").build();
      ItemStack rasorhose = (new ItemBuilder(Material.DIAMOND_LEGGINGS)).setAmount(1).setDisplayName("§b§lRasor §7Hose").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).setLore("§7Kosten: §a2.000$").build();
      ItemStack schuhe1 = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e1 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setLore("§7Kosten: §a250$").build();
      ItemStack schuhe2 = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e2 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).setLore("§7Kosten: §a400$").build();
      ItemStack schuhe3 = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e3 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setLore("§7Kosten: §a550$").build();
      ItemStack schuhe4 = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§7Stufe §e4 §7Schuhe").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).setEnchantment(Enchantment.THORNS, 2).setLore("§7Kosten: §a700$").build();
      ItemStack rasorschuhe = (new ItemBuilder(Material.DIAMOND_BOOTS)).setAmount(1).setDisplayName("§b§lRasor §7Schuhe").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 15).setEnchantment(Enchantment.THORNS, 5).setLore("§7Kosten: §a2.000$").build();
      maininv.setItem(19, glas);
      maininv.setItem(11, helm1);
      maininv.setItem(20, brust1);
      maininv.setItem(29, hose1);
      maininv.setItem(38, schuhe1);
      maininv.setItem(12, helm2);
      maininv.setItem(21, brust2);
      maininv.setItem(30, hose2);
      maininv.setItem(39, schuhe2);
      maininv.setItem(13, helm3);
      maininv.setItem(22, brust3);
      maininv.setItem(31, hose3);
      maininv.setItem(40, schuhe3);
      maininv.setItem(14, helm4);
      maininv.setItem(23, brust4);
      maininv.setItem(32, hose4);
      maininv.setItem(41, schuhe4);
      maininv.setItem(15, rasorhelm);
      maininv.setItem(24, rasorbrust);
      maininv.setItem(33, rasorhose);
      maininv.setItem(42, rasorschuhe);
      player.updateInventory();
   }

   public static void openSchwerter(Player player) {
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack rasorsword = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§b§lRasor §7Sword").setEnchantment(Enchantment.FIRE_ASPECT, 1).setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.DAMAGE_ALL, 20).setLore("§7Kosten: §a3.500$").build();
      ItemStack sword1 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e1 §7Schwert").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.DAMAGE_ALL, 3).setEnchantment(Enchantment.FIRE_ASPECT, 1).setLore("§7Kosten: §a250$").build();
      ItemStack sword2 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e2 §7Schwert").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.DAMAGE_ALL, 5).setLore("§7Kosten: §a400$").build();
      ItemStack sword3 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e3 §7Schwert").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.DAMAGE_ALL, 5).setEnchantment(Enchantment.FIRE_ASPECT, 1).setLore("§7Kosten: §a600$").build();
      ItemStack sword4 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e4 §7Schwert").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.DAMAGE_ALL, 7).setLore("§7Kosten: §a750$").build();
      ItemStack sword5 = (new ItemBuilder(Material.DIAMOND_SWORD)).setAmount(1).setDisplayName("§7Stufe §e5 §7Schwert").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.DAMAGE_ALL, 7).setEnchantment(Enchantment.FIRE_ASPECT, 1).setLore("§7Kosten: §a900$").build();
      ItemStack rasorbow = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§b§lRasor §7Bogen").setEnchantment(Enchantment.DURABILITY, 20).setEnchantment(Enchantment.ARROW_INFINITE, 1).setEnchantment(Enchantment.ARROW_DAMAGE, 5).setEnchantment(Enchantment.ARROW_FIRE, 1).setEnchantment(Enchantment.ARROW_KNOCKBACK, 3).setLore("§7Kosten: §a4.000$").build();
      ItemStack bow1 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e1 §7Bogen").setEnchantment(Enchantment.DURABILITY, 3).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setLore("§7Kosten: §a200$").build();
      ItemStack bow2 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e2 §7Bogen").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.ARROW_DAMAGE, 3).setLore("§7Kosten: §a400$").build();
      ItemStack bow3 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e3 §7Bogen").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.ARROW_DAMAGE, 4).setLore("§7Kosten: §a600$").build();
      ItemStack bow4 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e4 §7Bogen").setEnchantment(Enchantment.DURABILITY, 5).setEnchantment(Enchantment.ARROW_DAMAGE, 2).setEnchantment(Enchantment.ARROW_FIRE, 1).setLore("§7Kosten: §a850$").build();
      ItemStack bow5 = (new ItemBuilder(Material.BOW)).setAmount(1).setDisplayName("§7Stufe §e5 §7Bogen").setEnchantment(Enchantment.DURABILITY, 7).setEnchantment(Enchantment.ARROW_DAMAGE, 4).setEnchantment(Enchantment.ARROW_KNOCKBACK, 2).setLore("§7Kosten: §a1.050$").build();
      ItemStack arrow = (new ItemBuilder(Material.ARROW)).setAmount(32).setDisplayName("§7Pfeile").setLore("§7Kosten: §a50").build();
      maininv.setItem(28, glas);
      maininv.setItem(11, sword1);
      maininv.setItem(12, sword2);
      maininv.setItem(13, sword3);
      maininv.setItem(14, sword4);
      maininv.setItem(15, sword5);
      maininv.setItem(20, rasorsword);
      maininv.setItem(29, bow1);
      maininv.setItem(30, bow2);
      maininv.setItem(31, bow3);
      maininv.setItem(32, bow4);
      maininv.setItem(33, bow5);
      maininv.setItem(38, rasorbow);
      maininv.setItem(39, arrow);
      player.updateInventory();
   }

   public static void openTränke(Player player) {
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      ItemStack reg = new ItemStack(Material.POTION, 1, (short)8193);
      ItemMeta treg1meta = reg.getItemMeta();
      treg1meta.setDisplayName("§7Regenerations Trank 1");
      treg1meta.setLore(Arrays.asList(" ", "§7Kosten: §a100$"));
      reg.setItemMeta(treg1meta);
      ItemStack wreg1 = new ItemStack(Material.POTION, 1, (short)16385);
      ItemMeta wreg1meta = wreg1.getItemMeta();
      wreg1meta.setDisplayName("§7Werfbarer Regenerations Trank 1");
      wreg1meta.setLore(Arrays.asList(" ", "§7Kosten: §a75$"));
      wreg1.setItemMeta(wreg1meta);
      ItemStack wreg2 = new ItemStack(Material.POTION, 1, (short)16417);
      ItemMeta wreg2meta = wreg2.getItemMeta();
      wreg2meta.setDisplayName("§7Werfbarer Regenerations Trank 2");
      wreg2meta.setLore(Arrays.asList(" ", "§7Kosten: §a50$"));
      wreg2.setItemMeta(wreg2meta);
      ItemStack tswiff1 = new ItemStack(Material.POTION, 1, (short)8194);
      ItemMeta tswiff1meta = tswiff1.getItemMeta();
      tswiff1meta.setDisplayName("§7Schnelligkeitstrank");
      tswiff1meta.setLore(Arrays.asList(" ", "§7Kosten: §a150$"));
      tswiff1.setItemMeta(tswiff1meta);
      ItemStack wsiff1 = new ItemStack(Material.POTION, 1, (short)16386);
      ItemMeta wsiff1meta = wsiff1.getItemMeta();
      wsiff1meta.setDisplayName("§7Werfbarer Schennligkeits Trank");
      wsiff1meta.setLore(Arrays.asList(" ", "§7Kosten: §a100$"));
      wsiff1.setItemMeta(wsiff1meta);
      ItemStack theal1 = new ItemStack(Material.POTION, 1, (short)8261);
      ItemMeta theal1meta = theal1.getItemMeta();
      theal1meta.setDisplayName("§7Heilungstrank 1");
      theal1meta.setLore(Arrays.asList(" ", "§7Kosten: §a25$"));
      theal1.setItemMeta(theal1meta);
      ItemStack wheal1 = new ItemStack(Material.POTION, 1, (short)16453);
      ItemMeta wheal1meta = wheal1.getItemMeta();
      wheal1meta.setDisplayName("§7Werfbarer Heilungstrank 1");
      wheal1meta.setLore(Arrays.asList(" ", "§7Kosten: §a75$"));
      wheal1.setItemMeta(wheal1meta);
      ItemStack wheal2 = new ItemStack(Material.POTION, 1, (short)16421);
      ItemMeta wheal2meta = wheal2.getItemMeta();
      wheal2meta.setDisplayName("§7Werfbarer Heilungstrank 2");
      wheal2meta.setLore(Arrays.asList(" ", "§7Kosten: §a100$"));
      wheal2.setItemMeta(wheal2meta);
      ItemStack wslow = new ItemStack(Material.POTION, 1, (short)16426);
      ItemMeta wslowmeta = wslow.getItemMeta();
      wslowmeta.setDisplayName("§7Werfbarer Langsamkeits Trank");
      wslowmeta.setLore(Arrays.asList(" ", "§7Kosten: §a100$"));
      wslow.setItemMeta(wslowmeta);
      maininv.setItem(37, glas);
      maininv.setItem(12, reg);
      maininv.setItem(13, wreg1);
      maininv.setItem(14, wreg2);
      maininv.setItem(21, tswiff1);
      maininv.setItem(22, wsiff1);
      maininv.setItem(23, theal1);
      maininv.setItem(30, wheal1);
      maininv.setItem(31, wheal2);
      maininv.setItem(32, wslow);
      player.updateInventory();
   }

   public static void openKits(Player player) {
      Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§6§lKits");
      PlayerData data = new PlayerData(player.getUniqueId());
      ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1);
      ItemMeta glasmeta = glas.getItemMeta();
      glasmeta.setDisplayName("§e§l");
      glas.setItemMeta(glasmeta);
      DyeColor gray = DyeColor.GRAY;
      byte graydata = (byte)(15 - gray.getData());
      ItemStack spieler = new ItemStack(Material.INK_SACK, 1, graydata);
      ItemMeta spielermeta = spieler.getItemMeta();
      spielermeta.setDisplayName("§7Spieler");
      spieler.setItemMeta(spielermeta);
      DyeColor orange = DyeColor.ORANGE;
      byte orangedata = (byte)(15 - orange.getData());
      ItemStack premium = new ItemStack(Material.INK_SACK, 1, orangedata);
      ItemMeta premiummeta = premium.getItemMeta();
      premiummeta.setDisplayName("§6Premium");
      premium.setItemMeta(premiummeta);
      DyeColor pink = DyeColor.PINK;
      byte pinkdata = (byte)(15 - pink.getData());
      ItemStack obsidian = new ItemStack(Material.INK_SACK, 1, pinkdata);
      ItemMeta obsidianmeta = obsidian.getItemMeta();
      obsidianmeta.setDisplayName("§dObsidian");
      obsidian.setItemMeta(obsidianmeta);
      DyeColor blue = DyeColor.BLUE;
      byte bluedata = (byte)(15 - blue.getData());
      ItemStack titan = new ItemStack(Material.INK_SACK, 1, bluedata);
      ItemMeta titanmeta = titan.getItemMeta();
      titanmeta.setDisplayName("§9Titan");
      titan.setItemMeta(titanmeta);
      DyeColor purple = DyeColor.PURPLE;
      byte purpledata = (byte)(15 - purple.getData());
      ItemStack bedrock = new ItemStack(Material.INK_SACK, 1, purpledata);
      ItemMeta bedrockmeta = bedrock.getItemMeta();
      bedrockmeta.setDisplayName("§5Bedrock");
      bedrock.setItemMeta(bedrockmeta);
      DyeColor red = DyeColor.RED;
      byte reddata = (byte)(15 - red.getData());
      ItemStack legende = new ItemStack(Material.INK_SACK, 1, reddata);
      ItemMeta legendemeta = legende.getItemMeta();
      legendemeta.setDisplayName("§c§lLegende");
      legende.setItemMeta(legendemeta);
      DyeColor yellow = DyeColor.YELLOW;
      byte yellowdata = (byte)(15 - yellow.getData());
      ItemStack phoenix = new ItemStack(Material.INK_SACK, 1, yellowdata);
      ItemMeta phoenixmeta = phoenix.getItemMeta();
      phoenixmeta.setDisplayName("§e§lPhoenix");
      phoenix.setItemMeta(phoenixmeta);
      ItemStack barrier = new ItemStack(Material.BARRIER, 1);
      ItemMeta barriermeta = barrier.getItemMeta();

      for(int i = 0; i < 54; ++i) {
         inv.setItem(i, glas);
      }

      player.openInventory(inv);

      inv.setItem(40, spieler);
      inv.setItem(38, premium);
      inv.setItem(42, obsidian);
      inv.setItem(34, titan);
      inv.setItem(28, bedrock);
      inv.setItem(25, legende);
      inv.setItem(13, phoenix);
      player.updateInventory();
   }

   public static void openOtherEnderChest(Player player, Player target) {
      EnderChest ec = new EnderChest(target);
      HashMap<Integer, ItemStack> temp = ec.getEnderChest(target);
      Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§5EnderChest");
      player.openInventory(inv);

      for(int i = 0; i < 54; ++i) {
         inv.setItem(i, (ItemStack)temp.get(i));
      }

      player.updateInventory();
   }

   public static void openEnderChest(Player player) {
      EnderChest ec = new EnderChest(player);
      HashMap<Integer, ItemStack> temp = ec.getEnderChest(player);
      Inventory inv = Bukkit.createInventory((InventoryHolder)null, 54, "§5EnderChest");
      player.openInventory(inv);

      for(int i = 0; i < 54; ++i) {
         inv.setItem(i, (ItemStack)temp.get(i));
      }

      player.updateInventory();
   }

}
