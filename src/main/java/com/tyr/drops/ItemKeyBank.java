package com.tyr.drops;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKeyBank extends Item 
{
	
	public ItemKeyBank(String itemName)
	{
		setItemName(this, itemName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
		setMaxStackSize(1);
	}
	
	public static void setItemName(Item item, final String itemName) 
	{
		item.setRegistryName(TyrDrops.MODID, itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}

    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Scoreboard scoreboard = worldIn.getScoreboard(); 
		ScoreObjective scoreobjective = scoreboard.getObjectiveInDisplaySlot(0);
		Score score = scoreboard.getOrCreateScore(playerIn.getName(), scoreobjective);
    	if (playerIn.isSneaking() && (iblockstate.getBlock() == TyrDropBlocks.banking_station))
        {
        	if (scoreobjective != null && score.getScorePoints() >= 100)
        	{              	
        		double x = playerIn.posX;
        		double y = playerIn.posY;
        		double z = playerIn.posZ;
        		playerIn.world.playSound(null , x, y, z, TyrDropSounds.coins_sliding, SoundCategory.BLOCKS , 1.0F, 1.0F);
        		if (!playerIn.inventory.addItemStackToInventory(new ItemStack(TyrDropItems.tyr_diamond_coin)))
        		{
        			playerIn.dropItem(new ItemStack(TyrDropItems.tyr_diamond_coin), false);
        		}
        		score.decreaseScore(100);
        		if (worldIn.isRemote)
        		{
        			playerIn.sendMessage(new TextComponentString("Bank Balance:  $" + TextFormatting.DARK_GREEN + NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(score.getScorePoints()))));
        		}
        	} 
        	else if (score.getScorePoints() < 100)
        	{
        		if(worldIn.isRemote)
        		{
        			playerIn.sendMessage(new TextComponentString("You do not have the minimum 100 Tyrs to Withdraw"));
        			playerIn.sendMessage(new TextComponentString("Bank Balance:  $" + TextFormatting.RED + NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(score.getScorePoints()))));
        		}
        		return EnumActionResult.SUCCESS;
        	}
        	return EnumActionResult.SUCCESS;
        }
    	else if (iblockstate.getBlock() == TyrDropBlocks.banking_station)
    	{
    		Collection<Score> collection = scoreboard.getSortedScores(scoreobjective);
    		Iterator iterator = collection.iterator();
    		playerIn.sendMessage(new TextComponentString("Top Player Balances:"));
    		while ( iterator.hasNext())
    		{
    			Score balance = (Score)iterator.next();
    			if (worldIn.isRemote)
    			{
    				playerIn.sendMessage(new TextComponentString(balance.getPlayerName() + ":  $" + TextFormatting.GOLD + NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(balance.getScorePoints()))));
    			}
    	    }
    		return EnumActionResult.SUCCESS;
    	}
        else
        {
            return EnumActionResult.PASS;
        }	
        
    }         	
		
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
		list.add(TextFormatting.ITALIC + "Withdrawls Coins from a Banking Station");       
    }
}
