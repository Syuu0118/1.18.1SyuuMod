package com.Syuu.HiiragiMod.regi;

import com.Syuu.HiiragiMod.main.HiiragiMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class HiiragiModTags {

    public static class Blocks{

        public static final Tags.IOptionalNamedTag NEEDS_HIIRAGI_TOOL = tag("needs_hiiragi_tool");

        private static final Tags.IOptionalNamedTag<Block> tag(String name){
            return BlockTags.createOptional(new ResourceLocation(HiiragiMod.MOD_ID,name));
        }
    }

    public static class Items{

        private static final Tags.IOptionalNamedTag<Item> tag(String name){
            return ItemTags.createOptional(new ResourceLocation(HiiragiMod.MOD_ID,name));
        }
    }
}

