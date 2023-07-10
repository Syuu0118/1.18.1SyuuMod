package com.Syuu.HiiragiMod.main;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;

public class HiiragiKeyBind {

    public  static KeyMapping hiiragiKey[];

    public static void keyRegister(final FMLClientSetupEvent event){
        hiiragiKey = new KeyMapping[1];

        hiiragiKey[0] = create("modeChange", KeyEvent.VK_B);

        for (int a = 0; a < hiiragiKey.length; a++){
            ClientRegistry.registerKeyBinding(hiiragiKey[a]);
        }
    }

    private static KeyMapping create (String name, int key){
        return  new KeyMapping("key.hiiragimod." + name, key, "key.category.hiiragimod");
    }
}

