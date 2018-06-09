package com.tyr.drops;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemEasterEgg1 extends Item 
{
	private static double rand;
	public Random Rand = new Random();
	
	public ItemEasterEgg1(String itemName)
	{
		setItemName(this, itemName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
		list.add(TextFormatting.GRAY + "Sneak to Reveal Treasures");       
    }
	
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		IBlockState iblockstate = worldIn.getBlockState(pos);
    	ItemStack itemstack = playerIn.getHeldItem(hand);
    	if (playerIn.isSneaking())
    	{
    		Random Rand = new Random();
    		switch(Rand.nextInt(5))
    		{
    		case 0: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_old_gold_coin), false);
    		break;
    		case 1: playerIn.dropItem(new ItemStack(TyrDropItems.barter_fairy_festival,(Rand.nextInt(2) + 1)), false);
    		break;
    		case 2: playerIn.dropItem(new ItemStack(TyrDropItems.food_caramel_candy), false);
    		break;
    		case 3: playerIn.dropItem(new ItemStack(TyrDropItems.barter_fairy_festival,(Rand.nextInt(1) + 1)), false);
    		break;
    		case 4: playerIn.dropItem(new ItemStack(Items.DYE,1,4), false);
    		break;
    		default: playerIn.dropItem(new ItemStack(Items.DIAMOND), false);
    		}
            if (!playerIn.capabilities.isCreativeMode)
            {
            	itemstack.shrink(1);
            }
        	return EnumActionResult.SUCCESS;
    	}
        else
        {
            return EnumActionResult.PASS;
        } 
    }
        
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {        
    	ItemStack itemstack = playerIn.getHeldItem(hand);
        if (playerIn.isSneaking())
        {
            playerIn.setActiveHand(hand);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
        	return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }
	
	public static void setItemName(Item item, final String itemName) 
	{
		item.setRegistryName(TyrDrops.MODID, itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}
}
