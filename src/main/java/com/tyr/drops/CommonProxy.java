package com.tyr.drops;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonObject;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	//Declare Events
	DropEnderDragonHoard eventsDropEnderDragonHoard = new DropEnderDragonHoard();
	DropWitherRewards eventsDropWitherRewards = new DropWitherRewards();
	DropElderGuardianRewards eventsDropElderGuardianRewards = new DropElderGuardianRewards();
	DropSpawnerFragment eventsDropSpawnerFragment = new DropSpawnerFragment();
	//FESTIVAL EVENTS
	//DropFairyFestival eventsDropFairyFestival = new DropFairyFestival();
	//DropWinterWonderland eventsDropWinterWonderland = new DropWinterWonderland();
	LootTyrDrops eventsLootTyrDrops = new LootTyrDrops();
	
    public void preInit(FMLPreInitializationEvent e) 
    {
    	
    	//Event Handler Registry
    	FMLCommonHandler.instance().bus().register(eventsDropEnderDragonHoard);
    	MinecraftForge.EVENT_BUS.register(eventsDropEnderDragonHoard);
    	FMLCommonHandler.instance().bus().register(eventsDropWitherRewards);
    	MinecraftForge.EVENT_BUS.register(eventsDropWitherRewards);
    	FMLCommonHandler.instance().bus().register(eventsDropElderGuardianRewards);
    	MinecraftForge.EVENT_BUS.register(eventsDropElderGuardianRewards);
    	FMLCommonHandler.instance().bus().register(eventsDropSpawnerFragment);
    	MinecraftForge.EVENT_BUS.register(eventsDropSpawnerFragment);  	
    	//FMLCommonHandler.instance().bus().register(eventsDropFairyFestival);
    	//MinecraftForge.EVENT_BUS.register(eventsDropFairyFestival); //DISABLED Fairy Festival Event
    	//FMLCommonHandler.instance().bus().register(eventsDropWinterWonderland);
    	//MinecraftForge.EVENT_BUS.register(eventsDropWinterWonderland); DISABLED Winter Wonderland Event
    	
    }
    
    public void init(FMLInitializationEvent e) 
    {
    	FMLCommonHandler.instance().bus().register(eventsLootTyrDrops);
    	MinecraftForge.EVENT_BUS.register(eventsLootTyrDrops);
    	
    	//RECIPES
    	List<String> TyrRecipes = new ArrayList();
    	Iterator<String> TyrRecipesIterator = TyrRecipes.iterator();
    	while (TyrRecipesIterator.hasNext())
    	{
        	CraftingHelper.register(new ResourceLocation(TyrDrops.MODID + "_" + TyrRecipesIterator.next() +".json"), new IRecipeFactory()
        	{
        		@Override
        		public IRecipe parse(JsonContext context, JsonObject json)
        		{
        			return CraftingHelper.getRecipe(json,  context);
        		}
        	});
    	}
    	GameRegistry.addSmelting(new ItemStack(TyrDropBlocks.gingerbread_block), new ItemStack(TyrDropBlocks.gingerbread_cookie_block),0.5F);
    }
}