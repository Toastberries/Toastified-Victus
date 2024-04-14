package com.glisco.victus.hearts.content;

import com.glisco.victus.Victus;
import com.glisco.victus.hearts.HeartAspect;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class BundleAspect extends HeartAspect {

    public static final Type TYPE = new Type(Victus.id("bundle"), 2, 75*20, 0xAE0000, BundleAspect::new);

    public BundleAspect(PlayerEntity player) {
        super(player, TYPE);
    }

    @Override
    public boolean handleBreak(DamageSource source, float damage, float originalHealth) {
        player.heal(4f);
        return false;
    }
}
