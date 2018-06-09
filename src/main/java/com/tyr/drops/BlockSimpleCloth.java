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

public class BlockSimpleCloth extends Block
{
    public BlockSimpleCloth(String blockName)
    {       
        super(Material.CLOTH);
        setBlockName(this, blockName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(1.75F);
		setResistance(12.0F);
		setSoundType(SoundType.CLOTH);
    }
	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}