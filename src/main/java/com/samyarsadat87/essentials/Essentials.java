// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials;

import com.samyarsadat87.essentials.common.util.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Essentials.MOD_ID)
//@OnlyIn(Dist.DEDICATED_SERVER)
public class Essentials 
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gigawhat_essentials";

    public static final String PREFIX = "GMU";
    public static final TextFormatting PREFIX_COLOR = TextFormatting.LIGHT_PURPLE;

    public static final TextFormatting MESSAGE_COLOR = TextFormatting.GOLD;
    public static final TextFormatting ERROR_COLOR = TextFormatting.RED;
    public static final TextFormatting VARIABLE_COLOR = TextFormatting.DARK_RED;

    public Essentials()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.info("Gigawhat Server Essentials Mod Loading...");
        
        bus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("Init stage complete.");
    }

    private void directory_init()
    {
        if (!FileUtils.dirExists("mods/Gigawhat-Essentials/groups"))
        {
            LOGGER.warn("Groups directory does not exist!");
            LOGGER.info("Creating groups directory ...");
            
            if(FileUtils.makeDirs("mods/Gigawhat-Essentials/groups"))
            {
                LOGGER.info("Successfully created groups directory!");
            }
            
            else
            {
                LOGGER.fatal("FAILED TO CREATE GROUPS DIRECTORY!");
            }
        }

        else
        {
            LOGGER.info("Groups directory is present.");
        }

        if (!FileUtils.dirExists("mods/Gigawhat-Essentials/warps"))
        {
            LOGGER.warn("Warps directory does not exist!");
            LOGGER.info("Creating warps directory ...");
            
            if(FileUtils.makeDirs("mods/Gigawhat-Essentials/warps"))
            {
                LOGGER.info("Successfully created warps directory!");
            }
            
            else
            {
                LOGGER.fatal("FAILED TO CREATE WARPS DIRECTORY!");
            }
        }

        else
        {
            LOGGER.info("Warps directory is present.");
        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}