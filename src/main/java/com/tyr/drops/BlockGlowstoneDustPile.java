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

public class BlockGlowstoneDustPile extends BlockFalling
{
	public BlockGlowstoneDustPile(String blockName)
	{
		super(Material.SAND);
		setBlockName(this, blockName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(0.4F);
		setResistance(2.2F);
        setLightLevel(0.875F);
		setSoundType(SoundType.SAND);
	}

    public int quantityDropped(Random random)
    {
        return 7;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.GLOWSTONE_DUST;
    }
	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}
