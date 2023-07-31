package com.Syuu.HiiragiMod.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.material.Material;

public class BlockHiiragiGlass extends StainedGlassBlock {

    public BlockHiiragiGlass() {
        super(DyeColor.ORANGE,Properties.of(Material.GLASS)
                .sound(SoundType.METAL)
                .strength(30F,15000F)
                .noOcclusion()
        );
        this.setRegistryName("hiiragi_glass");
    }
}
