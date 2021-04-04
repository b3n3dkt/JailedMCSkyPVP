package me.b3n3dkt.listener;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.mysql.MySQL;
import me.b3n3dkt.utils.Rang;
import me.b3n3dkt.utils.Score;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class InventoryClick_RangShop implements Listener {
    
    @EventHandler
    public void onHandle(InventoryClickEvent e){
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
        if (e.getInventory().getTitle().equals("§6§lRang-Shop")) {
            e.setCancelled(true);
            Inventory inv;
            ItemStack glas;
            ItemMeta glasmeta;
            ItemStack greenglas;
            ItemMeta greenglasmeta;
            ItemStack redglas;
            ItemMeta redglasmeta;
            int i;
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Premium")) {
                e.setCancelled(true);
                if (MySQL.getcoins(uuid) >= 12000.0D) {
                    if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) > 21) {
                        inv = Bukkit.createInventory(p, 27, "§7Rang §6Premium §7kaufen?");
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

                        for(i = 0; i < 27; ++i) {
                            inv.setItem(i, glas);
                        }

                        inv.setItem(11, greenglas);
                        inv.setItem(15, redglas);
                        p.updateInventory();
                    } else if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 21) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                    } else if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 21) {
                        p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst keinen niedriegeren Rang kaufen!");
                    }
                } else {
                    p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§dObsidian")) {
                e.setCancelled(true);
                if (MySQL.getcoins(uuid) >= 25000.0D) {
                    if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 20) {
                        if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 20) {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                        }else {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst keinen niedriegeren Rang kaufen!");
                        }
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

                        for(i = 0; i < 27; ++i) {
                            inv.setItem(i, glas);
                        }

                        inv.setItem(11, greenglas);
                        inv.setItem(15, redglas);
                        p.updateInventory();
                    }
                } else {
                    p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Titan")) {
                e.setCancelled(true);
                if (MySQL.getcoins(uuid) >=40000.0D) {
                    if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 19) {
                        if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 19) {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                        } else {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                        }
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

                        for(i = 0; i < 27; ++i) {
                            inv.setItem(i, glas);
                        }

                        inv.setItem(11, greenglas);
                        inv.setItem(15, redglas);
                        p.updateInventory();
                    }
                } else {
                    p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Bedrock")) {
                e.setCancelled(true);
                if (MySQL.getcoins(uuid) >= 75000.0D) {
                    if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 18) {
                        if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 18) {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                        } else {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                        }
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

                        for(i = 0; i < 27; ++i) {
                            inv.setItem(i, glas);
                        }

                        inv.setItem(11, greenglas);
                        inv.setItem(15, redglas);
                        p.updateInventory();
                    }
                } else {
                    p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lLegende")) {
                e.setCancelled(true);
                if (MySQL.getcoins(uuid) >= 175000.0D) {
                    if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 17) {
                        if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 17) {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                        } else {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                        }
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

                        for(i = 0; i < 27; ++i) {
                            inv.setItem(i, glas);
                        }

                        inv.setItem(11, greenglas);
                        inv.setItem(15, redglas);
                        p.updateInventory();
                    }
                } else {
                    p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
                }
            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§e§lPhoenix")) {
                e.setCancelled(true);
                if (MySQL.getcoins(uuid) >= 200000.0D) {
                    if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) < 16) {
                        if (Integer.valueOf(Rang.getTeamNumber(p.getUniqueId().toString())) == 16) {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu besitzt den Rang bereits!");
                        } else {
                            p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst dir keinen niedriegeren Rang geben!");
                        }
                    } else {
                        inv = Bukkit.createInventory(p, 27, "§7Rang §a§lPhoenix §7kaufen?");
                        p.closeInventory();
                        p.openInventory(inv);
                        glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
                        glasmeta = glas.getItemMeta();
                        glasmeta.setDisplayName("§e§l");
                        glas.setItemMeta(glasmeta);
                        greenglas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
                        greenglasmeta = greenglas.getItemMeta();
                        greenglasmeta.setDisplayName("§aJa");
                        greenglasmeta.setLore(Arrays.asList(" ", "§7Kosten: §200.000$"));
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
                } else {
                    p.sendMessage(SkyPvP.getPrefix() + "§cDu hast für den Rang nicht genug Geld!");
                }
            }
        } else if (e.getInventory().getTitle().equals("§7Rang §6Premium §7kaufen?")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aJa")) {
                p.closeInventory();
                MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 12000.0D);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " premium");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNein")) {
                p.closeInventory();
            }
        } else if (e.getInventory().getTitle().equals("§7Rang §dObsidian §7kaufen?")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aJa")) {
                p.closeInventory();
                MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 25000.0D);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " obsidian");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNein")) {
                p.closeInventory();
            }
        } else if (e.getInventory().getTitle().equals("§7Rang §9Titan §7kaufen?")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aJa")) {
                p.closeInventory();
                MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 40000.0D);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " titan");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNein")) {
                p.closeInventory();
            }
        } else if (e.getInventory().getTitle().equals("§7Rang §5Bedrock §7kaufen?")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aJa")) {
                p.closeInventory();
                MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 75000.0D);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " bedrock");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNein")) {
                p.closeInventory();
            }
        } else if (e.getInventory().getTitle().equals("§7Rang §c§lLegende §7kaufen?")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aJa")) {
                p.closeInventory();
                MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 175000.0D);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " legende");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNein")) {
                p.closeInventory();
            }
        }else if (e.getInventory().getTitle().equals("§7Rang §a§lPhoenix §7kaufen?")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aJa")) {
                p.closeInventory();
                MySQL.setcoins(uuid, MySQL.getcoins(uuid) - 200000.0D);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rang set " + p.getName() + " phoenix");
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cNein")) {
                p.closeInventory();
            }
        }
    }
    
}
