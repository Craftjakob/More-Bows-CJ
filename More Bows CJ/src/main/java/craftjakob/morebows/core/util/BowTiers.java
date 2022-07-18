package craftjakob.morebows.core.util;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum BowTiers implements BowTier {

	   COPPER(484, 0.5f, 1, () -> {
	      return Ingredient.of(Items.COPPER_INGOT);
	   }),
	   IRON(634, 1.0f, 1, () -> {
		      return Ingredient.of(Items.IRON_INGOT);
		   }),
	   GOLDEN(666, 1.5f, 5, () -> {
		      return Ingredient.of(Items.GOLD_INGOT);
		   }),
	   EMERALD(1222, 2.0f, 3, () -> {
		      return Ingredient.of(Items.EMERALD);
		   }),
	   DIAMOND(1945, 3.0f, 3, () -> {
	      return Ingredient.of(Items.DIAMOND);
	   }),
	   NETHERITE(2415, 4.0f, 4, () -> {
	      return Ingredient.of(Items.NETHERITE_INGOT);
	   });

	   private final int uses;
	   private final float damage;
	   private final int enchantmentValue;
	   private final LazyLoadedValue<Ingredient> repairIngredient;

	   private BowTiers(int uses, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
	      this.uses = uses;
	      this.damage = damage;
	      this.enchantmentValue = enchantmentValue;
	      this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	   }

	   public int getUses() {
	      return this.uses;
	   }

	   public float getAttackDamageBonus() {
	      return this.damage;
	   }

	   public int getEnchantmentValue() {
	      return this.enchantmentValue;
	   }

	   public Ingredient getRepairIngredient() {
	      return this.repairIngredient.get();
	   }
}