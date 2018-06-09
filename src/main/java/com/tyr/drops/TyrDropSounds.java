package com.tyr.drops;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TyrDropSounds 
{
	//Declare Sounds
	public static final SoundEvent gold_bell = new SoundEvent(new ResourceLocation(TyrDrops.MODID, "gold_bell")).setRegistryName("gold_bell");
	public static final SoundEvent iron_bell = new SoundEvent(new ResourceLocation(TyrDrops.MODID, "iron_bell")).setRegistryName("iron_bell");
	public static final SoundEvent sealed_mold_open = new SoundEvent(new ResourceLocation(TyrDrops.MODID, "sealed_mold_open")).setRegistryName("sealed_mold_open");
	public static final SoundEvent crate_break_open = new SoundEvent(new ResourceLocation(TyrDrops.MODID, "crate_break_open")).setRegistryName("crate_break_open");
	public static final SoundEvent coins_sliding = new SoundEvent(new ResourceLocation(TyrDrops.MODID, "coins_sliding")).setRegistryName("coins_sliding");
	
	@SubscribeEvent
	public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event)
	{
		event.getRegistry().registerAll
		(
				gold_bell,
				iron_bell,
				sealed_mold_open,
				crate_break_open,
				coins_sliding
		);
	}
	

}
