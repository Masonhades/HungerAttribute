package me.Masonhades.hungerattribute.commands;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import me.Masonhades.hungerattribute.HungerAttributeMod;
import me.Masonhades.hungerattribute.attribute.ModAttributes;
import me.Masonhades.hungerattribute.event.HungerDataHandler;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HungerAttributeMod.MODID)
public class HungerCommand {

    @SubscribeEvent
    public static void register(RegisterCommandsEvent event){
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal("hunger")
                .then(Commands.literal("set")
                        .then(Commands.argument("target", EntityArgument.player())
                                .then(Commands.argument("value", DoubleArgumentType.doubleArg(0.01, 100.0))
                                        .executes(ctx -> {
            Player player = ctx.getSource().getPlayerOrException();
            double val = DoubleArgumentType.getDouble(ctx, "value");
            player.getAttribute(ModAttributes.HUNGER_MULTIPLIER.get()).setBaseValue(val);
            HungerDataHandler.save(player, val);
            ctx.getSource().sendSuccess(() -> Component.translatable("commands.hungerattribute.set", val), true);
            return 1;
        })))));
    }
}
