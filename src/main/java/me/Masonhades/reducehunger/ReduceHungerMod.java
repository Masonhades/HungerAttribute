package me.Masonhades.reducehunger;

import me.Masonhades.reducehunger.attribute.ModAttributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(ReduceHungerMod.MODID)
public class ReduceHungerMod {


    public static final String MODID = "reducehunger";
    public ReduceHungerMod() {

        IEventBus modEnentBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModAttributes.ATTRIBUTES.register(modEnentBus);
        }

}
