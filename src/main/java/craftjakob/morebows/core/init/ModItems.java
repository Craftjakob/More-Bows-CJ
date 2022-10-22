package craftjakob.morebows.core.init;

import craftjakob.morebows.MoreBows;
import craftjakob.morebows.common.item.BowModItems;
import craftjakob.morebows.core.util.BowTiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> BOWS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreBows.MODID);

	public static final RegistryObject<Item> COPPER_BOW = BOWS.register("copper_bow", () -> new BowModItems(BowTiers.COPPER, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_BOW = BOWS.register("iron_bow", () -> new BowModItems(BowTiers.IRON, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> GOLDEN_BOW = BOWS.register("golden_bow", () -> new BowModItems(BowTiers.GOLDEN, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> EMERALD_BOW = BOWS.register("emerald_bow", () -> new BowModItems(BowTiers.EMERALD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> DIAMOND_BOW = BOWS.register("diamond_bow", () -> new BowModItems(BowTiers.DIAMOND, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> NETHERITE_BOW = BOWS.register("netherite_bow", () -> new BowModItems(BowTiers.NETHERITE, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> GILDED_NETHERITE_BOW = BOWS.register("gilded_netherite_bow", () -> new BowModItems(BowTiers.GILDED_NETHERITE, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

}

