package com.tyr.drops;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEmblemBellIron extends Block
{
	protected static final AxisAlignedBB EMBLEM_BELL_IRON_AABB = new AxisAlignedBB(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	
    public BlockEmblemBellIron(String blockName)
    {       
        super(Material.IRON);
        setBlockName(this, blockName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		useNeighborBrightness = true;
		setHardness(30.0F);
		setResistance(30.0F);
    }
    
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        if (!(entityIn instanceof EntityBoat))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, EMBLEM_BELL_IRON_AABB);
        }
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return EMBLEM_BELL_IRON_AABB;
    }
    
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return false;
    }
    
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
		double x = playerIn.posX;
		double y = playerIn.posY;
		double z = playerIn.posZ;
		playerIn.world.playSound(null , x, y, z, TyrDropSounds.iron_bell, SoundCategory.BLOCKS , 1.0F, 1.0F);
        super.onBlockClicked(worldIn, pos, playerIn);
    }
	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}
