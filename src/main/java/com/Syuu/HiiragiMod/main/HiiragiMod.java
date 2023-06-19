package com.Syuu.HiiragiMod.main;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod("hiiragimod")
public class HiiragiMod {

    public static final String MOD_ID = "hiiragimod";

    public static final CreativeModeTab HIIRAGIMOD_TAB = new HiiragiModTab();

    public static final CreativeModeTab SYUUMOD_TAB = new SyuuModTab();

}