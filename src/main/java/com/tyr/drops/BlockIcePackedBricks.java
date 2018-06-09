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

public class BlockIcePackedBricks extends Block
{
    public BlockIcePackedBricks(String blockName)
    {       
        super(Material.PACKED_ICE);
        setBlockName(this, blockName);
        this.slipperiness = 0.90F;
        setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(0.8F);
		setResistance(10.0F);
    }
	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}