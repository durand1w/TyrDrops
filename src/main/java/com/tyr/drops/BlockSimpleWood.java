package com.tyr.drops;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSimpleWood extends Block
{
    public BlockSimpleWood(String blockName)
    {       
        super(Material.WOOD);
		setBlockName(this, blockName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(2F);
		setResistance(15F);
    }
	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}