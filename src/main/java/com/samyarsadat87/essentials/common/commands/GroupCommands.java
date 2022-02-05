// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials.common.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.samyarsadat87.essentials.Essentials;
import com.samyarsadat87.essentials.common.util.CheckPermissionUtil;
import com.samyarsadat87.essentials.common.util.FileUtils;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TranslationTextComponent;

public class GroupCommands 
{
    public GroupCommands(CommandDispatcher<CommandSource> dispatcher) 
    {
        // ------------ Add group command ------------

        dispatcher.register(Commands.literal("addgroup").then(Commands.argument("Name", MessageArgument.message()).executes((command) -> 
        {
            return addGroup(command.getSource(), MessageArgument.getMessage(command, "Name").getString());
        })));


        // ------------ Delete group command ------------

        String[] files = FileUtils.listDir("mods/Gigawhat-Essentials/groups");
        List<String> groups = new ArrayList<String>();

        for (String file : files)
        {
            groups.add(file.replace(".json", ""));
        }

        final SuggestionProvider<CommandSource> GROUP_SUGGESTIONS = (context, builder) -> ISuggestionProvider.suggest(groups, builder);

        dispatcher.register(Commands.literal("delgroup").then(Commands.argument("Name", MessageArgument.message()).suggests(GROUP_SUGGESTIONS).executes((command) -> 
        {
            return delGroup(command.getSource(), MessageArgument.getMessage(command, "Name").getString());
        })));
    }

    private int addGroup(CommandSource source, String name) throws CommandSyntaxException 
    {   
        if (source.hasPermission(4) && CheckPermissionUtil.checkPerm("fghdfghdfg", source.getPlayerOrException()))
        {
            if (!FileUtils.fileExists("mods/Gigawhat-Essentials/groups/" + name + ".json"))
            {
                Map<String, Object> perms = new HashMap<>();
                
                perms.put("group_display_color", "\u00A7f");
                perms.put("group_display_name", name);
                perms.put("gigawhat_essentials.group.add", false);
                perms.put("gigawhat_essentials.group.delete", false);
                perms.put("gigawhat_essentials.group.edit", false);
                perms.put("gigawhat_essentials.group.give", false);
                perms.put("gigawhat_essentials.group.remove", false);

                if (FileUtils.writeJson(perms, "mods/Gigawhat-Essentials/groups/" + name + ".json")) 
                {
                    ITextComponent message_var = new StringTextComponent(name).withStyle((style) -> { return style.withColor(Essentials.VARIABLE_COLOR); });
                    ITextComponent success_message = new TranslationTextComponent("success.gigawhat_essentials.add_group").withStyle((style) -> { return style.withColor(Essentials.MESSAGE_COLOR); }).append(message_var);
                    ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(success_message);
                    source.sendSuccess(prefix, true);
                    return 1;
                } 
            
                else
                {
                    ITextComponent errror_message = new TranslationTextComponent("error.gigawhat_essentials.unexpected_error").withStyle((style) -> { return style.withColor(Essentials.ERROR_COLOR); });
                    source.sendFailure(errror_message);
                    return -1;
                }
            }

            else
            {
                ITextComponent errror_message = new TranslationTextComponent("error.gigawhat_essentials.already_exists").withStyle((style) -> { return style.withColor(Essentials.ERROR_COLOR); });
                ITextComponent message_var = new StringTextComponent(name).withStyle((style) -> { return style.withColor(Essentials.VARIABLE_COLOR); }).append(errror_message);
                ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(message_var);
                source.sendFailure(prefix);
                return -1;
            }
        }

        else
        {
            ITextComponent errror_message = new TranslationTextComponent("error.gigawhat_essentials.command_no_permission").withStyle((style) -> { return style.withColor(Essentials.ERROR_COLOR); });
            ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(errror_message);
            source.sendFailure(prefix);
            return -1;
        }
    }

    private int delGroup(CommandSource source, String name) throws CommandSyntaxException 
    {     
        if (source.hasPermission(4))
        {
            if (FileUtils.fileExists("mods/Gigawhat-Essentials/groups/" + name + ".json"))
            {      
                if (FileUtils.deleteFile("mods/Gigawhat-Essentials/groups/" + name + ".json"))
                {
                    ITextComponent message_var = new StringTextComponent(name).withStyle((style) -> { return style.withColor(Essentials.VARIABLE_COLOR); });
                    ITextComponent success_message = new TranslationTextComponent("success.gigawhat_essentials.del_group").withStyle((style) -> { return style.withColor(Essentials.MESSAGE_COLOR); }).append(message_var);
                    ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(success_message);
                    source.sendSuccess(prefix, true);
                    return 1;
                }
                
                else
                {
                    ITextComponent errror_message = new TranslationTextComponent("error.gigawhat_essentials.unexpected_error").withStyle((style) -> { return style.withColor(Essentials.ERROR_COLOR); });
                    ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(errror_message);
                    source.sendFailure(prefix);
                    return -1;
                }
            }

            else
            {
                ITextComponent error_message = new TranslationTextComponent("error.gigawhat_essentials.does_not_exist").withStyle((style) -> { return style.withColor(Essentials.ERROR_COLOR); });
                ITextComponent message_var = new StringTextComponent(name).withStyle((style) -> { return style.withColor(Essentials.VARIABLE_COLOR); }).append(error_message);
                ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(message_var);
                source.sendFailure(prefix);
                return -1;
            }
        }

        else
        {
            ITextComponent errror_message = new TranslationTextComponent("error.gigawhat_essentials.command_no_permission").withStyle((style) -> { return style.withColor(Essentials.ERROR_COLOR); });
            ITextComponent prefix = TextComponentUtils.wrapInSquareBrackets(new StringTextComponent(Essentials.PREFIX).withStyle((style) -> { return style.withColor(Essentials.PREFIX_COLOR); })).append(" ").append(errror_message);
            source.sendFailure(prefix);
            return -1;
        }
    }
}