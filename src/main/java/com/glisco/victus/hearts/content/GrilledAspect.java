package com.glisco.victus.hearts.content;

import com.glisco.victus.Victus;
import com.glisco.victus.hearts.HeartAspect;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GrilledAspect extends HeartAspect {

    public static final Type TYPE = new Type(Victus.id("grilled"), 3, 60, 0x71413B, GrilledAspect::new);

    public GrilledAspect(PlayerEntity player) {
        super(player, TYPE);
    }

    @Override
    public boolean handleBreak(DamageSource source, float damage, float originalHealth) {
        player.eatFood(player.getWorld(), new ItemStack(Items.COOKED_MUTTON));
        return false;
    }

}
