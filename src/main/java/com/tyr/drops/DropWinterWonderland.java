package com.tyr.drops;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropWinterWonderland
{
	public static double rand;
	public Random Rand = new Random();
	
	@SubscribeEvent
	public void onEvent (LivingDropsEvent event)
	{
		rand = Math.random();
		if (event.getEntity() instanceof EntityCreeper)
		{
			if (rand < 0.50D)
			{
				event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.candy_cane,(Rand.nextInt(1) + 1))));
				event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.gingerbread,(Rand.nextInt(1) + 1))));
			}
		}
		if (event.getEntity() instanceof EntitySkeleton)
		{	
			if (rand < 0.50D)
			{
				event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.candy_cane,(Rand.nextInt(1) + 1))));
			}
		}
		if (event.getEntity() instanceof EntityZombie)
		{	
			if (rand < 0.50D)
			{
				event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.gingerbread,(Rand.nextInt(1) + 1))));
			}
		}   
	}
}