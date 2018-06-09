package com.tyr.drops;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCampfire extends Block
{
    private final boolean isBurning;
    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	//EAST
	protected static final AxisAlignedBB CAMPFIRE_SOUTH_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
	//SOUTH
	protected static final AxisAlignedBB CAMPFIRE_WEST_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
	//WEST
	protected static final AxisAlignedBB CAMPFIRE_NORTH_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
	//NORTH
	protected static final AxisAlignedBB CAMPFIRE_EAST_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
	
	public BlockCampfire(String blockName, boolean isBurning)
	{
		super(Material.WOOD);
		setBlockName(this, blockName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setHardness(2F);
		this.setResistance(10F);
		setSoundType(SoundType.WOOD);
		this.isBurning = isBurning;
        if (isBurning)
        {
            this.setLightLevel(0.75F);
        }
        if( !isBurning)
        {
    		setCreativeTab(TyrDropItems.tabTyrDrops);
        }
	}
		
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        AxisAlignedBB axisalignedbb;

            switch ((EnumFacing)state.getValue(FACING))
            {
                case NORTH:
                default:
                    axisalignedbb = CAMPFIRE_NORTH_AABB;
                    break;
                case SOUTH:
                    axisalignedbb = CAMPFIRE_SOUTH_AABB;
                    break;
                case WEST:
                    axisalignedbb = CAMPFIRE_WEST_AABB;
                    break;
                case EAST:
                    axisalignedbb = CAMPFIRE_EAST_AABB;
            }
        return axisalignedbb;
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
    
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
//        EnumFacing enumfacing1 = placer.getHorizontalFacing().rotateY();
//        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing1);
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().rotateY());
        
    }
        
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	ItemStack itemstack = playerIn.getHeldItem(hand);
        if (itemstack == null)
        {
            return true;
        }
        else
        {
            Item item = itemstack.getItem();
            if (item == Items.FLINT_AND_STEEL)
            {
            	double x = playerIn.posX;
            	double y = playerIn.posY;
            	double z = playerIn.posZ;
    			playerIn.world.playSound(null , x, y, z, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS , 1.0F, 1.0F);
    			if (!isBurning)
    			{
    				if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.campfire_oak))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.lit_campfire_oak.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.campfire_spruce))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.lit_campfire_spruce.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.campfire_birch))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.lit_campfire_birch.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.campfire_jungle))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.lit_campfire_jungle.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.campfire_acacia))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.lit_campfire_acacia.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.campfire_dark_oak))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.lit_campfire_dark_oak.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				
    			}
    			return true;
            }
            else if (item == Item.getItemFromBlock(TyrDropBlocks.emblem_pot))
            {
    			if (isBurning)
    			{
    				if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_oak))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.pot_oak_logs.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(LEVEL, Integer.valueOf(0)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_spruce))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.pot_spruce_logs.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(LEVEL, Integer.valueOf(0)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_birch))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.pot_birch_logs.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(LEVEL, Integer.valueOf(0)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_jungle))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.pot_jungle_logs.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(LEVEL, Integer.valueOf(0)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_acacia))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.pot_acacia_logs.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(LEVEL, Integer.valueOf(0)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_dark_oak))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.pot_dark_oak_logs.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(LEVEL, Integer.valueOf(0)), 3);
    				}	
    			}
    			return true;
            }
            else if (item == Items.WATER_BUCKET)
            {
            	if (!worldIn.isRemote)
            	{
            		if (!playerIn.capabilities.isCreativeMode)
            		{
            			playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
            		}
            	}
            	double x = playerIn.posX;
            	double y = playerIn.posY;
            	double z = playerIn.posZ;
            	if (isBurning)
            	{
            		playerIn.world.playSound(null , x, y, z, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS , 1.0F, 1.0F);
            		if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_oak))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.campfire_oak.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_spruce))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.campfire_spruce.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_birch))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.campfire_birch.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_jungle))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.campfire_jungle.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_acacia))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.campfire_acacia.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
    				else if ((worldIn.getBlockState(pos).getBlock() == TyrDropBlocks.lit_campfire_dark_oak))
    				{
    					worldIn.setBlockState(pos, TyrDropBlocks.campfire_dark_oak.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
    				}
            	}
            	return true;
            }
      
            else
            {
            	return false;
            }
        }
     }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        Random random = worldIn.rand;
    	if (isBurning)
    	{
    		EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);
    		double d0 = (double)pos.getX() + 0.5D;
    		double d1 = (double)pos.getY() + 0.2D;
    		double d2 = (double)pos.getZ() + 0.48D;
    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + .1D, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - .1D, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2 + .1D, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2 - .1D, 0.0D, 0.0D, 0.0D, new int[0]);   
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + .1D, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - .1D, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2 + .1D, 0.0D, 0.0D, 0.0D, new int[0]);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2 - .1D, 0.0D, 0.0D, 0.0D, new int[0]);  
    		if (random.nextDouble() < 0.1D)
    		{
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
    		}
    	}
    }
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return this.canBePlacedOn(worldIn, pos.down());
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if (!this.canBePlacedOn(worldIn, pos.down()))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    private boolean canBePlacedOn(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).isFullCube();
    }

    public int quantityDropped(Random random)
    {
        return random.nextInt(2);
    }
    
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(state.getBlock());
    }
    
    @Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
    {
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing().rotateY());
	}

    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    static final class SwitchEnumFacing
        {
            static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
            private static final String __OBFID = "CL_00002104";

            static
            {
                try
                {
                    FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 1;
                }
                catch (NoSuchFieldError var4)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 3;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 4;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
    	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}
