package com.Syuu.HiiragiMod.item.tool;

import com.Syuu.HiiragiMod.main.HiiragiMod;
import com.Syuu.HiiragiMod.regi.HiiragiModItems;
import com.Syuu.HiiragiMod.regi.HiiragiModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class HiiragiModTiers {

    public static final ForgeTier HIIRAGI = new ForgeTier(5,6000,15F,6F,100, HiiragiModTags.Blocks.NEEDS_HIIRAGI_TOOL,()-> Ingredient.of(HiiragiModItems.HIIRAGI_INGOD));

    static {
        TierSortingRegistry.registerTier(HIIRAGI,new ResourceLocation(HiiragiMod.MOD_ID,"hiiragi"), List.of(TierSortingRegistry.getName(Tiers.NETHERITE)),List.of());
    }

}
