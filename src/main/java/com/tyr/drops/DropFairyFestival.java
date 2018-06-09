package com.tyr.drops;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropFairyFestival 
{
	public static double rand;
	public Random Rand = new Random();
	
	@SubscribeEvent
	public void onEvent (LivingDropsEvent event)
	{
		rand = Math.random();
		
		if (rand < 0.10D)
		{
			if (event.getEntity() instanceof EntityCreeper || event.getEntity() instanceof EntitySkeleton || event.getEntity() instanceof EntityZombie || event.getEntity() instanceof EntitySpider || event.getEntity() instanceof EntityWitch)
			{
				if (rand < 0.02D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg1,1)));
				}
				if (rand > 0.02D && rand <= 0.04D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg2,1)));
				}
				if (rand > 0.04D && rand <= 0.046D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg3,1)));
				}
				//Gold Egg
				if (rand > 0.046D && rand <= 0.052D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg_gold,1)));
				}
				
				if (rand > 0.052D && rand <= 0.07D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg4,1)));
				}
				if (rand > 0.07D && rand <= 0.09D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg5,1)));
				}
				if (rand > 0.09D)
				{
					event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(TyrDropItems.easter_egg6,1)));
				}
			}

		}
	}
}
