package me.b3n3dkt.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Pack {
   private FileBuilder f;
   private String name;

   public Pack(String name) {
      this.f = new FileBuilder("plugins//SkyPvP//Packs", name + ".yml");
      this.name = name;
   }

   public boolean packExists() {
      return this.f.exist();
   }

   public static List<Pack> getPacks() {
      List<Pack> temp = new ArrayList();
      File dir = new File("plugins//SkyPvP//Packs");
      File[] var5;
      int var4 = (var5 = dir.listFiles()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         File f = var5[var3];
         if (f.isFile()) {
            temp.add(new Pack(f.getName().replace(".yml", "")));
         }
      }

      return temp;
   }

   public List<String> getLore() {
      return this.f.getStringList("lore");
   }

   public Pack setDisplayMateiral(Material m) {
      this.f.setValue("material", m.toString());
      this.f.save();
      return this;
   }

   public Material getDisplayMaterial() {
      return Material.valueOf(this.f.getString("material"));
   }

   public String getName() {
      return this.name;
   }

   public Pack setItems(Inventory inv) {
      this.f.setValue("items", inv.getContents());
      this.f.save();
      return this;
   }

   public List<ItemStack> getItems() {
      List<ItemStack> temp = new ArrayList();
      ItemStack[] contents = (ItemStack[])((List)this.f.getObject("items")).toArray(new ItemStack[0]);

      for(int i = 0; i < contents.length; ++i) {
         if (contents[i] != null) {
            temp.add(contents[i]);
         }
      }

      return temp;
   }

   public void getRandomItem(Player p) {
      try {
         List<ItemStack> temp = this.getItems();
         Collections.shuffle(temp);
         int min = 1;
         int max = this.getItems().size();
         int random = (int)(Math.random() * (double)(max - min + 1) + (double)min);
         ItemStack randomitem = new ItemStack((ItemStack)temp.get(random));
         if(randomitem == null || randomitem == new ItemStack(Material.AIR)){
            getRandomItem(p);
         }else{
            p.getInventory().addItem(new ItemStack[]{randomitem});
         }
      } catch (Exception var7) {
      }

   }

   public Pack create() {
      this.f.setValue("material", Material.BOOK.toString());
      this.f.setValue("lore", Arrays.asList("§7Rechtsklick zum öffnen"));
      this.f.save();
      return this;
   }

   public Pack delete() {
      this.f.delete();
      return this;
   }
}
