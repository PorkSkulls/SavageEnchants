package net.prosavage.savageenchants;


import net.prosavage.savageenchants.utils.Enchantment;
import net.prosavage.savageenchants.utils.MultiversionMaterials;
import net.prosavage.savageenchants.utils.Util;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EnchantmentMedium {

   Enchantment enchantment;
   int level;



   public EnchantmentMedium(Enchantment enchantment, int level) {
      this.enchantment = enchantment;
      this.level = level;
   }



   public ItemStack createItem() {
      ItemStack itemStack = new ItemStack(Material.matchMaterial(SavageEnchants.instance.getConfig().getString("enchantment-medium.type", "ENCHANTED_BOOK")));
      ItemMeta itemMeta = itemStack.getItemMeta();
      itemMeta.setLore(Util.color(SavageEnchants.instance.getConfig().getStringList("enchantment-medium.lore")));
      itemMeta.setDisplayName(Util.color(SavageEnchants.instance.getConfig().getString("enchantment-medium.name")));
      itemStack.setItemMeta(itemMeta);
      return itemStack;
   }








}
