package net.fabricmc.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FoodRemainderItem extends Item {
    ItemStack remainder;

    public FoodRemainderItem(Settings settings, Item remainder) {
        super(settings);
        this.remainder = new ItemStack(remainder);
    }
    public FoodRemainderItem(Settings settings, ItemStack remainder) {
        super(settings);
        this.remainder = remainder;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        return user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode ? itemStack : remainder;
    }
}
