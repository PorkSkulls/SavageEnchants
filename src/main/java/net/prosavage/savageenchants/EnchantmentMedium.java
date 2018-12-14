package net.prosavage.savageenchants;


import net.prosavage.savageenchants.utils.EnchanteeType;
import net.prosavage.savageenchants.utils.Enchantment;
import net.prosavage.savageenchants.utils.Util;
import net.prosavage.savageenchants.utils.nbt.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class EnchantmentMedium {

   private Enchantment enchantment;
   private int level;
   private EnchanteeType applicableType;



   public EnchantmentMedium(Enchantment enchantment, int level, EnchanteeType applicableType) {
      this.setEnchantment(enchantment);
      this.setLevel(level);
      this.setApplicableType(applicableType);
   }


   public static boolean isEnchantmentMediumitem(ItemStack itemStack) {
      return new NBTItem(itemStack).hasKey("CE");
   }

   public static EnchantmentMedium fromItem(ItemStack itemStack) {
      if (!isEnchantmentMediumitem(itemStack)) {
         return null;
      }
      NBTItem nbtItem = new NBTItem(itemStack);
      return new EnchantmentMedium(Enchantment.valueOf(nbtItem.getString("enchant")), nbtItem.getInteger("level"), EnchanteeType.valueOf(nbtItem.getString("applicableTypes")));
   }





   public ItemStack createItem() {
      ItemStack itemStack = new ItemStack(Material.matchMaterial(SavageEnchants.instance.getConfig().getString("enchantmentmedium.type", "ENCHANTED_BOOK")));
      ItemMeta itemMeta = itemStack.getItemMeta();
      List<String> lore = SavageEnchants.instance.getConfig().getStringList("enchantmentmedium.lore");
      lore = Util.applyPlaceholders(lore, this);
      itemMeta.setLore(Util.color(lore));
      itemMeta.setDisplayName(Util.color(Util.applyPlaceholders(SavageEnchants.instance.getConfig().getString("enchantmentmedium.name"), this)));
      itemStack.setItemMeta(itemMeta);
      NBTItem nbtItem = new NBTItem(itemStack);
      nbtItem.setBoolean("CE", true);
      nbtItem.setString("applicableTypes", applicableType.name());
      nbtItem.setInteger("level", level);
      nbtItem.setString("enchant", enchantment.name());
      return itemStack;
   }


   public Enchantment getEnchantment() {
      return enchantment;
   }

   public void setEnchantment(Enchantment enchantment) {
      this.enchantment = enchantment;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public EnchanteeType getApplicableType() {
      return applicableType;
   }

   public void setApplicableType(EnchanteeType applicableType) {
      this.applicableType = applicableType;
   }
}
