// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials.core.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.samyarsadat87.essentials.Essentials;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SetHomeCommand 
{
    public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher) 
    {
        dispatcher.register(Commands.literal("home").then(Commands.literal("set").executes((command) -> 
        {
            return setHome(command.getSource());
        })));
    }

    private int setHome(CommandSource source) throws CommandSyntaxException 
    {
        ServerPlayerEntity player = source.getPlayerOrException();
        BlockPos playerPos = player.blockPosition();
        ResourceLocation playerDim = player.getLevel().dimension().location();

        if(playerDim == World.OVERWORLD.location())
        {
            String pos = "\u00A7a" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + " (" + playerDim.getPath() + ")";

            player.getPersistentData().putIntArray(Essentials.MOD_ID + "homepos", new int[] { playerPos.getX(), playerPos.getY(), playerPos.getZ() });
            // player.getPersistentData().putString(Essentials.MOD_ID + "homedim", new String(playerDim.dimension().location().toString()));
    
            source.sendSuccess(new StringTextComponent(Essentials.MESSAGE_HEAD + "Set Home at " + pos), true);
            return 1;
        }

        else
        {
            source.sendFailure(new StringTextComponent(Essentials.MESSAGE_HEAD + "Home position can only be set in the \u00A7aOverworld\u00A7r!"));
            source.sendFailure(new StringTextComponent(Essentials.MESSAGE_HEAD + "You are currently in : \u00A7a" + playerDim.getPath().toString()));
            return -1;
        }
    }
}