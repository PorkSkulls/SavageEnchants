package net.prosavage.savageenchants.utils;

import org.bukkit.Material;

import java.util.ArrayList;

public enum EnchanteeType {

   HELMET(MultiversionMaterials.CHAINMAIL_HELMET.parseMaterial(),
           MultiversionMaterials.DIAMOND_HELMET.parseMaterial(),
           MultiversionMaterials.GOLDEN_HELMET.parseMaterial(),
           MultiversionMaterials.IRON_HELMET.parseMaterial(),
           MultiversionMaterials.LEATHER_HELMET.parseMaterial()),
   CHESTPLATE(MultiversionMaterials.CHAINMAIL_CHESTPLATE.parseMaterial(),
           MultiversionMaterials.DIAMOND_CHESTPLATE.parseMaterial(),
           MultiversionMaterials.GOLDEN_CHESTPLATE.parseMaterial(),
           MultiversionMaterials.IRON_CHESTPLATE.parseMaterial(),
           MultiversionMaterials.LEATHER_CHESTPLATE.parseMaterial()),
   LEGGINGS(MultiversionMaterials.CHAINMAIL_LEGGINGS.parseMaterial(),
           MultiversionMaterials.DIAMOND_LEGGINGS.parseMaterial(),
           MultiversionMaterials.GOLDEN_LEGGINGS.parseMaterial(),
           MultiversionMaterials.IRON_LEGGINGS.parseMaterial(),
           MultiversionMaterials.LEATHER_LEGGINGS.parseMaterial()),
   BOOTS(MultiversionMaterials.CHAINMAIL_BOOTS.parseMaterial(),
           MultiversionMaterials.DIAMOND_BOOTS.parseMaterial(),
           MultiversionMaterials.GOLDEN_BOOTS.parseMaterial(),
           MultiversionMaterials.IRON_BOOTS.parseMaterial(),
           MultiversionMaterials.LEATHER_BOOTS.parseMaterial()),
   SWORD(MultiversionMaterials.STONE_SWORD.parseMaterial(),
           MultiversionMaterials.DIAMOND_SWORD.parseMaterial(),
           MultiversionMaterials.GOLDEN_SWORD.parseMaterial(),
           MultiversionMaterials.IRON_SWORD.parseMaterial(),
           MultiversionMaterials.WOODEN_SWORD.parseMaterial()),
   AXE(MultiversionMaterials.STONE_AXE.parseMaterial(),
           MultiversionMaterials.DIAMOND_AXE.parseMaterial(),
           MultiversionMaterials.GOLDEN_AXE.parseMaterial(),
           MultiversionMaterials.IRON_AXE.parseMaterial(),
           MultiversionMaterials.WOODEN_AXE.parseMaterial()),
   HOE(MultiversionMaterials.STONE_HOE.parseMaterial(),
           MultiversionMaterials.DIAMOND_HOE.parseMaterial(),
           MultiversionMaterials.GOLDEN_HOE.parseMaterial(),
           MultiversionMaterials.IRON_HOE.parseMaterial(),
           MultiversionMaterials.WOODEN_HOE.parseMaterial()),
   SHOVEL(MultiversionMaterials.STONE_SHOVEL.parseMaterial(),
           MultiversionMaterials.DIAMOND_SHOVEL.parseMaterial(),
           MultiversionMaterials.GOLDEN_SHOVEL.parseMaterial(),
           MultiversionMaterials.IRON_SHOVEL.parseMaterial(),
           MultiversionMaterials.WOODEN_SHOVEL.parseMaterial()),
   PICKAXE(MultiversionMaterials.STONE_PICKAXE.parseMaterial(),
           MultiversionMaterials.DIAMOND_PICKAXE.parseMaterial(),
                   MultiversionMaterials.GOLDEN_PICKAXE.parseMaterial(),
                   MultiversionMaterials.IRON_PICKAXE.parseMaterial(),
                   MultiversionMaterials.WOODEN_PICKAXE.parseMaterial()),
   SHEARS(MultiversionMaterials.SHEARS.parseMaterial());





   private ArrayList<Material> applicableTypes;


   private EnchanteeType(Material... types) {
      for (Material material : types) {
         applicableTypes.add(material);
      }
   }






}
