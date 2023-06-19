package com.Syuu.HiiragiMod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class BlockHiiragiBlock extends Block {

    public BlockHiiragiBlock() {
        super(Properties.of(Material.METAL).strength(7.0F,12000F)
                .sound(SoundType.DEEPSLATE)
                .lightLevel(value -> 15 )
                .requiresCorrectToolForDrops()
                .jumpFactor(10)
        );

        this.setRegistryName("hiiragi_block");
    }
}
