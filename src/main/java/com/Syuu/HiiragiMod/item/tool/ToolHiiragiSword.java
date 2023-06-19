package com.Syuu.HiiragiMod.item.tool;

import com.Syuu.HiiragiMod.entity.NonFireLB;
import com.Syuu.HiiragiMod.entity.NonFireLB;
import com.Syuu.HiiragiMod.main.HiiragiMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Timer;
import java.util.TimerTask;

public class ToolHiiragiSword extends SwordItem {

    public ToolHiiragiSword() {
        super(HiiragiModTiers.HIIRAGI,10,-5.0F,new Properties().tab(HiiragiMod.HIIRAGIMOD_TAB).fireResistant());
        this.setRegistryName("hiiragi_sword");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if(player.experienceLevel > 3){
            player.giveExperienceLevels(-3);
            stack.setDamageValue(stack.getDamageValue() - 10);
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,20*60*3,9,false,false));
        }
        return InteractionResultHolder.success(stack);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity attacker) {
        Vec3 vec3 = attacker.getLookAngle();
        enemy.setDeltaMovement(vec3.x * 1.5, 1.5, vec3.z * 1.5);

        Player Player = (Player)attacker;
        UseOnContext context = new UseOnContext(Player,Player.getUsedItemHand(), null);
        Level world = context.getLevel();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                BlockPos pos = enemy.blockPosition();
                LightningBolt nonFire = new NonFireLB(world);
                nonFire.moveTo(Vec3.atBottomCenterOf(pos));
                nonFire.setCause(Player instanceof ServerPlayer ? (ServerPlayer) Player : null);
                world.addFreshEntity(nonFire);
            }
        }, 2500);

        return super.hurtEnemy(stack, enemy, attacker);
    }
}
