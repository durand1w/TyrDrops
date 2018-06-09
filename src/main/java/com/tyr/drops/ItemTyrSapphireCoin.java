package com.tyr.drops;

import java.text.NumberFormat;
import java.util.Locale;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemTyrSapphireCoin extends Item
{
	public ItemTyrSapphireCoin(String itemName)
	{
		setItemName(this, itemName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
	}

    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (iblockstate.getBlock() == TyrDropBlocks.banking_station)
        {
    		double x = playerIn.posX;
    		double y = playerIn.posY;
    		double z = playerIn.posZ;
        	worldIn.playSound(playerIn, pos, TyrDropSounds.coins_sliding, SoundCategory.BLOCKS , 1.0F, 1.0F);
        	Scoreboard scoreboard = worldIn.getScoreboard();     	
    		ScoreObjective scoreobjective = scoreboard.getObjectiveInDisplaySlot(0);
    		Score score = scoreboard.getOrCreateScore(playerIn.getName(), scoreobjective);
    		score.increaseScore(20);
    		if (worldIn.isRemote)
    		{
    			playerIn.sendMessage(new TextComponentString("Bank Balance:  $" + TextFormatting.DARK_GREEN + NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(score.getScorePoints()))));
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
		
	public static void setItemName(Item item, final String itemName) 
	{
		item.setRegistryName(TyrDrops.MODID, itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}
}
