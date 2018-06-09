package com.tyr.drops;

import java.util.Random;

import net.minecraft.block.BlockMobSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropSpawnerFragment
{
	
	public Random Rand = new Random();

	@SubscribeEvent
	public void brokeBlock(BlockEvent.BreakEvent event)
	{
	  if ((event.getState().getBlock() == Blocks.MOB_SPAWNER)) 
	  {
	    event.setExpToDrop(200 + this.Rand.nextInt(30));
	  }
	}

	
	@SubscribeEvent
	public void on (HarvestDropsEvent event)
	{
		if (event.getState().getBlock() == Blocks.MOB_SPAWNER)
		{
			event.getDrops().add(new ItemStack(TyrDropItems.spawner_fragment, Rand.nextInt(2) + 1));
		}
	}	
}
