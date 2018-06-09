package com.tyr.drops;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class DropEnderDragonHoard
{
	public Random Rand = new Random();
	
	@SubscribeEvent
	public void onEvent (LivingDropsEvent event)
	{
		if (event.getEntity() instanceof EntityDragon)
		{
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,2);
			event.getEntity().dropItem(Items.DIAMOND,3);
			event.getEntity().dropItem(Items.EMERALD,2);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,2);
			event.getEntity().dropItem(Items.GOLD_NUGGET,3);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_gem_shards),1);
			event.getEntity().dropItem(Items.DIAMOND,2);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_dust_bits),1);
			event.getEntity().dropItem(Items.DIAMOND,2);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_gem_shards),1);
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,3);
			event.getEntity().dropItem(Items.GOLD_NUGGET,3);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_dust_bits),1);
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Items.DIAMOND,3);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(TyrDropItems.tyr_emerald_coin,(Rand.nextInt(5) + 1));
			event.getEntity().dropItem(Items.GOLD_NUGGET,2);
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,3);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_dust_bits),1);
			event.getEntity().dropItem(Items.DIAMOND,3);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,4);
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_gem_shards),1);
			event.getEntity().dropItem(Items.EMERALD,2);
			event.getEntity().dropItem(Items.GOLD_NUGGET,2);
			event.getEntity().dropItem(TyrDropItems.tyr_diamond_coin,(Rand.nextInt(3) + 1));
			event.getEntity().dropItem(Items.DIAMOND,2);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_gem_shards),(Rand.nextInt(2) + 1));
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_dust_bits),1);
			event.getEntity().dropItem(Items.DIAMOND,1);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,3);
			event.getEntity().dropItem(Items.DIAMOND,3);
			event.getEntity().dropItem(Items.EMERALD,1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,5);
			event.getEntity().dropItem(Items.DIAMOND,2);
			event.getEntity().dropItem(Items.EMERALD,2);
			event.getEntity().dropItem(Items.GOLD_NUGGET,2);
			event.getEntity().dropItem(Items.DIAMOND,(Rand.nextInt(6) + 1));
			event.getEntity().dropItem(Items.EMERALD,Rand.nextInt(3) + 1);
			event.getEntity().dropItem(Items.GOLD_NUGGET,Rand.nextInt(9) + 1);
			event.getEntity().dropItem(TyrDropItems.enderian_token,1);
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.treasure_old_gold_coin),(Rand.nextInt(12) + 5));
			event.getEntity().dropItem(Item.getItemFromBlock(TyrDropBlocks.sealed_ender_dragon_egg),1);
		}
	}
}
