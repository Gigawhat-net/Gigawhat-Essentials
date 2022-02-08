/*
 * Gigawhat Essentials, A mod based on the EssentialsX plugin suite.
 * Copyright (C) 2021-2022 Gigawhat Programming Team.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 * 
 * For further inquiries you can contact the Gigawhat Programming Team via e-mail:
 * contact.gpt@gigawhat.net
 */

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