package com.tyr.drops;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TyrDropsTab extends CreativeTabs 
{
	public TyrDropsTab (String label)
	{
		super(label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(TyrDropBlocks.treasure_chalice_gold_ruby_amulet);
	}
}