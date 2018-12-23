package net.prosavage.savageenchants.effects;

import net.prosavage.savageenchants.utils.Enchantment;
import net.prosavage.savageenchants.utils.TargetType;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public abstract class Effect {


   protected TargetType targetType;
   protected Player user;
   protected Entity targetEntity;
   protected Block targetBlock;
   protected Enchantment enchantment;

   public Effect(TargetType targetType, Player user, Entity targetEntity, Block targetBlock, Enchantment enchantment) {
      this.targetType = targetType;
      this.user = user;
      this.targetEntity = targetEntity;
      this.targetBlock = targetBlock;
      this.enchantment = enchantment;

   }


   public void runEffect() {

   }


   public TargetType getTargetType() {
      return this.targetType;
   }


}
