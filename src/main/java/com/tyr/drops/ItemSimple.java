package com.tyr.drops;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSimple extends Item 
{
	public ItemSimple(String itemName)
    {
		setItemName(this, itemName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
    }
	
	public static void setItemName(Item item, final String itemName) 
	{
		item.setRegistryName(TyrDrops.MODID, itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}
}