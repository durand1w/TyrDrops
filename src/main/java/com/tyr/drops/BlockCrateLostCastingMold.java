package com.tyr.drops;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrateLostCastingMold extends Block 
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	protected static final AxisAlignedBB CRATE_LOST_CASTING_MOLD_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.875F, 1.0F);
	public Random Rand = new Random();
	
    public BlockCrateLostCastingMold(String blockName)
    {       
        super(Material.WOOD);
        setBlockName(this, blockName);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setHardness(4.5F);
		setResistance(25F);
    }
      
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        if (!(entityIn instanceof EntityBoat))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, CRATE_LOST_CASTING_MOLD_AABB);
        }
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CRATE_LOST_CASTING_MOLD_AABB;
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

    public int quantityDropped(Random random)
    {
        return random.nextInt(6);
    }
    
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack)
    {
		double x = player.posX;
		double y = player.posY;
		double z = player.posZ;
		player.world.playSound(null , x, y, z, TyrDropSounds.crate_break_open, SoundCategory.BLOCKS , 1.0F, 1.0F);
		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y + 0.5D, z, 0.0D, 0.0D, 0.0D, new int[0]);
//        this.activate(worldIn, pos);
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }
    

    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
    	
    	super.getDrops(drops, world, pos, state, fortune);
        drops.add(new ItemStack(Item.getItemFromBlock(Blocks.WOODEN_SLAB), this.Rand.nextInt(2) + 1));
        
        Random RandomMold = new Random();
       	switch(RandomMold.nextInt(18))
    	{
    	case 0: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_anchor_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_anchor_iron)));
    	break;
    	case 1: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_bell_gold)));
    	break;
    	case 2: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_bell_iron)));
    	break;
    	case 3: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_gold)));
    	break;
    	case 4: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_creeper_iron)));
    	break;
    	case 5: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_gold)));
    	break;
    	case 6: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_crosslet_iron)));
    	break;
    	case 7: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_gold)));
    	break;
    	case 8: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_horseshoe_iron)));
    	break;
    	case 9: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_pot)));
    	break;
    	case 10: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_weather_vane_arrowtop_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_weather_vane_gold)));
    	break;
    	case 11: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_weather_vane_arrowtop_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.emblem_weather_vane_iron)));
    	break;
    	case 12: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_gold)));
    	break;
    	case 13: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_iron)));
    	 drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_iron)));
        drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_iron)));
    	break;
    	case 14: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_wrought_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_wrought_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_wrought_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_dull_wrought_iron)));
    	break;
    	case 15: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_sharp_gold)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_sharp_gold)));
    	break;
    	case 16: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_sharp_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_sharp_iron)));
    	break;
    	case 17: drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_sharp_wrought_iron)));
    	drops.add(new ItemStack(Item.getItemFromBlock(TyrDropBlocks.metal_cap_sharp_wrought_iron)));
    	break;
    	default: drops.add(new ItemStack(Items.DIAMOND));
    	drops.add(new ItemStack(Items.DIAMOND));
    	drops.add(new ItemStack(Items.DIAMOND));
    	}
        return;
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
