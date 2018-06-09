package com.tyr.drops;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTyrDrops 
{
	@SubscribeEvent
	public void onLootTablesLoaded(LootTableLoadEvent event) 
	{
		
		//DUNGEONS
	    if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        //final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.treasure_chalice_gold), 5, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_chalice_gold"));
	            main.addEntry(new LootEntryItem(Items.SKULL, 3, 0, new LootFunction[0], new LootCondition[0], "minecraft:skull"));
	            main.addEntry(new LootEntryItem(Items.DIAMOND, 5, 0, new LootFunction[0], new LootCondition[0], "minecraft:diamond"));
	        }
//	        if (pool1 != null) 
//	        {
//	            //pool1.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.sandstone_pillar), 10, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:sandstone_pillar"));
//	        }
	    }
		
		//IGLOOS
	    if (event.getName().equals(LootTableList.CHESTS_IGLOO_CHEST)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        //final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_CHIRP, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_chirp"));
	        }
//	        if (pool1 != null) 
//	        {
//	            //pool1.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.sandstone_pillar), 10, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:sandstone_pillar"));
//	        }
	    }
	    
		//DESERT PYRAMID
	    if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        //final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.treasure_chalice_gold), 5, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_chalice_gold"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_MALL, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_mall"));
	            main.addEntry(new LootEntryItem(Items.SKULL, 3, 0, new LootFunction[0], new LootCondition[0], "minecraft:skull"));
		    }
//	        if (pool1 != null) 
//	        {
//	            //pool1.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.sandstone_pillar), 10, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:sandstone_pillar"));
//	        }
	    }
	    
		//JUNGLE PYRAMID
	    if (event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.treasure_chalice_gold), 5, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_chalice_gold"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_STRAD, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_strad"));
	            main.addEntry(new LootEntryItem(Items.CLAY_BALL, 10, 0, new LootFunction[0], new LootCondition[0], "minecraft:clay_ball"));
	            main.addEntry(new LootEntryItem(Items.SKULL, 3, 0, new LootFunction[0], new LootCondition[0], "minecraft:skull"));
		    }
	    }
	    
		//STRONGHOLD CORRIDOR
	    if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        //final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_MELLOHI, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_mellohi"));
	        }
//	        if (pool1 != null) 
//	        {
//	            //pool1.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.sandstone_pillar), 10, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:sandstone_pillar"));
//	        }
	    }
	    
		//STRONGHOLD CROSSING (Storage Room)
	    if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        //final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 25, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        }
//	        if (pool1 != null) 
//	        {
//	            //pool1.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.sandstone_pillar), 10, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:sandstone_pillar"));
//	        }
	    }
	    
		//STRONGHOLD LIBRARY
	    if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        //final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	            // pool1.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_FAR, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_far"));
	        }
//	        if (pool1 != null) 
//	        {
//	            //pool1.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.sandstone_pillar), 10, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:sandstone_pillar"));
//	        }
	    }
	    
	    //ABANDONED MINESHAFTS
	    if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        final LootPool pool1 = event.getTable().getPool("pool1");
	        if (main != null)
	        {
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        }
	        if (pool1 != null)
	        {
	        	main.addEntry(new LootEntryItem(Items.GOLD_NUGGET, 10, 0, new LootFunction[0], new LootCondition[0], "minecraft:gold_nugget"));	
	        	main.addEntry(new LootEntryItem(Items.FLINT, 5, 0, new LootFunction[0], new LootCondition[0], "minecraft:flint"));	
		    }
	    }  
	    
	    //VILLAGE BLACKSMITH
	    if (event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        if (main != null)
	        {
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.crate_lost_casting_mold), 25, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:crate_lost_casting_mold"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(Blocks.ANVIL), 20, 0, new LootFunction[0], new LootCondition[0], "minecraft:anvil"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_WAIT, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_wait"));
	            main.addEntry(new LootEntryItem(Items.COAL, 5, 0, new LootFunction[0], new LootCondition[0], "minecraft:coal"));
		    }
	    } 
	    
	    //NETHER BRIDGE
	    if (event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        if (main != null)
	        {
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.vase_quartz), 5, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:vase_quartz"));
	        	main.addEntry(new LootEntryItem(Items.QUARTZ, 20, 0, new LootFunction[0], new LootCondition[0], "minecraft:quartz"));
	        	main.addEntry(new LootEntryItem(Items.GLOWSTONE_DUST, 15, 0, new LootFunction[0], new LootCondition[0], "minecraft:glowstone_dust"));	
	        	main.addEntry(new LootEntryItem(Items.BLAZE_ROD, 5, 0, new LootFunction[0], new LootCondition[0], "minecraft:blaze_rod"));	
	        	main.addEntry(new LootEntryItem(Items.RECORD_11, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_11"));
	            main.addEntry(new LootEntryItem(Items.SKULL, 3, 0, new LootFunction[0], new LootCondition[0], "minecraft:skull"));
		    }
	    } 
	    
	    //END CITY
	    if (event.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE)) 
	    {
	 
	    	final LootPool main = event.getTable().getPool("main");
	        if (main != null)
	        {	
	        	main.addEntry(new LootEntryItem(TyrDropItems.treasure_bag, 20, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:treasure_bag"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(TyrDropBlocks.treasure_ruby_amulet), 5, 0, new LootFunction[0], new LootCondition[0], "tyrdrops:ruby_amulet"));
	        	main.addEntry(new LootEntryItem(Items.RECORD_BLOCKS, 8, 0, new LootFunction[0], new LootCondition[0], "minecraft:record_blocks"));
	        	main.addEntry(new LootEntryItem(Item.getItemFromBlock(Blocks.END_ROD), 20, 0, new LootFunction[0], new LootCondition[0], "minecraft:end_rod"));
		    }
	    } 
	    	
	}
	
	

}

