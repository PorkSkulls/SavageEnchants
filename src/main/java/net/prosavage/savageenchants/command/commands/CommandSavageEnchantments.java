package net.prosavage.savageenchants.command.commands;

import net.prosavage.savageenchants.SavageEnchants;
import net.prosavage.savageenchants.command.AbstractCommand;
import net.prosavage.savageenchants.storage.Lang;
import net.prosavage.savageenchants.utils.Util;
import org.bukkit.command.CommandSender;

public class CommandSavageEnchantments extends AbstractCommand {

   public CommandSavageEnchantments() {
      super("SavageEnchantments", null, false);
   }


   @Override
   protected ReturnType runCommand(SavageEnchants instance, CommandSender sender, String... args) {
      sender.sendMessage("");
      sender.sendMessage(Util.color("&cSavageEnchantments By ProSavage"));

      for (AbstractCommand command : instance.getCommandManager().getCommands()) {
         if (command.getPermissionNode() == null || sender.hasPermission(command.getPermissionNode())) {
            sender.sendMessage(Lang.GENERAL_COMMANDFORMAT.getValueFormatted().replace("{valid-syntax}", command.getSyntax()).replace("{command-description}", command.getDescription()));
         }
      }
      sender.sendMessage("");

      return ReturnType.SUCCESS;

   }

   @Override
   public String getPermissionNode() {
      return null;
   }

   @Override
   public String getSyntax() {
      return "/SavageEnchantments";
   }

   @Override
   public String getDescription() {
      return "Displays this page.";
   }


}
