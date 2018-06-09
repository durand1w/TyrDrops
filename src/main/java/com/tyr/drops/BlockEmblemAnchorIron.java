package com.tyr.drops;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEmblemAnchorIron extends Block 
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	protected static final AxisAlignedBB EMBLEM_ANCHOR_IRON_NORTH_SOUTH_AABBcombined = new AxisAlignedBB(0.3125F, 0.0F, 0.0625F, 0.625F, 1.0F, 0.9375F);
	protected static final AxisAlignedBB EMBLEM_ANCHOR_IRON_NORTH_SOUTH_AABB = new AxisAlignedBB(0.3125F, 0.0F, 0.0625F, 0.625F, 0.3125F, 0.9375F);
	protected static final AxisAlignedBB EMBLEM_ANCHOR_IRON_NORTH_SOUTH_TOP_AABB = new AxisAlignedBB(0.3125F, 0.3125F, 0.3125F, 0.625F, 1.0F, 0.6875F);
	protected static final AxisAlignedBB EMBLEM_ANCHOR_IRON_EAST_WEST_AABBcombined = new AxisAlignedBB(0.0625F, 0.0F, 0.375F, 0.9375F, 1.0F, 0.625F);
	protected static final AxisAlignedBB EMBLEM_ANCHOR_IRON_EAST_WEST_AABB = new AxisAlignedBB(0.0625F, 0.0F, 0.375F, 0.9375F, 0.3125F, 0.625F);
	protected static final AxisAlignedBB EMBLEM_ANCHOR_IRON_EAST_WEST_TOP_AABB = new AxisAlignedBB(0.3125F, 0.3125F, 0.375F, 0.6875F, 1.0F, 0.625F);
	
    public BlockEmblemAnchorIron(String blockName)
    {       
        super(Material.ANVIL);
        setBlockName(this, blockName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(TyrDropItems.tabTyrDrops);
		this.useNeighborBrightness = true;
		setLightOpacity(1);
		setHardness(5F);
		setResistance(40F);
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        AxisAlignedBB axisalignedbb;

            switch ((EnumFacing)state.getValue(FACING))
            {
                case NORTH:
                default:
                    axisalignedbb = EMBLEM_ANCHOR_IRON_NORTH_SOUTH_AABBcombined;
                    break;
                case SOUTH:
                    axisalignedbb = EMBLEM_ANCHOR_IRON_NORTH_SOUTH_AABBcombined;
                    break;
                case WEST:
                    axisalignedbb = EMBLEM_ANCHOR_IRON_EAST_WEST_AABBcombined;
                    break;
                case EAST:
                    axisalignedbb = EMBLEM_ANCHOR_IRON_EAST_WEST_AABBcombined;
            }
        return axisalignedbb;
    }
    
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        state = this.getActualState(state, worldIn, pos);

        for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
        }
    }
    
    private static List<AxisAlignedBB> getCollisionBoxList(IBlockState bstate)
    {
        List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
        list.add(getBaseBlock(bstate));
        list.add(getTopBlock(bstate));
        return list;
    }
    
    private static AxisAlignedBB getBaseBlock(IBlockState bstate)
    {
        switch ((EnumFacing)bstate.getValue(FACING))
        {
            case NORTH:
            default:
                return EMBLEM_ANCHOR_IRON_NORTH_SOUTH_AABB;
            case SOUTH:
                return EMBLEM_ANCHOR_IRON_NORTH_SOUTH_AABB;
            case WEST:
                return EMBLEM_ANCHOR_IRON_EAST_WEST_AABB;
            case EAST:
                return EMBLEM_ANCHOR_IRON_EAST_WEST_AABB;
        }
    }
    
    private static AxisAlignedBB getTopBlock(IBlockState bstate)
    {
        switch ((EnumFacing)bstate.getValue(FACING))
        {
            case NORTH:
            default:
                return EMBLEM_ANCHOR_IRON_NORTH_SOUTH_TOP_AABB;
            case SOUTH:
                return EMBLEM_ANCHOR_IRON_NORTH_SOUTH_TOP_AABB;
            case WEST:
                return EMBLEM_ANCHOR_IRON_EAST_WEST_TOP_AABB;
            case EAST:
                return EMBLEM_ANCHOR_IRON_EAST_WEST_TOP_AABB;
        }
    }

    @Nullable
    public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
    {
        List<RayTraceResult> list = Lists.<RayTraceResult>newArrayList();

        for (AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(blockState, worldIn, pos)))
        {
            list.add(this.rayTrace(pos, start, end, axisalignedbb));
        }

        RayTraceResult raytraceresult1 = null;
        double d1 = 0.0D;

        for (RayTraceResult raytraceresult : list)
        {
            if (raytraceresult != null)
            {
                double d0 = raytraceresult.hitVec.squareDistanceTo(end);

                if (d0 > d1)
                {
                    raytraceresult1 = raytraceresult;
                    d1 = d0;
                }
            }
        }

        return raytraceresult1;
    }
        
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
//        EnumFacing enumfacing1 = placer.getHorizontalFacing().rotateY();
//        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing1);
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().rotateY());
    }
    
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
    	return false;
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
    
    @Override public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return true; }
	   
    public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(TyrDrops.MODID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}