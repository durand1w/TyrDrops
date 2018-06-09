package com.tyr.drops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockCandyStairs extends BlockStairs
{
	public BlockCandyStairs(String blockName)
	{
		super (TyrDropBlocks.candy_planks.getStateFromMeta(0));
		setBlockName(this, blockName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(2F);
		setResistance(15F);
		this.useNeighborBrightness = true;
	}
	
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}
