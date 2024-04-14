package com.glisco.victus.hearts.content;

import com.glisco.victus.Victus;
import com.glisco.victus.hearts.HeartAspect;
import com.glisco.victus.network.VictusParticleEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;

public class BlazingAspect extends HeartAspect {

    public static final Type TYPE = new Type(Victus.id("blazing"), 9, 25*20, 0xFD6A2C, BlazingAspect::new);

    public BlazingAspect(PlayerEntity player) {
        super(player, TYPE);
    }

    @Override
    public boolean handleBreak(DamageSource source, float damage, float originalHealth) {
        VictusParticleEvents.BLAZING_FLAMES.spawn(player.getWorld(), player.getPos());

        var entities = player.getWorld().getEntitiesByClass(LivingEntity.class, new Box(player.getBlockPos()).expand(4), (p) -> p != player && !(p instanceof TameableEntity tameable && tameable.isOwner(player)));

        for (int i = 0; i < 4; i++) {
            if (entities.size() < 1) return false;
            var entity = entities.remove(player.getWorld().random.nextInt(entities.size()));
            entity.damage(entity.getWorld().getDamageSources().inFire(), 3);
            entity.setOnFireFor(4);
        }

        return false;
    }
}
