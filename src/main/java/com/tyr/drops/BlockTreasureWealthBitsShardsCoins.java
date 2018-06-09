package com.tyr.drops;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTreasureWealthBitsShardsCoins extends Block
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	//EAST
	protected static final AxisAlignedBB TREASURE_SOUTH_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	//SOUTH
	protected static final AxisAlignedBB TREASURE_WEST_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	//WEST
	protected static final AxisAlignedBB TREASURE_NORTH_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	//NORTH
	protected static final AxisAlignedBB TREASURE_EAST_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	
	public BlockTreasureWealthBitsShardsCoins(String blockName)
	{
		super(Material.SAND);
		setBlockName(this, blockName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(TyrDropItems.tabTyrDrops);
		this.setHardness(2F);
		this.setResistance(4F);
		setLightLevel(0.625F);
		setSoundType(SoundType.SAND);
	}
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        AxisAlignedBB axisalignedbb;

            switch ((EnumFacing)state.getValue(FACING))
            {
                case NORTH:
                default:
                    axisalignedbb = TREASURE_NORTH_AABB;
                    break;
                case SOUTH:
                    axisalignedbb = TREASURE_SOUTH_AABB;
                    break;
                case WEST:
                    axisalignedbb = TREASURE_WEST_AABB;
                    break;
                case EAST:
                    axisalignedbb = TREASURE_EAST_AABB;
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
    
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
		double x = playerIn.posX;
		double y = playerIn.posY;
		double z = playerIn.posZ;
		playerIn.world.playSound(null , x, y, z, TyrDropSounds.coins_sliding, SoundCategory.BLOCKS , 1.0F, 1.0F);
        super.onBlockClicked(worldIn, pos, playerIn);
    }
    
    public void onBlockPlaced(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
		double x = playerIn.posX;
		double y = playerIn.posY;
		double z = playerIn.posZ;
		playerIn.world.playSound(null , x, y, z, TyrDropSounds.coins_sliding, SoundCategory.BLOCKS , 1.0F, 1.0F);
        super.onBlockClicked(worldIn, pos, playerIn);
    }

    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}
