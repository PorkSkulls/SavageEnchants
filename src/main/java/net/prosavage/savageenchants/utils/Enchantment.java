package net.prosavage.savageenchants.utils;

public enum Enchantment {

   // Sword Enchants
   POSION("&2Posion", "&2Applies poison effect to the victim with increasing potency depending on level for 3 seconds.", 3, EnchanteeType.SWORD),


   // Armor Enchants
   REINFORCED("&dReinforced", "&dNegate damage depending on level.", 3, EnchanteeType.HELMET, EnchanteeType.CHESTPLATE, EnchanteeType.LEGGINGS, EnchanteeType.BOOTS),


   // Tool Enchants
   MOLTEN("&eMOLTEN", "&eAutomatically smelts blocks that are broken", 3, EnchanteeType.PICKAXE);




   private String formattedName;
   private int maxLevel;



   private Enchantment(String formattedName, String description, int maxLevel, EnchanteeType... enchanteeType) {
      this.formattedName = formattedName;
      this.maxLevel = maxLevel;
   };



}
