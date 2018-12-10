package net.prosavage.savageenchants.utils;

import org.bukkit.ChatColor;

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



}
