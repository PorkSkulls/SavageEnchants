package net.prosavage.savageenchants.storage;

import net.prosavage.savageenchants.SavageEnchants;
import net.prosavage.savageenchants.utils.Util;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static net.prosavage.savageenchants.SavageEnchants.instance;

public enum Lang {

   GENERAL_PREFIX("&7(&c!&7) "),
   GENERAL_ITEMENCHANTED("&cYou have enchanted an item!");







   private String message;
   private static FileConfiguration langConfiguration;




   private Lang(String message) {
      this.message = message;
   }


   public static void getFromFile(SavageEnchants instance) {
      File langFile = new File(instance.getDataFolder().getPath(), "lang.yml");
      saveResourceIfDoesNotExist(instance);
      langConfiguration = YamlConfiguration.loadConfiguration(langFile);
      for (Lang message : Lang.values()) {
         String path = message.name().replace("_", ".").toLowerCase();
         if (langConfiguration.isSet(path)) {
            message.setValue(langConfiguration.getString(path));
         }
      }

   }

   public static void updateFile(SavageEnchants instance) {
      File langFile = new File(instance.getDataFolder().getPath(), "lang.yml");
      saveResourceIfDoesNotExist(instance);
      langConfiguration = YamlConfiguration.loadConfiguration(langFile);
      for (Lang message : Lang.values()) {
         String path = message.name().replace("_", ".").toLowerCase();
         // Check if the configuration path is already set, if so skip it.
         if (langConfiguration.isSet(path)) {
            continue;
         }
         langConfiguration.set(path, message.getValueRaw());
         try {
            langConfiguration.save(langFile);
         } catch (IOException ex) {
            System.out.println("Something went wrong attempting to save the lang.yml file...");
            System.out.println("============== Error Information ==============");
            ex.printStackTrace();
            System.out.println("============== Error Information ==============");
         }
      }
   }



   public static void saveToFile(SavageEnchants instance) {
      File langFile = new File(instance.getDataFolder().getPath(), "lang.yml");
      if (!langFile.exists()) {
         instance.saveResource("lang.yml", false);
      }
      langConfiguration = YamlConfiguration.loadConfiguration(langFile);
      for (Lang message : Lang.values()) {
         String path = message.name().replace(".", "_").toLowerCase();
         if (!langConfiguration.isSet(path)) {
            langConfiguration.set(path, message);
         }
      }
      try {
         langConfiguration.save(langFile);
      } catch (IOException ex) {
         System.out.println("Something went wrong attempting to save the lang.yml file...");
         System.out.println("============== Error Information ==============");
         ex.printStackTrace();
         System.out.println("============== Error Information ==============");
      }

   }

   private static void saveResourceIfDoesNotExist(SavageEnchants instance) {
      if (!new File(instance.getDataFolder(), "lang.yml").exists()) {
         instance.saveResource("lang.yml", false);
      }
   }


   private void setValue(String message) {
      this.message = message;
   }


   public String getValueRaw() {
      return this.message;
   }

   public String getValueFormatted() {
      return Util.color(Lang.GENERAL_PREFIX + "" + this.message);
   }

   public String getValue() {
      return Util.color(this.message);
   }



}
