package com.tyr.drops;



import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(TyrDrops.MODID)
public class TyrDropBlocks 
{
	public static Block admin_cobweb1 = new BlockAdminCobweb("admin_cobweb1");
	public static Block admin_cobweb2 = new BlockAdminCobweb("admin_cobweb2");
	public static Block admin_cobweb3 = new BlockAdminCobweb("admin_cobweb3");
	public static Block admin_cobweb4 = new BlockAdminCobweb("admin_cobweb4");
	public static Block admin_cobweb5 = new BlockAdminCobweb("admin_cobweb5");
	public static Block admin_cobweb6 = new BlockAdminCobweb("admin_cobweb6");
	public static Block admin_cobweb7 = new BlockAdminCobweb("admin_cobweb7");
	public static Block admin_cobweb8 = new BlockAdminCobweb("admin_cobweb8");
	public static Block admin_cobweb9 = new BlockAdminCobweb("admin_cobweb9");
	public static Block admin_sand1 = new BlockAdminSand("admin_sand1");
	public static Block admin_sand2 = new BlockAdminSand("admin_sand2");
	public static Block admin_sand3 = new BlockAdminSand("admin_sand3");
	public static Block admin_sand4 = new BlockAdminSand("admin_sand4");
	public static Block admin_sand5 = new BlockAdminSand("admin_sand5");
	public static Block admin_sand6 = new BlockAdminSand("admin_sand6");
	public static Block admin_sand7 = new BlockAdminSand("admin_sand7");
	public static Block admin_sand8 = new BlockAdminSand("admin_sand8");
	public static Block admin_sand9 = new BlockAdminSand("admin_sand9");
	public static Block admin_stone1 = new BlockAdminStone("admin_stone1");
	public static Block admin_stone2 = new BlockAdminStone("admin_stone2");
	public static Block admin_stone3 = new BlockAdminStone("admin_stone3");
	public static Block admin_stone4 = new BlockAdminStone("admin_stone4");
	public static Block admin_stone5 = new BlockAdminStone("admin_stone5");
	public static Block admin_stone6 = new BlockAdminStone("admin_stone6");
	public static Block admin_stone7 = new BlockAdminStone("admin_stone7");
	public static Block admin_stone8 = new BlockAdminStone("admin_stone8");
	public static Block admin_stone9 = new BlockAdminStone("admin_stone9");
	
	public static Block banking_station = new BlockBankingStation("banking_station");
	
	public static Block campfire_oak = new BlockCampfire("campfire_oak", false);
	public static Block campfire_birch = new BlockCampfire("campfire_birch", false);
	public static Block campfire_spruce = new BlockCampfire("campfire_spruce", false);
	public static Block campfire_jungle = new BlockCampfire("campfire_jungle", false);
	public static Block campfire_acacia = new BlockCampfire("campfire_acacia", false);
	public static Block campfire_dark_oak = new BlockCampfire("campfire_dark_oak", false);
	
	public static Block lit_campfire_oak = new BlockCampfire("lit_campfire_oak", true);
	public static Block lit_campfire_birch = new BlockCampfire("lit_campfire_birch", true);
	public static Block lit_campfire_spruce = new BlockCampfire("lit_campfire_spruce", true);
	public static Block lit_campfire_jungle = new BlockCampfire("lit_campfire_jungle", true);
	public static Block lit_campfire_acacia = new BlockCampfire("lit_campfire_acacia", true);
	public static Block lit_campfire_dark_oak = new BlockCampfire("lit_campfire_dark_oak", true);
	
	public static Block campfire_oak_log = new BlockCampfireLog("campfire_oak_log");
	public static Block campfire_spruce_log = new BlockCampfireLog("campfire_spruce_log");
	public static Block campfire_birch_log = new BlockCampfireLog("campfire_birch_log");
	public static Block campfire_jungle_log = new BlockCampfireLog("campfire_jungle_log");
	public static Block campfire_acacia_log = new BlockCampfireLog("campfire_acacia_log");
	public static Block campfire_dark_oak_log = new BlockCampfireLog("campfire_dark_oak_log");
	
	public static Block candy_cane_block = new BlockCandyCane("candy_cane_block");
	public static Block candy_planks = new BlockSimpleWood("candy_planks");
	public static Block candy_stairs = new BlockCandyStairs("candy_stairs");
	public static Block gingerbread_block = new BlockSimpleCloth("gingerbread_block");
	public static Block gingerbread_cookie_block = new BlockSimpleWood("gingerbread_cookie_block");
	public static Block ice_packed_bricks = new BlockIcePackedBricks("ice_packed_bricks");
		
	public static Block crate_lost_casting_mold = new BlockCrateLostCastingMold("crate_lost_casting_mold");
	
	public static Block emblem_anchor_iron = new BlockEmblemAnchorIron("emblem_anchor_iron");
	public static Block emblem_bell_gold =  new BlockEmblemBellGold("emblem_bell_gold");
	public static Block emblem_bell_iron = new BlockEmblemBellIron("emblem_bell_iron");
	public static Block emblem_creeper_gold = new BlockEmblemCreeperGold("emblem_creeper_gold");
	public static Block emblem_creeper_iron = new BlockEmblemCreeperIron("emblem_creeper_iron");
	public static Block emblem_crosslet_gold = new BlockEmblemCrossletGold("emblem_crosslet_gold");
	public static Block emblem_crosslet_iron = new BlockEmblemCrossletIron("emblem_crosslet_iron");
	public static Block emblem_horseshoe_gold = new BlockEmblemHorseshoeGold("emblem_horseshoe_gold");
	public static Block emblem_horseshoe_iron = new BlockEmblemHorseshoeIron("emblem_horseshoe_iron");
	public static Block emblem_pot = new BlockEmblemPot("emblem_pot");
	public static Block emblem_weather_vane_arrowtop_gold = new BlockEmblemWeatherVaneArrowtopGold("emblem_weather_vane_arrowtop_gold");
	public static Block emblem_weather_vane_arrowtop_iron = new BlockEmblemWeatherVaneArrowtopIron("emblem_weather_vane_arrowtop_iron");
	public static Block emblem_weather_vane_gold = new BlockEmblemWeatherVaneGold("emblem_weather_vane_gold");
	public static Block emblem_weather_vane_iron = new BlockEmblemWeatherVaneIron("emblem_weather_vane_iron");
	
	public static Block glowstone_dust_pile = new BlockGlowstoneDustPile("glowstone_dust_pile");
	public static Block redstone_dust_pile = new BlockRedstoneDustPile("redstone_dust_pile");
	
	public static Block metal_cap_dull_iron = new BlockMetalCapDullIron("metal_cap_dull_iron");
	public static Block metal_cap_dull_gold = new BlockMetalCapDullGold("metal_cap_dull_gold");
	public static Block metal_cap_dull_wrought_iron = new BlockMetalCapDullIron("metal_cap_dull_wrought_iron");
	public static Block metal_cap_sharp_iron = new BlockMetalCapSharpIron("metal_cap_sharp_iron");
	public static Block metal_cap_sharp_gold = new BlockMetalCapSharpGold("metal_cap_sharp_gold");
	public static Block metal_cap_sharp_wrought_iron = new BlockMetalCapSharpIron("metal_cap_sharp_wrought_iron");
	
	public static Block pot_oak_logs = new BlockPotLogs("pot_oak_logs");
	public static Block pot_spruce_logs = new BlockPotLogs("pot_spruce_logs");
	public static Block pot_birch_logs = new BlockPotLogs("pot_birch_logs");
	public static Block pot_jungle_logs = new BlockPotLogs("pot_jungle_logs");
	public static Block pot_acacia_logs = new BlockPotLogs("pot_acacia_logs");
	public static Block pot_dark_oak_logs = new BlockPotLogs("pot_dark_oak_logs");
	
	public static Block sealed_ender_dragon_egg = new BlockSealedEnderDragonEgg("sealed_ender_dragon_egg");
	
	public static Block vase_quartz = new BlockVaseQuartz("vase_quartz");
	
	public static Block treasure_dust_bits = new BlockTreasureDustBits("treasure_dust_bits");
	public static Block treasure_gem_shards = new BlockTreasureGemShards("treasure_gem_shards");
	public static Block treasure_dust_bits_gem_shards = new BlockTreasureDustBitsGemShards("treasure_dust_bits_gem_shards");
	public static Block treasure_old_gold_coin = new BlockTreasureOldGoldCoin("treasure_old_gold_coin");
	public static Block treasure_dust_bits_shards_coin = new BlockTreasureDustBitsShardsCoin("treasure_dust_bits_shards_coin");
	public static Block treasure_dust_bits_shards_coins = new BlockTreasureDustBitsShardsCoins("treasure_dust_bits_shards_coins");
	public static Block treasure_pile_bits_shards_coins = new BlockTreasurePileBitsShardsCoins("treasure_pile_bits_shards_coins");
	public static Block treasure_mound_bits_shards_coins = new BlockTreasureMoundBitsShardsCoins("treasure_mound_bits_shards_coins");
	public static Block treasure_wealth_bits_shards_coins = new BlockTreasureWealthBitsShardsCoins("treasure_wealth_bits_shards_coins");
	public static Block treasure_chalice_gold = new BlockTreasureChaliceGold("treasure_chalice_gold");
	public static Block treasure_ruby_amulet = new BlockTreasureRubyAmulet("treasure_ruby_amulet");
	public static Block treasure_chalice_gold_ruby_amulet = new BlockTreasureChaliceGoldRubyAmulet("treasure_chalice_gold_ruby_amulet");
	public static Block treasure_gold_egg = new BlockTreasureGoldEgg("treasure_gold_egg");
	public static Block treasure_gold_egg_shards = new BlockTreasureGoldEggShards("treasure_gold_egg_shards");
	public static Block treasure_pot_gold = new BlockTreasurePotGold("treasure_pot_gold");
	public static Block treasure_pot_gold_full = new BlockTreasurePotGoldFull("treasure_pot_gold_full");
	
	public static Block well_light_sea_gold = new BlockWellLight("well_light_sea_gold", 0.9375F );
	public static Block well_light_sea_iron = new BlockWellLight("well_light_sea_iron", 0.9375F );
	public static Block well_light_glow_gold = new BlockWellLight("well_light_glow_gold", 0.9375F );
	public static Block well_light_glow_iron = new BlockWellLight("well_light_glow_iron", 0.9375F );
	public static Block well_light_fire_gold = new BlockWellLight("well_light_fire_gold", 0.875F );
	public static Block well_light_fire_iron = new BlockWellLight("well_light_fire_iron", 0.875F );
	public static Block well_light_red_gold = new BlockWellLight("well_light_red_gold", 0.4375F );
	public static Block well_light_red_iron = new BlockWellLight("well_light_red_iron", 0.4375F );
	
	
	
	@Mod.EventBusSubscriber(modid = TyrDrops.MODID)
	public static class RegistrationHandler 
	{
		public static List<Block> TYRDROPBLOCKS = new ArrayList<Block>();
		
		@SubscribeEvent
		public static void register(RegistryEvent.Register<Block> event)
		{
			TYRDROPBLOCKS.add(admin_cobweb1);
			TYRDROPBLOCKS.add(admin_cobweb2);
			TYRDROPBLOCKS.add(admin_cobweb3);
			TYRDROPBLOCKS.add(admin_cobweb4);
			TYRDROPBLOCKS.add(admin_cobweb5);
			TYRDROPBLOCKS.add(admin_cobweb6);
			TYRDROPBLOCKS.add(admin_cobweb7);
			TYRDROPBLOCKS.add(admin_cobweb8);
			TYRDROPBLOCKS.add(admin_cobweb9);
			TYRDROPBLOCKS.add(admin_sand1);
			TYRDROPBLOCKS.add(admin_sand2);
			TYRDROPBLOCKS.add(admin_sand3);
			TYRDROPBLOCKS.add(admin_sand4);
			TYRDROPBLOCKS.add(admin_sand5);
			TYRDROPBLOCKS.add(admin_sand6);
			TYRDROPBLOCKS.add(admin_sand7);
			TYRDROPBLOCKS.add(admin_sand8);
			TYRDROPBLOCKS.add(admin_sand9);
			TYRDROPBLOCKS.add(admin_stone1);
			TYRDROPBLOCKS.add(admin_stone2);
			TYRDROPBLOCKS.add(admin_stone3);
			TYRDROPBLOCKS.add(admin_stone4);
			TYRDROPBLOCKS.add(admin_stone5);
			TYRDROPBLOCKS.add(admin_stone6);
			TYRDROPBLOCKS.add(admin_stone7);
			TYRDROPBLOCKS.add(admin_stone8);
			TYRDROPBLOCKS.add(admin_stone9);
			
			TYRDROPBLOCKS.add(banking_station);

			TYRDROPBLOCKS.add(campfire_oak);
			TYRDROPBLOCKS.add(campfire_birch);
			TYRDROPBLOCKS.add(campfire_spruce);
			TYRDROPBLOCKS.add(campfire_jungle);
			TYRDROPBLOCKS.add(campfire_acacia);
			TYRDROPBLOCKS.add(campfire_dark_oak);
			
			TYRDROPBLOCKS.add(lit_campfire_oak);
			TYRDROPBLOCKS.add(lit_campfire_birch);
			TYRDROPBLOCKS.add(lit_campfire_spruce);
			TYRDROPBLOCKS.add(lit_campfire_jungle);
			TYRDROPBLOCKS.add(lit_campfire_acacia);
			TYRDROPBLOCKS.add(lit_campfire_dark_oak);
			
			TYRDROPBLOCKS.add(campfire_oak_log);
			TYRDROPBLOCKS.add(campfire_spruce_log);
			TYRDROPBLOCKS.add(campfire_birch_log);
			TYRDROPBLOCKS.add(campfire_jungle_log);
			TYRDROPBLOCKS.add(campfire_acacia_log);
			TYRDROPBLOCKS.add(campfire_dark_oak_log);
			
			TYRDROPBLOCKS.add(candy_cane_block);
			TYRDROPBLOCKS.add(candy_planks);
			TYRDROPBLOCKS.add(candy_stairs);
			TYRDROPBLOCKS.add(gingerbread_block);
			TYRDROPBLOCKS.add(gingerbread_cookie_block);
			TYRDROPBLOCKS.add(ice_packed_bricks);
			
			TYRDROPBLOCKS.add(crate_lost_casting_mold);		
			
			TYRDROPBLOCKS.add(emblem_anchor_iron);	
			TYRDROPBLOCKS.add(emblem_bell_gold);	
			TYRDROPBLOCKS.add(emblem_bell_iron);	
			TYRDROPBLOCKS.add(emblem_creeper_gold);	
			TYRDROPBLOCKS.add(emblem_creeper_iron);
			TYRDROPBLOCKS.add(emblem_crosslet_gold);	
			TYRDROPBLOCKS.add(emblem_crosslet_iron);
			TYRDROPBLOCKS.add(emblem_horseshoe_gold);	
			TYRDROPBLOCKS.add(emblem_horseshoe_iron);
			TYRDROPBLOCKS.add(emblem_pot);
			TYRDROPBLOCKS.add(emblem_weather_vane_arrowtop_gold);	
			TYRDROPBLOCKS.add(emblem_weather_vane_arrowtop_iron);
			TYRDROPBLOCKS.add(emblem_weather_vane_gold);	
			TYRDROPBLOCKS.add(emblem_weather_vane_iron);
			
			TYRDROPBLOCKS.add(glowstone_dust_pile);
			TYRDROPBLOCKS.add(redstone_dust_pile);
			
			TYRDROPBLOCKS.add(metal_cap_dull_iron);
			TYRDROPBLOCKS.add(metal_cap_dull_gold);	
			TYRDROPBLOCKS.add(metal_cap_dull_wrought_iron);
			TYRDROPBLOCKS.add(metal_cap_sharp_iron);
			TYRDROPBLOCKS.add(metal_cap_sharp_gold);	
			TYRDROPBLOCKS.add(metal_cap_sharp_wrought_iron);
			
			TYRDROPBLOCKS.add(pot_oak_logs);
			TYRDROPBLOCKS.add(pot_spruce_logs);	
			TYRDROPBLOCKS.add(pot_birch_logs);
			TYRDROPBLOCKS.add(pot_jungle_logs);
			TYRDROPBLOCKS.add(pot_acacia_logs);	
			TYRDROPBLOCKS.add(pot_dark_oak_logs);
			
			TYRDROPBLOCKS.add(sealed_ender_dragon_egg);
			
			TYRDROPBLOCKS.add(vase_quartz);
			
			TYRDROPBLOCKS.add(treasure_dust_bits);
			TYRDROPBLOCKS.add(treasure_gem_shards);
			TYRDROPBLOCKS.add(treasure_dust_bits_gem_shards);
			TYRDROPBLOCKS.add(treasure_old_gold_coin);
			TYRDROPBLOCKS.add(treasure_dust_bits_shards_coin);
			TYRDROPBLOCKS.add(treasure_dust_bits_shards_coins);
			TYRDROPBLOCKS.add(treasure_pile_bits_shards_coins);
			TYRDROPBLOCKS.add(treasure_mound_bits_shards_coins);
			TYRDROPBLOCKS.add(treasure_wealth_bits_shards_coins);
			TYRDROPBLOCKS.add(treasure_chalice_gold);
			TYRDROPBLOCKS.add(treasure_ruby_amulet);
			TYRDROPBLOCKS.add(treasure_chalice_gold_ruby_amulet);
			TYRDROPBLOCKS.add(treasure_gold_egg);
			TYRDROPBLOCKS.add(treasure_gold_egg_shards);
			TYRDROPBLOCKS.add(treasure_pot_gold);
			TYRDROPBLOCKS.add(treasure_pot_gold_full);
			
			TYRDROPBLOCKS.add(well_light_sea_gold);
			TYRDROPBLOCKS.add(well_light_sea_iron);
			TYRDROPBLOCKS.add(well_light_glow_gold);
			TYRDROPBLOCKS.add(well_light_glow_iron);
			TYRDROPBLOCKS.add(well_light_fire_gold);
			TYRDROPBLOCKS.add(well_light_fire_iron);
			TYRDROPBLOCKS.add(well_light_red_gold);
			TYRDROPBLOCKS.add(well_light_red_iron);
			
			
			for(Block block : TYRDROPBLOCKS)
			{
	            event.getRegistry().register(block);
	        }
		}
		
		 @SubscribeEvent
		    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
		    {
		        for(Block block: TYRDROPBLOCKS)
		        {
		            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		        }
		    }
		 
			@SubscribeEvent
			public static void registerModels(ModelRegistryEvent event)
			{			
				for(Block block : TYRDROPBLOCKS)
				{
					ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		        }
			} 
	}
}