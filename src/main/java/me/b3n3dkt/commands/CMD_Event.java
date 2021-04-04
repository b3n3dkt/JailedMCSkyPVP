package me.b3n3dkt.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import me.b3n3dkt.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CMD_Event implements CommandExecutor {
   public static boolean event = false;
   public static String name = "";
   public static ArrayList<Player> eventPlayers = new ArrayList();

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player) sender;
         if (!p.hasPermission("jailedmc.command.event")) {
            p.sendMessage(SkyPvP.getNoperm());
            }else{
            if(args.length < 1 && args.length != 1){
               p.sendMessage(SkyPvP.getPrefix() + "§cNutze bitte /event <Event>!");
            }else{
               if(p.getItemInHand() == null || p.getItemInHand() == new ItemStack(Material.AIR)){
                  p.sendMessage(SkyPvP.getPrefix() + "§cDu musst ein Item in der Hand haben!");
                  return true;
               }
                  for(Player all : Bukkit.getOnlinePlayers()){
                     for(int i = 0;i<200;i++){
                        if(!all.hasPermission("jailedmc.command.chatclear.bypass")){
                           all.sendMessage(" ");
                        }
                        if(!all.hasPermission("jailedmc.command.event.bypass")){
                           eventPlayers.add(all);
                        }
                  }
               }
               for(int i = 0; i < args.length; i++){
                  name += " " + args[i];
               }
                  final ItemStack stack = p.getItemInHand();
                  event = true;

                  for(Player all : Bukkit.getOnlinePlayers()){
                     all.sendMessage("§8§l┌─────[§r§6Event§8§l]─────┐");
                     all.sendMessage("§8§l│");
                     all.sendMessage("§8§l╞§r§6Es wurde ein Event Gestartet!");
                     all.sendMessage("§8§l│");
                     all.sendMessage("§8§l╞§r§6Es wird verlost: §e§l" + name);
                     all.sendMessage("§8§l│");
                     all.sendMessage("§8§l└─────[§r§6Event§8§l]─────┘");
                     all.sendTitle("§6Verlosung!", "§e§l" + name);
                     all.playSound(all.getLocation(), Sound.FIREWORK_BLAST, 5.0F, 5.0F);
                  }
                  Bukkit.getScheduler().runTaskLater(SkyPvP.getMain(), new Runnable() {
                     @Override
                     public void run() {
                        int randomNum = ThreadLocalRandom.current().nextInt(0, eventPlayers.size() + 1);
                        Player gewinner = eventPlayers.get(randomNum);
                        for(Player all : Bukkit.getOnlinePlayers()){
                           all.sendMessage(SkyPvP.getPrefix() + "§3" + gewinner.getName() + " hat §8'§7" + name + "§8' §3gewonnen!");
                           all.playSound(all.getLocation(), Sound.ANVIL_LAND, 5.0F, 5.0F);
                        }
                        gewinner.sendMessage(SkyPvP.getPrefix() + "§3Du hast §8'§7" + name + "§8' §3gewonnen!");
                        gewinner.getInventory().addItem(stack);
                        event = false;
                        name = "";
                     }
                  }, 20*15);
            }
         }

         }
      return false;
   }
}
