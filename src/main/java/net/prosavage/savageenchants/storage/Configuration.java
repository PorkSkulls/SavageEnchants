package net.prosavage.savageenchants.storage;

import net.prosavage.savageenchants.SavageEnchants;
import net.prosavage.savageenchants.utils.MultiversionMaterials;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public enum Configuration {

   // General Section
   GENERAL_ROMANNNUMERALLEVELS(true),



   // Enchantment Medium Section
   ENCHANTMENTMEDIUM_TYPE(MultiversionMaterials.ENCHANTED_BOOK.parseMaterial().toString()),
   ENCHANTMENTMEDIUM_NAME("{enchantment-name} {level}"),
   ENCHANTMENTMEDIUM_LORE(Arrays.asList("Drag n'' Drop on any {applicable-type}")),

   // Enchantment Item
   ENCHANTMENTITEM_ENCHANTMENTLORELINE("{enchantment-name} {level}");


   public static void getFromFile(SavageEnchants instance) {
      for (Configuration option : Configuration.values()) {
         String path = option.name().replace("_", ".").toLowerCase();
         if (!instance.getConfig().isSet(path)) {
            instance.getConfig().set(path, option.getValue());
         } else {
            option.setValue(instance.getConfig().get(path));
         }
      }
   }


   public static void updateFile(SavageEnchants instance) {
      for (Configuration option : Configuration.values()) {
         String path = option.name().replace("_", ".").toLowerCase();
         // Check if the configuration path is already set.
         if (instance.getConfig().isSet(path)) {
            continue;
         }
         instance.getConfig().set(path, option.getValue());
      }
      try {
         instance.getConfig().save(new File(instance.getDataFolder(), "config.yml"));
      } catch (IOException ex) {
         System.out.println("Something went wrong attempting to save the config.yml file...");
         System.out.println("============== Error Information ==============");
         ex.printStackTrace();
         System.out.println("============== Error Information ==============");
      }
   }

   Object value;

   private void setValue(Object value) {
      this.value = value;
   }

   public Object getValue() {
      return this.value;
   }


   private Configuration(Object value) {
      this.value = value;
   }




}
