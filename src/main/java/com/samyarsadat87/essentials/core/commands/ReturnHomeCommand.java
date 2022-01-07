// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.samyarsadat87.essentials.Essentials;

import net.minecraft.client.world.DimensionRenderInfo.Overworld;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ReturnHomeCommand 
{
    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher) 
    {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes((command) ->
        {
            return returnHome(command.getSource(), command.getSource().getServer());
        })));
    }

    private int returnHome(CommandSource source, MinecraftServer server) throws CommandSyntaxException 
    {
        ServerPlayerEntity player = source.getPlayerOrException();
        boolean hasHomepos = player.getPersistentData().getIntArray(Essentials.MOD_ID + "homepos").length != 0;

        if (hasHomepos) 
        {
            float pitch = player.yHeadRot;
            float yaw = player.xRot;

            int[] playerPos = player.getPersistentData().getIntArray(Essentials.MOD_ID + "homepos");
            // String playerDim = player.getPersistentData().getString(Essentials.MOD_ID + "homedim");

            ServerWorld dimension = server.getLevel(World.OVERWORLD);
            player.teleportTo(dimension, playerPos[0], playerPos[1], playerPos[2], pitch, yaw);

            source.sendSuccess(new StringTextComponent(Essentials.MESSAGE_HEAD + "Teleported to home!"), true);
            return 1;
        } 
        
        else 
        {
            source.sendFailure(new StringTextComponent(Essentials.MESSAGE_HEAD + "No Home Position has been set!"));
            return -1;
        }
    }
}