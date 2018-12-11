package net.prosavage.savageenchants.utils;

import net.prosavage.savageenchants.EnchantmentMedium;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Util {

   public static String color(String message) {
      return ChatColor.translateAlternateColorCodes('&', message);
   }


   public static List<String> color(List<String> messages) {
      List<String> list = new ArrayList<>();
      for (String line : messages) {
         list.add(color(line));
      }
      return list;
   }


   public static List<String> replaceInStringList(String toReplace, String replaceWith, List<String> messages) {
      List<String> list = new ArrayList<>();
      for (String line : messages) {
         list.add(line.replace(toReplace, replaceWith));
      }
      return list;
   }

   public static String applyPlaceholders(String applyPlaceholdersTo, EnchantmentMedium enchantmentMedium) {
      return applyPlaceholdersTo.replace("{applicable-type}", enchantmentMedium.getApplicableType().formattedName())
              .replace("{level}", RomanNumber.toRoman(enchantmentMedium.getLevel()))
              .replace("{enchantment-name}", enchantmentMedium.getEnchantment().getFormattedName());
   }


   public static List<String> applyPlaceholders(List<String> applyPlaceholdersTo, EnchantmentMedium enchantmentMedium) {
      List<String> forReturn = new ArrayList<>();
      for (String line : applyPlaceholdersTo) {
         forReturn.add(applyPlaceholders(line, enchantmentMedium));
      }
      return forReturn;
   }










}
