package com.tyr.drops;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class ItemMoldSealed extends Item 
{
	private final String name="mold_sealed";
	
	public ItemMoldSealed()
	{
		setUnlocalizedName(TyrDrops.MODID + "_" + name);
		setCreativeTab(TyrDropItems.tabTyrDrops);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
		list.add(TextFormatting.ITALIC + "Place and Open to reveal sealed mold");       
    }
	
	public String getName()
	{
		return name;
	}
}
