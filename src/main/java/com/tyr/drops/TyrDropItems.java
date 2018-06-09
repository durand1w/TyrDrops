package com.tyr.drops;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TyrDropItems 
{
	public static CreativeTabs tabTyrDrops = new TyrDropsTab("TyrDrops");
	
	//Declare Items
	public static Item tyr_emerald_coin = new ItemTyrEmeraldCoin("tyr_emerald_coin");
	public static Item tyr_ruby_coin = new ItemTyrRubyCoin("tyr_ruby_coin");
	public static Item tyr_sapphire_coin = new ItemTyrSapphireCoin("tyr_sapphire_coin");
	public static Item tyr_diamond_coin = new ItemTyrDiamondCoin("tyr_diamond_coin");
	public static Item key_bank = new ItemKeyBank("key_bank");
	public static Item sealant = new ItemSimple("sealant");
	public static Item enderian_token = new ItemSimple("enderian_token");
	public static Item spawner_fragment = new ItemSimple("spawner_fragment");
	public static Item netherian_token = new ItemSimple("netherian_token");
	public static Item oceanic_token = new ItemSimple("oceanic_token");
	public static Item treasure_bag = new ItemTreasureBag("treasure_bag");
	public static Item easter_egg1 = new ItemEasterEgg1("easter_egg1");
	public static Item easter_egg2 = new ItemEasterEgg2("easter_egg2");
	public static Item easter_egg3 = new ItemEasterEgg3("easter_egg3");
	public static Item easter_egg4 = new ItemEasterEgg4("easter_egg4");
	public static Item easter_egg5 = new ItemEasterEgg5("easter_egg5");
	public static Item easter_egg6 = new ItemEasterEgg6("easter_egg6");
	public static Item easter_egg_gold = new ItemEasterEggGold("easter_egg_gold");
	public static Item gingerbread = new ItemSimpleFood("gingerbread",2, 0.50F, false );
	public static Item candy_cane = new ItemSimpleFood("candy_cane",1, 0.20F, false );
	public static Item food_caramel_candy = new ItemSimpleFood("food_caramel_candy",1, 0.15F, false );
	public static Item food_licorice_red = new ItemSimpleFood("food_licorice_red",1, 0.12F, false );
	public static Item food_lolipop_grape = new ItemSimpleFood("food_lolipop_grape",1, 0.10F, false );
	public static Item food_peanut_butter_square = new ItemSimpleFood("food_peanut_butter_square",1, 0.25F, false );
	public static Item barter_fairy_festival = new ItemSimple("barter_fairy_festival");
	
	@Mod.EventBusSubscriber(modid = TyrDrops.MODID)
	public static class RegistrationHandler 
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			final IForgeRegistry<Item> registry = event.getRegistry();
			registry.register(tyr_emerald_coin);
			registry.register(tyr_ruby_coin);
			registry.register(tyr_sapphire_coin);
			registry.register(tyr_diamond_coin);
			registry.register(key_bank);
			registry.register(sealant);
			registry.register(enderian_token);
			registry.register(spawner_fragment);
			registry.register(netherian_token);
			registry.register(oceanic_token);
			registry.register(treasure_bag);
			registry.register(easter_egg1);
			registry.register(easter_egg2);
			registry.register(easter_egg3);
			registry.register(easter_egg4);
			registry.register(easter_egg5);
			registry.register(easter_egg6);
			registry.register(easter_egg_gold);
			registry.register(gingerbread);
			registry.register(candy_cane);
			registry.register(food_caramel_candy);
			registry.register(food_licorice_red);
			registry.register(food_lolipop_grape);
			registry.register(food_peanut_butter_square);
			registry.register(barter_fairy_festival);
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event)
		{
			ModelLoader.setCustomModelResourceLocation(tyr_emerald_coin, 0, new ModelResourceLocation(tyr_emerald_coin.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(tyr_ruby_coin, 0, new ModelResourceLocation(tyr_ruby_coin.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(tyr_sapphire_coin, 0, new ModelResourceLocation(tyr_sapphire_coin.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(tyr_diamond_coin, 0, new ModelResourceLocation(tyr_diamond_coin.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(key_bank, 0, new ModelResourceLocation(key_bank.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(sealant, 0, new ModelResourceLocation(sealant.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(enderian_token, 0, new ModelResourceLocation(enderian_token.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(spawner_fragment, 0, new ModelResourceLocation(spawner_fragment.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(netherian_token, 0, new ModelResourceLocation(netherian_token.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(oceanic_token, 0, new ModelResourceLocation(oceanic_token.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(treasure_bag, 0, new ModelResourceLocation(treasure_bag.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg1, 0, new ModelResourceLocation(easter_egg1.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg2, 0, new ModelResourceLocation(easter_egg2.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg3, 0, new ModelResourceLocation(easter_egg3.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg4, 0, new ModelResourceLocation(easter_egg4.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg5, 0, new ModelResourceLocation(easter_egg5.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg6, 0, new ModelResourceLocation(easter_egg6.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(easter_egg_gold, 0, new ModelResourceLocation(easter_egg_gold.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(gingerbread, 0, new ModelResourceLocation(gingerbread.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(candy_cane, 0, new ModelResourceLocation(candy_cane.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(food_caramel_candy, 0, new ModelResourceLocation(food_caramel_candy.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(food_licorice_red, 0, new ModelResourceLocation(food_licorice_red.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(food_lolipop_grape, 0, new ModelResourceLocation(food_lolipop_grape.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(food_peanut_butter_square, 0, new ModelResourceLocation(food_peanut_butter_square.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(barter_fairy_festival, 0, new ModelResourceLocation(barter_fairy_festival.getRegistryName(), "inventory"));
		}
	}
}