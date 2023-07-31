package com.Syuu.HiiragiMod.regi;

import com.Syuu.HiiragiMod.block.BlockHiiragiBlock;
import com.Syuu.HiiragiMod.block.BlockHiiragiGlass;
import com.Syuu.HiiragiMod.main.HiiragiMod;
import com.Syuu.HiiragiMod.main.HiiragiModTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.lwjgl.system.CallbackI;

@ObjectHolder(HiiragiMod.MOD_ID)
public class HiiragiModBlocks {

    public static final BlockHiiragiBlock HIIRAGI_BLOCK =new BlockHiiragiBlock();
    public static final BlockHiiragiGlass HIIRAGI_GLASS = new BlockHiiragiGlass();

    @Mod.EventBusSubscriber(modid = HiiragiMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register{

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block>event){
            final Block[] blocks = {
                   new BlockHiiragiBlock(),
                    new BlockHiiragiGlass()
            };
            event.getRegistry().registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerBlockItems(final RegistryEvent.Register<Item> event){
            final BlockItem[] blockItems = {
                    new BlockItem(HIIRAGI_BLOCK,new Item.Properties().tab(HiiragiMod.HIIRAGIMOD_TAB).fireResistant()),
                    new BlockItem(HIIRAGI_GLASS,new Item.Properties().tab(HiiragiMod.HIIRAGIMOD_TAB).fireResistant())
            };
            for (BlockItem item: blockItems){
                final Block block = item.getBlock();
                final ResourceLocation registryName = block.getRegistryName();
                event.getRegistry().register(item.setRegistryName(registryName));
            }
        }
    }
}

