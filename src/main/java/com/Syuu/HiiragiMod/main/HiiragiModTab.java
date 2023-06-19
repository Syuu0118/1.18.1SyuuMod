package com.Syuu.HiiragiMod.main;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class HiiragiModTab extends CreativeModeTab {

    public HiiragiModTab() {
        super("hiiragimod_tab");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Blocks.CRAFTING_TABLE);
    }
}