package me.b3n3dkt.commands;

import me.b3n3dkt.SkyPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_Enchant implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (p.hasPermission("jailedmc.command.enchant")) {
            if (args.length == 3) {
               Enchantment enchantment = this.getEnchantment(args[0].toUpperCase());
               Integer level = Integer.valueOf(args[1]);
               boolean bool = Boolean.valueOf(args[2]);
               ItemStack stack = new ItemStack(p.getItemInHand());
               p.getInventory().remove(stack);
               ItemMeta meta = stack.getItemMeta();
               meta.addEnchant(enchantment, level, bool);
               stack.setItemMeta(meta);
               p.getInventory().addItem(new ItemStack[]{stack});
               p.sendMessage(SkyPvP.getPrefix() + "§7Du hast das Item verzaubert!");
            } else {
               p.sendMessage(SkyPvP.getPrefix() + "§cBitte nutze /enchant <Enchantment> <Level> <true/false>");
            }
         } else {
            p.sendMessage(SkyPvP.getNoperm());
         }
      }

      return false;
   }

   private Enchantment getEnchantment(String lookup) {
      Enchantment enchantment = Enchantment.getByName(lookup);
      if (enchantment == null) {
         Integer id = Integer.valueOf(lookup);
         if (id != null) {
            enchantment = Enchantment.getById(id);
         }
      }

      return enchantment;
   }
}
