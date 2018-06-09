package com.tyr.drops;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemSimpleFood extends ItemFood
{
	public ItemSimpleFood(String itemName, int healAmount, float saturationModifier, boolean isWolfFood)
	{
		super(healAmount, saturationModifier, isWolfFood);
		setItemName(this, itemName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
	}
	
	public static void setItemName(Item item, final String itemName) 
	{
		item.setRegistryName(TyrDrops.MODID, itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}
}
