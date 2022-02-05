// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials.common.events;

import com.samyarsadat87.essentials.Essentials;
import com.samyarsadat87.essentials.common.commands.GroupCommands;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber(modid = Essentials.MOD_ID)
public class EventInit 
{
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) 
    {
        Essentials.LOGGER.info("Registering commands.");

        // new SetHomeCommand(event.getDispatcher());
        // new ReturnHomeCommand(event.getDispatcher());
        new GroupCommands(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

        Essentials.LOGGER.info("Commands have been registered.");
    }
}