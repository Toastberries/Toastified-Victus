package com.glisco.victus.hearts.content;

import com.glisco.victus.Victus;
import com.glisco.victus.hearts.HeartAspect;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class LapisAspect extends HeartAspect {

    public static final Type TYPE = new Type(Victus.id("lapis"), 15, 3*20, 0x0064B8, LapisAspect::new);

    public LapisAspect(PlayerEntity player) {
        super(player, TYPE);
    }

    @Override
    public boolean handleBreak(DamageSource source, float damage, float originalHealth) {
        return false;
    }
}
