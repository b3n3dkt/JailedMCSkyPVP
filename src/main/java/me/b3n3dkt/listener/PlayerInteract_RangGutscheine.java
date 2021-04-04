package me.b3n3dkt.listener;

import java.util.Arrays;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.Rang;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteract_RangGutscheine implements Listener {
   @EventHandler
   public void onHandle(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      if (e.getAction() != Action.RIGHT_CLICK_AIR) {
         e.getAction();
         Action var10000 = Action.RIGHT_CLICK_BLOCK;
      }

      if (e.getItem() != null && e.getItem() != new ItemStack(Material.AIR) && e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getDisplayName() != null) {
         ItemStack stack = e.getItem();
         String name = stack.getItemMeta().getDisplayName();
         if (stack.getType() == Material.BOOK) {
            e.setCancelled(true);
            Inventory inv;
            ItemStack glas;
            ItemMeta glasmeta;
            ItemStack greenglas;
            ItemMeta greenglasmeta;
            ItemStack redglas;
            ItemMeta redglasmeta;
            int i;
            if (name.equals("§7Ranggutschein §8× §6Premium")) {
               if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) > 21) {
                  inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rangupgrade §6Premium");
                  p.openInventory(inv);
                  glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                  glasmeta = glas.getItemMeta();
                  glasmeta.setDisplayName("§e§l");
                  glas.setItemMeta(glasmeta);
                  greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                  greenglasmeta = greenglas.getItemMeta();
                  greenglasmeta.setDisplayName("§aJa");
                  greenglasmeta.setLore(Arrays.asList(" ", "§7Wenn du auf 'Ja' klickst, bekommst du den §6Premium §7Rang!"));
                  greenglas.setItemMeta(greenglasmeta);
                  redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                  redglasmeta = redglas.getItemMeta();
                  redglasmeta.setDisplayName("§cNein");
                  redglas.setItemMeta(redglasmeta);

                  for(i = 0; i < 27; ++i) {
                     inv.setItem(i, glas);
                  }

                  inv.setItem(11, greenglas);
                  inv.setItem(15, redglas);
                  p.updateInventory();
               } else if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 21) {
                  if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 21) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                  }else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                  }
               }
            } else if (name.equals("§7Ranggutschein §8× §dObsidian")) {
               if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 20) {
                  if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 20) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                  }
               } else {
                  inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rangupgrade §dObsidian");
                  p.openInventory(inv);
                  glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                  glasmeta = glas.getItemMeta();
                  glasmeta.setDisplayName("§e§l");
                  glas.setItemMeta(glasmeta);
                  greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                  greenglasmeta = greenglas.getItemMeta();
                  greenglasmeta.setDisplayName("§aJa");
                  greenglasmeta.setLore(Arrays.asList(" ", "§7Wenn du auf 'Ja' klickst, bekommst du den §dObsidian §7Rang!"));
                  greenglas.setItemMeta(greenglasmeta);
                  redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                  redglasmeta = redglas.getItemMeta();
                  redglasmeta.setDisplayName("§cNein");
                  redglas.setItemMeta(redglasmeta);

                  for(i = 0; i < 27; ++i) {
                     inv.setItem(i, glas);
                  }

                  inv.setItem(11, greenglas);
                  inv.setItem(15, redglas);
                  p.updateInventory();
               }
            } else if (name.equals("§7Ranggutschein §8× §9Titan")) {
               if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 19) {
                     if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 19) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                  }
               } else {
                  inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rangupgrade §9Titan");
                  p.openInventory(inv);
                  glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                  glasmeta = glas.getItemMeta();
                  glasmeta.setDisplayName("§e§l");
                  glas.setItemMeta(glasmeta);
                  greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                  greenglasmeta = greenglas.getItemMeta();
                  greenglasmeta.setDisplayName("§aJa");
                  greenglasmeta.setLore(Arrays.asList(" ", "§7Wenn du auf 'Ja' klickst, bekommst du den §9Titan §7Rang!"));
                  greenglas.setItemMeta(greenglasmeta);
                  redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                  redglasmeta = redglas.getItemMeta();
                  redglasmeta.setDisplayName("§cNein");
                  redglas.setItemMeta(redglasmeta);

                  for(i = 0; i < 27; ++i) {
                     inv.setItem(i, glas);
                  }

                  inv.setItem(11, greenglas);
                  inv.setItem(15, redglas);
                  p.updateInventory();
               }
            } else if (name.equals("§7Ranggutschein §8× §c§lLegende")) {
               if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 17) {
                  if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 17) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                  }
               } else {
                  inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rangupgrade §c§lLegende");
                  p.openInventory(inv);
                  glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                  glasmeta = glas.getItemMeta();
                  glasmeta.setDisplayName("§e§l");
                  glas.setItemMeta(glasmeta);
                  greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                  greenglasmeta = greenglas.getItemMeta();
                  greenglasmeta.setDisplayName("§aJa");
                  greenglasmeta.setLore(Arrays.asList(" ", "§7Wenn du auf 'Ja' klickst, bekommst du den §c§lLegende §7Rang!"));
                  greenglas.setItemMeta(greenglasmeta);
                  redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                  redglasmeta = redglas.getItemMeta();
                  redglasmeta.setDisplayName("§cNein");
                  redglas.setItemMeta(redglasmeta);

                  for(i = 0; i < 27; ++i) {
                     inv.setItem(i, glas);
                  }

                  inv.setItem(11, greenglas);
                  inv.setItem(15, redglas);
                  p.updateInventory();
               }
            } else if(name.equals("§7Ranggutschein §8× §5Bedrock")) {
               if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 18) {
                  if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 18) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                  }
               } else {
                  inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rangupgrade §5Bedrock");
                  p.openInventory(inv);
                  glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                  glasmeta = glas.getItemMeta();
                  glasmeta.setDisplayName("§e§l");
                  glas.setItemMeta(glasmeta);
                  greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                  greenglasmeta = greenglas.getItemMeta();
                  greenglasmeta.setDisplayName("§aJa");
                  greenglasmeta.setLore(Arrays.asList(" ", "§7Wenn du auf 'Ja' klickst, bekommst du den §5Bedrock §7Rang!"));
                  greenglas.setItemMeta(greenglasmeta);
                  redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                  redglasmeta = redglas.getItemMeta();
                  redglasmeta.setDisplayName("§cNein");
                  redglas.setItemMeta(redglasmeta);

                  for(i = 0; i < 27; ++i) {
                     inv.setItem(i, glas);
                  }

                  inv.setItem(11, greenglas);
                  inv.setItem(15, redglas);
                  p.updateInventory();
               }
            }else if (name.equals("§7Ranggutschein §8× §e§lPhoenix")) {
               if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 16) {
                  if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 16) {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                  } else {
                     p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                  }
               } else {
                  inv = Bukkit.createInventory((InventoryHolder)null, 27, "§7Rangupgrade §e§lPhoenix");
                  p.openInventory(inv);
                  glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                  glasmeta = glas.getItemMeta();
                  glasmeta.setDisplayName("§e§l");
                  glas.setItemMeta(glasmeta);
                  greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                  greenglasmeta = greenglas.getItemMeta();
                  greenglasmeta.setDisplayName("§aJa");
                  greenglasmeta.setLore(Arrays.asList(" ", "§7Wenn du auf 'Ja' klickst, bekommst du den §e§lPhoenix §7Rang!"));
                  greenglas.setItemMeta(greenglasmeta);
                  redglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
                  redglasmeta = redglas.getItemMeta();
                  redglasmeta.setDisplayName("§cNein");
                  redglas.setItemMeta(redglasmeta);

                  for(i = 0; i < 27; ++i) {
                     inv.setItem(i, glas);
                  }

                  inv.setItem(11, greenglas);
                  inv.setItem(15, redglas);
                  p.updateInventory();
               }
            }
         } else {
            e.setCancelled(false);
         }

      }
   }

   public void remove(Inventory inv, Material mat, int amount) {
      ItemStack[] var7;
      int var6 = (var7 = inv.getContents()).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         ItemStack item = var7[var5];
         if (item.getType() == mat && item.getAmount() >= amount) {
            item.setAmount(item.getAmount() - amount);
            return;
         }
      }

   }
}
