package net.prosavage.savageenchants.command;

import net.prosavage.savageenchants.SavageEnchants;
import net.prosavage.savageenchants.command.commands.CommandSavageEnchantments;
import net.prosavage.savageenchants.storage.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandManager implements CommandExecutor {

   private SavageEnchants instance;

   private List<AbstractCommand> commands = new ArrayList<>();

   public CommandManager(SavageEnchants instance) {
      this.instance = instance;

      instance.getCommand("savageenchants").setExecutor(this);

      AbstractCommand commandEpicHoppers = addCommand(new CommandSavageEnchantments());


   }

   private AbstractCommand addCommand(AbstractCommand abstractCommand) {
      commands.add(abstractCommand);
      return abstractCommand;
   }

   @Override
   public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
      for (AbstractCommand abstractCommand : commands) {
         if (abstractCommand.getCommand().equalsIgnoreCase(command.getName())) {
            if (strings.length == 0) {
               processRequirements(abstractCommand, commandSender, strings);
               return true;
            }
         } else if (strings.length != 0 && abstractCommand.getParent() != null && abstractCommand.getParent().getCommand().equalsIgnoreCase(command.getName())) {
            String cmd = strings[0];
            if (cmd.equalsIgnoreCase(abstractCommand.getCommand())) {
               processRequirements(abstractCommand, commandSender, strings);
               return true;
            }
         }
      }
      commandSender.sendMessage(Lang.GENERAL_COMMANDINVALID.getValueFormatted());
      return true;
   }

   private void processRequirements(AbstractCommand command, CommandSender sender, String[] strings) {
      if (!(sender instanceof Player) && command.isNoConsole()) {
         sender.sendMessage("You must be a player to use this command.");
         return;
      }
      if (command.getPermissionNode() == null || sender.hasPermission(command.getPermissionNode())) {
         AbstractCommand.ReturnType returnType = command.runCommand(instance, sender, strings);
         if (returnType == AbstractCommand.ReturnType.SYNTAX_ERROR) {

            sender.sendMessage(Lang.GENERAL_INVALIDSYNTAX.getValueFormatted().replace("{valid-syntax}", command.getSyntax()));
         }
         return;
      }
      sender.sendMessage(Lang.GENERAL_NOPERMISSIONS.getValueFormatted());
   }

   public List<AbstractCommand> getCommands() {
      return Collections.unmodifiableList(commands);
   }
}
