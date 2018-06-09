package com.tyr.drops;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=TyrDrops.MODID, version = TyrDrops.VERSION, dependencies = "required-after:tyrbuilders")
public class TyrDrops 
{
    public static final String MODID = "tyrdrops";
    public static final String VERSION = "1.12.2-1.0.1";
    
    @SidedProxy(clientSide="com.tyr.drops.ClientProxy", serverSide="com.tyr.drops.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent e)
    {   	
    	this.proxy.preInit(e);
    }  	

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	this.proxy.init(e);
    }
}


