package craftjakob.morebows;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import craftjakob.morebows.common.item.BowItems;
import craftjakob.morebows.core.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod("morebows")
public class MoreBows
{
	public static final String MODID = "morebows";
	private static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
	private static final IEventBus EVENT_BUS = MinecraftForge.EVENT_BUS;

    public MoreBows()
    {
    	MOD_EVENT_BUS.addListener(this::setup);
        ModItems.BOWS.register(MOD_EVENT_BUS);
        
        EVENT_BUS.register(this);
    }
    
    private void setup(final FMLClientSetupEvent event)
    {
    	
        event.enqueueWork(() -> {
    	ModItems.BOWS.getEntries().forEach(item -> {
    		ItemProperties.register(item.get(), new ResourceLocation("pull"), (ItemStack, ClientLevel, LivingEntity, p_174638_) -> {
                if (LivingEntity == null) {
                    return 0.0F;
                 } else {
                    return LivingEntity.getUseItem() != ItemStack ? 0.0F : (float)(ItemStack.getUseDuration() - LivingEntity.getUseItemRemainingTicks()) / 20.0F;
                 }
              });
            ItemProperties.register(item.get(), new ResourceLocation("pulling"), (ItemStack, ClientLevel, LivingEntity, p_174633_) -> {
                return LivingEntity != null && LivingEntity.isUsingItem() && LivingEntity.getUseItem() == ItemStack ? 1.0F : 0.0F;
             });
    	});
      });
    }
    
    @SubscribeEvent
    public void onFOVUpdate(ComputeFovModifierEvent event)
    {
    	LivingEntity player = event.getPlayer();
    	Item item = player.getUseItem().getItem();
        if(item instanceof BowItems) {
        	float FOVModifier = player.getTicksUsingItem() / (float)BowItems.MAX_DRAW_DURATION;
        	if (FOVModifier > 1.0f) {
        		FOVModifier = 1.0f;
        	}
        	else {
        		FOVModifier *= FOVModifier;
        	}
        	event.setNewFovModifier(event.getNewFovModifier() * (1.0f - FOVModifier * 0.15f));
        }
    }
}