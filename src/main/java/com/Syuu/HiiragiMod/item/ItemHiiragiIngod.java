package com.Syuu.HiiragiMod.item;

import com.Syuu.HiiragiMod.main.HiiragiMod;
import net.minecraft.world.item.Item;

public class ItemHiiragiIngod extends Item {
    public ItemHiiragiIngod() {
        super(new Properties().tab(HiiragiMod.HIIRAGIMOD_TAB).fireResistant());
        this.setRegistryName("hiiragi_ingod");
    }
}
