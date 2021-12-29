// Copyright 2021 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials;

import java.lang.reflect.AnnotatedWildcardType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.inventory.Inventory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.SharedConstants;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.world.WorldEvent.Save;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.samyarsadat87.essentials.world_data.SaveWarpData;

@Mod(Essentials.MOD_ID)
@OnlyIn(Dist.DEDICATED_SERVER)
public class Essentials 
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gigawhat_essentials";

    public Essentials() 
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.info("Gigawhat Server Essentials Mod Loading...");
        LOGGER.info("Pre-init stage");

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("Attemting to save example warp...");

        LOGGER.info("Warp saved.");

        ListNBT listnbt = new ListNBT();
        CompoundNBT compoundnbt = new CompoundNBT();
        SaveWarpData wp = new SaveWarpData();

        compoundnbt.
        compoundnbt.put("warpcoords", wp.save(new CompoundNBT()));
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    public static Logger getLOGGER() 
    {
        return LOGGER;
    }  
}