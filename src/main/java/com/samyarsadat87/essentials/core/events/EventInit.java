// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials.core.events;

import com.samyarsadat87.essentials.Essentials;
import com.samyarsadat87.essentials.core.commands.ReturnHomeCommand;
import com.samyarsadat87.essentials.core.commands.SetHomeCommand;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Essentials.MOD_ID)
public class EventInit 
{
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) 
    {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) 
    {
        if(!event.getOriginal().level.isClientSide()) 
        {
            event.getPlayer().getPersistentData().putIntArray(Essentials.MOD_ID + "homepos",
            event.getOriginal().getPersistentData().getIntArray(Essentials.MOD_ID + "homepos"));

            // event.getPlayer().getPersistentData().putString(Essentials.MOD_ID + "homedim",
            // event.getOriginal().getPersistentData().getString(Essentials.MOD_ID + "homedim"));
        }
    }
}