package entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;

public class NonFireLB extends LightningBolt
{

    public NonFireLB(Level world) {
        super(EntityType.LIGHTNING_BOLT, world);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
