package com.tyr.drops;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
{

    @Override
    public void preInit(FMLPreInitializationEvent e) 
    {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) 
    {
        super.init(e);
    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    }
 
}
