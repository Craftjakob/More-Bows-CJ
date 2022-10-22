package craftjakob.morebows.common.item;

import java.util.List;

import craftjakob.morebows.core.util.BowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class BowModItems extends BowItem {
	private final BowTier tier;

	public BowModItems(BowTier tier, Properties properties) {
		super(properties.durability(tier.getUses()));
		this.tier = tier;
	}
	@Override
	public AbstractArrow customArrow(AbstractArrow arrow) {
		arrow.setBaseDamage(arrow.getBaseDamage() + this.tier.getAttackDamageBonus());
		return arrow;
	}
	@Override
	public int getEnchantmentValue() {
		return this.tier.getEnchantmentValue();
	}
	@Override
	public boolean isValidRepairItem(ItemStack ItemStack, ItemStack ItemStack1) {
		return this.tier.getRepairIngredient().test(ItemStack1);
	}
	@Override
	public void appendHoverText(ItemStack ItemStack, Level Level, List<Component> List, TooltipFlag TooltipFlag) {
		List.add(Component.literal("+" + Float.toString(this.tier.getAttackDamageBonus()) + " ")
			.append(Component.translatable("item.morebows.damage_tooltip"))
			.withStyle(ChatFormatting.GREEN));
		super.appendHoverText(ItemStack, Level, List, TooltipFlag);
	}
}
