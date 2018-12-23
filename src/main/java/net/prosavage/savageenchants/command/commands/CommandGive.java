package net.prosavage.savageenchants.command.commands;

import net.prosavage.savageenchants.SavageEnchants;
import net.prosavage.savageenchants.command.AbstractCommand;
import net.prosavage.savageenchants.storage.Lang;
import net.prosavage.savageenchants.utils.Enchantment;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class CommandGive extends AbstractCommand {

   public CommandGive(AbstractCommand parent) {
      super("give", parent, false);
   }

   @Override
   protected ReturnType runCommand(SavageEnchants instance, CommandSender sender, String... args) {
      if (args.length < 5) {
         return ReturnType.SYNTAX_ERROR;
      }
      if (Bukkit.getPlayerExact(args[1]) == null) {
         sender.sendMessage(Lang.GENERAL_PLAYERDOESNOTEXIST.getValueFormatted());
         return ReturnType.FAILURE;
      }

      String enchantment = args[2];
      if (Enchantment.getEnchantment(enchantment) == null) {

         return ReturnType.FAILURE;
      }


      return ReturnType.SUCCESS;
   }

   @Override
   public String getPermissionNode() {
      return "savageenchantments.give";
   }

   @Override
   public String getSyntax() {
      return "/se give [player] [enchantment] [level]";
   }

   @Override
   public String getDescription() {
      return "Give an enchantment medium item to a player.";
   }


}
