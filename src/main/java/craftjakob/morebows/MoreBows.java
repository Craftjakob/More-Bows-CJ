package craftjakob.morebows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import craftjakob.morebows.core.init.ModItems;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreBows.MODID)
public class MoreBows {
	public static final String MODID = "morebows";
    private static final Logger LOGGER = LogManager.getLogger();
    
    public MoreBows() { 
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.BOWS.register(eventBus);
        
        eventBus.addListener(this::setup);
    }
    private void setup(final FMLClientSetupEvent event) {  	
    	
        LOGGER.info("More Bows is detected!");
        
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
}
