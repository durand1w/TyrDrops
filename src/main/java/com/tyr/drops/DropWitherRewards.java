package com.tyr.drops;

import java.util.Random;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class DropWitherRewards
{
	public Random Rand = new Random();
	
	@SubscribeEvent
	public void onEvent (LivingDropsEvent event)
	{
		if (event.getEntity() instanceof EntityWither)
		{
			event.getEntity().dropItem(TyrDropItems.tyr_sapphire_coin,(Rand.nextInt(5) + 1));
			event.getEntity().dropItem(TyrDropItems.tyr_ruby_coin,(Rand.nextInt(5) + 1));
			event.getEntity().dropItem(TyrDropItems.tyr_emerald_coin,(Rand.nextInt(3) + 1));
			event.getEntity().dropItem(TyrDropItems.tyr_diamond_coin,(Rand.nextInt(1) + 1));
			event.getEntity().dropItem(TyrDropItems.netherian_token,1);
		}
	}
}
