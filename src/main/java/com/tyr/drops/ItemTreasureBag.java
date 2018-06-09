package com.tyr.drops;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemTreasureBag extends Item 
{	
	public ItemTreasureBag(String itemName)
	{
		setItemName(this, itemName);
		setCreativeTab(TyrDropItems.tabTyrDrops);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
		list.add(TextFormatting.GRAY + "Sneak to Reveal Treasures");       
    }
	
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
	
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		IBlockState iblockstate = worldIn.getBlockState(pos);
    	ItemStack itemstack = playerIn.getHeldItem(hand);
    	if (playerIn.isSneaking())
    	{
    		Random Rand = new Random();
    		switch(Rand.nextInt(31))
    		{
    		case 0: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_gem_shards,(Rand.nextInt(3) + 1)), false);
    		break;
    		case 1: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_chalice_gold), false);
    		break;
    		case 2: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_dust_bits,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 3: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_gold_egg), false);
    		break;
    		case 4: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_old_gold_coin,(Rand.nextInt(9) + 1)), false);
    		break;
    		case 5: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_pot_gold), false);
    		break;
    		case 6: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_ruby_amulet), false);
    		break;
    		case 7: playerIn.dropItem(new ItemStack(Items.DIAMOND_HORSE_ARMOR), false);
    		break;
    		case 8: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_gem_shards,(Rand.nextInt(3) + 1)), false);
    		break;
    		case 9: playerIn.dropItem(new ItemStack(Items.ELYTRA), false);
    		break;
    		case 10: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_dust_bits,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 11: playerIn.dropItem(new ItemStack(Items.EXPERIENCE_BOTTLE,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 12: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_old_gold_coin,(Rand.nextInt(9) + 1)), false);
    		break;
    		case 13: playerIn.dropItem(new ItemStack(Items.GOLDEN_HORSE_ARMOR), false);
    		break;
    		case 14: playerIn.dropItem(new ItemStack(Items.DIAMOND,(Rand.nextInt(27) + 1)), false);
    		break;
    		case 15: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_gem_shards,(Rand.nextInt(3) + 1)), false);
    		break;
    		case 16: playerIn.dropItem(new ItemStack(Items.NAME_TAG,(Rand.nextInt(3) + 1)), false);
    		break;
    		case 17: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_dust_bits,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 18: playerIn.dropItem(new ItemStack(Items.PRISMARINE_CRYSTALS,(Rand.nextInt(27) + 1)), false);
    		break;
    		case 19: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_old_gold_coin,(Rand.nextInt(9) + 1)), false);
    		break;
    		case 20: playerIn.dropItem(new ItemStack(Items.RABBIT_FOOT,(Rand.nextInt(3) + 1)), false);
    		break;
    		case 21: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_dust_bits,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 22: playerIn.dropItem(new ItemStack(Items.SHULKER_SHELL), false);
    		break;
    		case 23: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_old_gold_coin,(Rand.nextInt(9) + 1)), false);
    		break;
    		case 24: playerIn.dropItem(new ItemStack(Items.TOTEM_OF_UNDYING), false);
    		break;
    		case 25: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_old_gold_coin,(Rand.nextInt(9) + 1)), false);
    		break;
    		case 26: playerIn.dropItem(new ItemStack(Items.DIAMOND_CHESTPLATE), false);
    		break;
    		case 27: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_dust_bits,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 28: playerIn.dropItem(new ItemStack(Items.GLOWSTONE_DUST,(Rand.nextInt(27) + 1)), false);
    		break;
    		case 29: playerIn.dropItem(new ItemStack(TyrDropBlocks.treasure_dust_bits,(Rand.nextInt(7) + 1)), false);
    		break;
    		case 30: playerIn.dropItem(new ItemStack(TyrDropBlocks.vase_quartz), false);
    		break;
    		default: playerIn.dropItem(new ItemStack(Items.DIAMOND,(Rand.nextInt(27) + 1)), false);
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
