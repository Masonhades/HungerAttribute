package me.Masonhades.reducehunger;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(ForgeRegistries.ATTRIBUTES, ReduceHungerMod.MODID);

    public static final RegistryObject<Attribute> HUNGER_MULTIPLIER =
            ATTRIBUTES.register("hunger_multiplier", () ->
                    new RangedAttribute("attribute.name.reducehunger.hunger_multiplier", 1.0, 0.01, 100.0)
                            .setSyncable(true)
            );
}
