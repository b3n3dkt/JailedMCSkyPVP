package me.b3n3dkt.listener;

import me.b3n3dkt.SkyPvP;
import me.b3n3dkt.utils.Pack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract_Packs implements Listener {
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
         Pack pack;
         if (name.equals("§6Kit Pack")) {
            if (f < 35) {
               if (amount == 1) {
                  pack = new Pack("Kits");
                  p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Kit Pack geöffnet!");
                  pack.getRandomItem(p);
               } else {
                  p.getItemInHand().setAmount(amount - 1);
                  pack = new Pack("Kits");
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Kit Pack geöffnet!");
                  pack.getRandomItem(p);
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst kein Pack öffnen, wenn dein Inventar voll ist!");
            }
         } else if (name.equals("§6Rang Pack")) {
            if (f < 35) {
               if (amount == 1) {
                  pack = new Pack("Rang");
                  p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Rang Pack geöffnet!");
                  pack.getRandomItem(p);
               } else {
                  p.getItemInHand().setAmount(amount - 1);
                  pack = new Pack("Rang");
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Rang Pack geöffnet!");
                  pack.getRandomItem(p);
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst kein Pack öffnen, wenn dein Inventar voll ist!");
            }
         } else if (name.equals("§6Waffen Pack")) {
            if (f < 35) {
               if (amount == 1) {
                  pack = new Pack("Waffen");
                  p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Waffen Pack geöffnet!");
                  pack.getRandomItem(p);
               } else {
                  p.getItemInHand().setAmount(amount - 1);
                  pack = new Pack("Waffen");
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Waffen Pack geöffnet!");
                  pack.getRandomItem(p);
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst kein Pack öffnen, wenn dein Inventar voll ist!");
            }
         } else if (name.equals("§6Rüstung Pack")) {
            if (f < 35) {
               if (amount == 1) {
                  pack = new Pack("Rüstung");
                  p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Rüstung Pack geöffnet!");
                  pack.getRandomItem(p);
               } else {
                  p.getItemInHand().setAmount(amount - 1);
                  pack = new Pack("Rüstung");
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Rüstung Pack geöffnet!");
                  pack.getRandomItem(p);
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst kein Pack öffnen, wenn dein Inventar voll ist!");
            }
         } else {
            if (!name.equals("§6Alles Oder Nichts Pack")) {
               return;
            }

            if (f < 35) {
               if (amount == 1) {
                  pack = new Pack("AllesOderNichts");
                  p.getInventory().removeItem(new ItemStack[]{p.getItemInHand()});
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Alles Oder Nichts Pack geöffnet!");
                  pack.getRandomItem(p);
               } else {
                  p.getItemInHand().setAmount(amount - 1);
                  pack = new Pack("AllesOderNichts");
                  p.sendMessage(SkyPvP.getPrefix() + "§aDu hast ein Alles Oder Nichts Pack geöffnet!");
                  pack.getRandomItem(p);
               }
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cDu kannst kein Pack öffnen, wenn dein Inventar voll ist!");
            }
         }
      }

   }
}
