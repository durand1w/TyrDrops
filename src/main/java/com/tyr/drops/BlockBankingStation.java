package com.tyr.drops;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBankingStation extends Block
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	protected static final AxisAlignedBB BANKING_STATION_BASE_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	protected static final AxisAlignedBB BANKING_STATION_BACKING_AABB = new AxisAlignedBB(0.125F, 0.125F, 0.125F, 0.875F, 0.375F, 0.875F);
	protected static final AxisAlignedBB BANKING_STATION_JEWEL1_AABB = new AxisAlignedBB(0.375F, 0.3125F, 0.0F, 0.6875F, 0.875F, 0.0625F);
	protected static final AxisAlignedBB BANKING_STATION_JEWEL2_AABB = new AxisAlignedBB(0.375F, 0.3125F, 0.9375F, 0.6875F, 0.875F, 1.0F);
	protected static final AxisAlignedBB BANKING_STATION_JEWEL3_AABB = new AxisAlignedBB(0.0F, 0.3125F, 0.375F, 0.0625F, 0.875F, 0.6875F);
	protected static final AxisAlignedBB BANKING_STATION_JEWEL4_AABB = new AxisAlignedBB(0.9375F, 0.3125F, 0.375F, 1.0F, 0.875F, 0.6875F);
	protected static final AxisAlignedBB BANKING_STATION_COIN1_AABB = new AxisAlignedBB(0.1875F, 0.1875F, 0.0625F, 0.875F, 1.0F, 0.125F);
	protected static final AxisAlignedBB BANKING_STATION_COIN2_AABB = new AxisAlignedBB(0.1875F, 0.1875F, 0.875F, 0.875F, 1.0F, 0.9375F);
	protected static final AxisAlignedBB BANKING_STATION_COIN3_AABB = new AxisAlignedBB(0.0625F, 0.1875F, 0.1875F, 0.125F, 1.0F, 0.875F);
	protected static final AxisAlignedBB BANKING_STATION_COIN4_AABB = new AxisAlignedBB(0.875F, 0.1875F, 0.1875F, 0.9375F, 1.0F, 0.875F);
	//BOUNDING
	protected static final AxisAlignedBB BANKING_STATION_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	public BlockBankingStation(String blockName)
	{
		super(Material.IRON);
		setBlockName(this, blockName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(3.0F);
		setResistance(9000F);
		setLightLevel(0.25F);
		setSoundType(SoundType.METAL);
	}
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
    	return BANKING_STATION_AABB;
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
        list.add(getBackingBlock(bstate));
        list.add(getJewel1Block(bstate));
        list.add(getJewel2Block(bstate));
        list.add(getJewel3Block(bstate));
        list.add(getJewel4Block(bstate));
        list.add(getCoin1Block(bstate));
        list.add(getCoin2Block(bstate));
        list.add(getCoin3Block(bstate));
        list.add(getCoin4Block(bstate));
        return list;
    }
    
    private static AxisAlignedBB getBaseBlock(IBlockState bstate)
    {
        return BANKING_STATION_BASE_AABB;
    }
    
    private static AxisAlignedBB getBackingBlock(IBlockState bstate)
    {
    	return BANKING_STATION_BACKING_AABB;
    }
    
    private static AxisAlignedBB getJewel1Block(IBlockState bstate)
    {
    	return BANKING_STATION_JEWEL1_AABB;
    }
    
    private static AxisAlignedBB getJewel2Block(IBlockState bstate)
    {
    	return BANKING_STATION_JEWEL2_AABB;
    }
    
    private static AxisAlignedBB getJewel3Block(IBlockState bstate)
    {
    	return BANKING_STATION_JEWEL3_AABB;
    }
    
    private static AxisAlignedBB getJewel4Block(IBlockState bstate)
    {
    	return BANKING_STATION_JEWEL4_AABB;
    }
    
    private static AxisAlignedBB getCoin1Block(IBlockState bstate)
    {
    	return BANKING_STATION_COIN1_AABB;
    }
    
    private static AxisAlignedBB getCoin2Block(IBlockState bstate)
    {
    	return BANKING_STATION_COIN2_AABB;
    }
    
    private static AxisAlignedBB getCoin3Block(IBlockState bstate)
    {
    	return BANKING_STATION_COIN3_AABB;
    }
    
    private static AxisAlignedBB getCoin4Block(IBlockState bstate)
    {
    	return BANKING_STATION_COIN4_AABB;
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
