package com.Syuu.HiiragiMod.regi;

import com.Syuu.HiiragiMod.item.ItemHiiragiIngod;
import com.Syuu.HiiragiMod.item.tool.ToolHiiragiPickaxe;
import com.Syuu.HiiragiMod.item.tool.ToolHiiragiSword;
import com.Syuu.HiiragiMod.main.HiiragiMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(HiiragiMod.MOD_ID)
public class HiiragiModItems {

    public static final ItemHiiragiIngod HIIRAGI_INGOD = new ItemHiiragiIngod();
    public static final ToolHiiragiPickaxe HIIRAGI_PICKAXE = new ToolHiiragiPickaxe();
    public static final ToolHiiragiSword HIIRAGI_SWORD = new ToolHiiragiSword();

    @Mod.EventBusSubscriber(modid = HiiragiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register{

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){

            final Item[] items = {
                    HIIRAGI_INGOD,
                    HIIRAGI_PICKAXE,
                    HIIRAGI_SWORD
            };
            event.getRegistry().registerAll(items);
        }
    }
}
