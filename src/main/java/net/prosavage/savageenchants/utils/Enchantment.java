package net.prosavage.savageenchants.utils;

public enum Enchantment {

   // Sword Enchants
   POSION("&2Posion", "&2Applies poison effects to the victim with increasing potency depending on level for 3 seconds.", 3, TargetType.ENTITY, EnchanteeType.SWORD),


   // Armor Enchants
   REINFORCED("&dReinforced", "&dNegate damage depending on level.", 3, TargetType.SELF, EnchanteeType.HELMET, EnchanteeType.CHESTPLATE, EnchanteeType.LEGGINGS, EnchanteeType.BOOTS),


   // Tool Enchants
   MOLTEN("&eMOLTEN", "&eAutomatically smelts blocks that are broken", 3, TargetType.BLOCK, EnchanteeType.PICKAXE);




   private String formattedName;
   private int maxLevel;


   private Enchantment(String formattedName, String description, int maxLevel, TargetType targetType, EnchanteeType... enchanteeType) {
      this.formattedName = formattedName;
      this.maxLevel = maxLevel;
   };

   public String getFormattedName() {
      return formattedName;
   }


   public static Enchantment getEnchantment(String enchantmentToFind) {
      for (Enchantment enchant : Enchantment.values()) {
         if (enchantmentToFind.equalsIgnoreCase(enchant.name())) {
            return enchant;
         }
      }
      return null;
   }

}
