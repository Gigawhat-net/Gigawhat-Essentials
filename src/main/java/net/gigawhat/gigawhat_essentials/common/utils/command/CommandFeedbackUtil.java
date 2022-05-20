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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * For further inquiries you can contact the Gigawhat Programming Team via e-mail:
 * contact.gpt@gigawhat.net
 */

package net.gigawhat.gigawhat_essentials.common.utils.command;

import net.gigawhat.gigawhat_essentials.Essentials;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

public class CommandFeedbackUtil 
{
    public static final String PREFIX = "\u00A77[" + Essentials.PREFIX + "\u00A7r] ";


    // -------------------------------- SUCCESS --------------------------------

    public static void success(CommandSourceStack source, String ttc)
    {
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  
    
    public static void success(CommandSourceStack source, String ttc, String var1)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.MESSAGE_COLOR);
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void success(CommandSourceStack source, String ttc, String var1, String var2)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.MESSAGE_COLOR);
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void success(CommandSourceStack source, String ttc, String var1, String var2, String var3)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.MESSAGE_COLOR);
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void success(CommandSourceStack source, String ttc, String var1, String var2, String var3, String var4)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&4", Essentials.VARIABLE_COLOR + var4 + Essentials.MESSAGE_COLOR);
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void success(CommandSourceStack source, String ttc, String var1, String var2, String var3, String var4, String var5)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&4", Essentials.VARIABLE_COLOR + var4 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&5", Essentials.VARIABLE_COLOR + var5 + Essentials.MESSAGE_COLOR);
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void success(CommandSourceStack source, String ttc, String var1, String var2, String var3, String var4, String var5, String var6)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&4", Essentials.VARIABLE_COLOR + var4 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&5", Essentials.VARIABLE_COLOR + var5 + Essentials.MESSAGE_COLOR);
        ttc = ttc.replace("&6", Essentials.VARIABLE_COLOR + var6 + Essentials.MESSAGE_COLOR);
        ttc = PREFIX + Essentials.MESSAGE_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    } 
    
    // -------------------------------- ERROR --------------------------------
    
    public static void error(CommandSourceStack source, String ttc)
    {
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  
    
    public static void error(CommandSourceStack source, String ttc, String var1)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.ERROR_COLOR);
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void error(CommandSourceStack source, String ttc, String var1, String var2)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.ERROR_COLOR);
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void error(CommandSourceStack source, String ttc, String var1, String var2, String var3)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.ERROR_COLOR);
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void error(CommandSourceStack source, String ttc, String var1, String var2, String var3, String var4)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&4", Essentials.VARIABLE_COLOR + var4 + Essentials.ERROR_COLOR);
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void error(CommandSourceStack source, String ttc, String var1, String var2, String var3, String var4, String var5)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&4", Essentials.VARIABLE_COLOR + var4 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&5", Essentials.VARIABLE_COLOR + var5 + Essentials.ERROR_COLOR);
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    }  

    public static void error(CommandSourceStack source, String ttc, String var1, String var2, String var3, String var4, String var5, String var6)
    {
        ttc = ttc.replace("&1", Essentials.VARIABLE_COLOR + var1 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&2", Essentials.VARIABLE_COLOR + var2 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&3", Essentials.VARIABLE_COLOR + var3 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&4", Essentials.VARIABLE_COLOR + var4 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&5", Essentials.VARIABLE_COLOR + var5 + Essentials.ERROR_COLOR);
        ttc = ttc.replace("&6", Essentials.VARIABLE_COLOR + var6 + Essentials.ERROR_COLOR);
        ttc = PREFIX + Essentials.ERROR_COLOR + ttc;
        source.sendSuccess(new TextComponent(ttc), true);
    } 
}