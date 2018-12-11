package net.prosavage.savageenchants.utils;
import java.util.List;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemBuilder {

   private final ItemMeta meta;
   private final ItemStack item;

   public ItemBuilder(ItemStack item) {
      this.item = item;
      this.meta = item.getItemMeta();
   }

   public ItemBuilder(Material material, int amount, int durability) {
      this(new ItemStack(material, amount, (short) durability));
   }

   public ItemBuilder(Material material, int amount) {
      this(material, amount, 0);
   }

   public ItemBuilder(Material material) {
      this(material, 1);
   }

   public ItemBuilder lore(String... lore) {
      lore(lore != null ? Lists.newArrayList(lore) : null);
      return this;
   }

   public ItemBuilder lore(List<String> lore) {
      meta.setLore(Util.color(lore));
      return this;
   }

   public ItemBuilder name(String name) {
      meta.setDisplayName(Util.color(name));
      return this;
   }

   public ItemStack build() {
      item.setItemMeta(meta);
      return item;
   }

   public ItemBuilder addLineToLore(String line) {
      List<String> lore = meta.getLore();
      lore.add(Util.color(line));
      meta.setLore(lore);
      return this;
   }


}