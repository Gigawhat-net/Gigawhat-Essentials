// Copyright 2021 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package com.samyarsadat87.essentials;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Essentials.MOD_ID)
public class Essentials 
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gigawhat_essentials";

    public Essentials() 
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.info("Pre-init stage");

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) 
    {

    }

    public static Logger getLOGGER() 
    {
        return LOGGER;
    }
}