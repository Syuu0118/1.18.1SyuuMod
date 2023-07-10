package com.Syuu.HiiragiMod.item.tool;

import com.Syuu.HiiragiMod.main.HiiragiKeyBind;
import com.Syuu.HiiragiMod.main.HiiragiMod;
import com.Syuu.HiiragiMod.regi.HiiragiModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolHiiragiPickaxe extends PickaxeItem {

    public ToolHiiragiPickaxe() {
        super(HiiragiModTiers.HIIRAGI, 1, -2.8F, new Properties().tab(HiiragiMod.HIIRAGIMOD_TAB).fireResistant());
        this.setRegistryName("hiiragi_pickaxe");
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity.tickCount % 500 == 0) {
            stack.setDamageValue(stack.getDamageValue() - 5);
        }
        Player Player = (net.minecraft.world.entity.player.Player) entity;
        InteractionHand hand = Player.getUsedItemHand();
        if (!world.isClientSide && Player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == HiiragiModItems.HIIRAGI_PICKAXE && HiiragiKeyBind.hiiragiKey[0].consumeClick()){
            Player.startUsingItem(hand);
            world.playSound(null,Player, SoundEvents.IRON_DOOR_OPEN, SoundSource.PLAYERS,1.0F,1.0F);
            modeChange(stack);
            Player.displayClientMessage(new TextComponent("Mode:" + modeName(stack)),true);
        }
    }

    public void modeChange(ItemStack stack) {
        if (stack.getTag() == null) {
            stack.setTag(new CompoundTag());
        }
        stack.getTag().putInt("mode", modeInt(stack) < 1 ? modeInt(stack) + 1 : 0);
    }



    public int modeInt(ItemStack stack) {
        if (stack.getTag() == null) {
            return 0;
        }
        return stack.getTag().getInt("mode");

    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state_) {
        return switch (modeInt(stack)) {
            case 0 -> BlockTags.MINEABLE_WITH_PICKAXE.contains(state_.getBlock()) ? HiiragiModTiers.HIIRAGI.getSpeed() : 1.0F;
            case 1 -> BlockTags.MINEABLE_WITH_PICKAXE.contains(state_.getBlock()) ? HiiragiModTiers.HIIRAGI.getSpeed() * 3 : 1.0F;
            default -> 0F;
        };
    }

    public String modeName(ItemStack stack){
        return switch (modeInt(stack)) {
            case 0 -> "normal" ;
            case 1 -> "tactical";
            default -> "unknown";
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag tooltip) {
        list.add(new TextComponent("Mode:" + modeName(stack)));
    }
}
