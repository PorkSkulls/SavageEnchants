package net.prosavage.savageenchants.listeners;

import net.prosavage.savageenchants.EnchantmentMedium;
import net.prosavage.savageenchants.SavageEnchants;
import net.prosavage.savageenchants.utils.ItemBuilder;
import net.prosavage.savageenchants.utils.MultiversionMaterials;
import net.prosavage.savageenchants.utils.nbt.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ApplyEnchant implements Listener {


   private SavageEnchants instance;

   public ApplyEnchant(SavageEnchants instance) {
      this.instance = instance;
   }


   @EventHandler
   public void onEnchantApply(InventoryClickEvent event) {
      if (!(event.getWhoClicked() instanceof Player)
              || event.getClickedInventory() == null
              || event.getCurrentItem() == null
              || event.getCursor() == null
              || event.getCurrentItem().getType() == MultiversionMaterials.AIR.parseMaterial()
              || event.getCursor().getType() == MultiversionMaterials.AIR.parseMaterial()
              || EnchantmentMedium.isEnchantmentMediumitem(event.getCursor())) {
         return;
      }
      // Okay so, if we have reached this part, then we know that we have an enchantment book.
      // So lets go ahead and grab the basic needs for applying an enchantment item.
      EnchantmentMedium enchantmentMedium = EnchantmentMedium.fromItem(event.getCursor());
      ItemStack enchantmentReciepient = event.getCurrentItem();
      if (!enchantmentMedium.getApplicableType().isApplicable(enchantmentReciepient)) {
         return;
      }

      // Okay so now we can just work on adding the enchantment to the item.
      NBTItem nbtItem = new NBTItem(event.getCurrentItem());
      nbtItem.setBoolean("CE", true);
      nbtItem.setInteger(enchantmentMedium.getEnchantment().name(), enchantmentMedium.getLevel());
      ItemStack newAppliedItem = nbtItem.getItem();
      ItemBuilder itemBuilder = new ItemBuilder(newAppliedItem);
      itemBuilder.addLineToLore(instance.getConfig().getString("enchantment-item.enchantment-line"));
      event.setCurrentItem(itemBuilder.build());
   }














}
