package net.prosavage.savageenchants;

import net.prosavage.savageenchants.command.CommandManager;
import net.prosavage.savageenchants.listeners.ApplyEnchant;
import net.prosavage.savageenchants.storage.Configuration;
import net.prosavage.savageenchants.storage.Lang;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SavageEnchants extends JavaPlugin {

   public static SavageEnchants instance;
   public static Logger logger;
   private Listener[] eventListeners;
   private CommandManager commandManager;

   @Override
   public void onEnable() {
      logger = this.getLogger();
      logger.info("SavageEnchantments // Version: " + this.getDescription().getVersion());
      logger.info("Made by ProSavage, with <3");
      logger.info("Managing Configuration Files...");
      logger.info("Attempting to save packaged Configuration Files...");
      saveResource("lang.yml", false);
      saveResource("config.yml", false);
      logger.info("Checking for missing options...");
      Configuration.updateFile(this);
      Lang.updateFile(this);
      logger.info("Loading Configurations into memory...");
      Configuration.getFromFile(this);
      Lang.getFromFile(this);
      logger.info("Registering Listeners...");
      eventListeners = new Listener[] {
              new ApplyEnchant(this)
      };
      logger.info("Registering Commands...");
      this.commandManager = new CommandManager(this);









      logger.info("All Done, Enjoy <3");

      instance = this;
   }

   @Override
   public void onDisable() {

   }


   public CommandManager getCommandManager() {
      return this.commandManager;
   }






}
