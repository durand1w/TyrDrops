package com.tyr.drops;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSealedEnderDragonEgg extends Block
{
	protected static final AxisAlignedBB SEALED_ENDER_DRAGON_EGG_AABB = new AxisAlignedBB(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	
	public BlockSealedEnderDragonEgg(String blockName)
	{
		super(Material.DRAGON_EGG);
		setBlockName(this, blockName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(3.0F);
		setResistance(1045.0F);
		
	}
	
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
    {
        if (!(entityIn instanceof EntityBoat))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SEALED_ENDER_DRAGON_EGG_AABB);
        }
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SEALED_ENDER_DRAGON_EGG_AABB;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        //this.checkFall(worldIn, pos);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        //this.teleport(worldIn, pos);
        return false;
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        //this.teleport(worldIn, pos);
        if (worldIn.isRemote)
        {
        	BlockPos blockpos1 = pos.add(worldIn.rand.nextInt(16) - worldIn.rand.nextInt(16), worldIn.rand.nextInt(8) - worldIn.rand.nextInt(8), worldIn.rand.nextInt(16) - worldIn.rand.nextInt(16));
            for (int j = 0; j < 128; ++j)
            {
                double d0 = worldIn.rand.nextDouble();
                float f = (worldIn.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (worldIn.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (worldIn.rand.nextFloat() - 0.5F) * 0.2F;
                double d1 = (double)blockpos1.getX() + (double)(pos.getX() - blockpos1.getX()) * d0 + (worldIn.rand.nextDouble() - 0.5D) * 1.0D + 0.5D;
                double d2 = (double)blockpos1.getY() + (double)(pos.getY() - blockpos1.getY()) * d0 + worldIn.rand.nextDouble() * 1.0D - 0.5D;
                double d3 = (double)blockpos1.getZ() + (double)(pos.getZ() - blockpos1.getZ()) * d0 + (worldIn.rand.nextDouble() - 0.5D) * 1.0D + 0.5D;
                worldIn.spawnParticle(EnumParticleTypes.PORTAL, d1, d2, d3, (double)f, (double)f1, (double)f2, new int[0]);
            }
        }
    }

    public int tickRate(World worldIn)
    {
        return 5;
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

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return null;
    }
    
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
	
}
