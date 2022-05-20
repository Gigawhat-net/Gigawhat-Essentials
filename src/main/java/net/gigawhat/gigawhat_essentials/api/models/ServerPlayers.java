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

package net.gigawhat.gigawhat_essentials.api.models;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;

public class ServerPlayers
{
    public ServerPlayer serverPlayer;
    public String lang;
    public String nick;
    public String group;
    public String lastSeen;
    public int balance;
    public boolean isMuted;
    public boolean isAFK;
    public boolean acceptMessages;
    public boolean acceptTeleport;
    public boolean isInvis;
    public boolean canFly;
    public BlockPos logoutPos;
    public BlockPos[] homePos;

    public ServerPlayers(ServerPlayer serverPlayer, String lang, String nick, String group, String lastSeen, int balance, boolean isMuted, boolean isAFK, boolean acceptMessages, boolean acceptTeleport, boolean isInvis, boolean canFly, BlockPos logoutPos, BlockPos[] homePos) 
    {
        this.serverPlayer = serverPlayer;
        this.lang = lang;
        this.nick = nick;
        this.group = group;
        this.lastSeen = lastSeen;
        this.balance = balance;
        this.isMuted = isMuted;
        this.isAFK = isAFK;
        this.acceptMessages = acceptMessages;
        this.acceptTeleport = acceptTeleport;
        this.isInvis = isInvis;
        this.canFly = canFly;
        this.logoutPos = logoutPos;
        this.homePos = homePos;
    }

    // -------------- Getters & Setters --------------
    
    public ServerPlayer getServerPlayer() 
    {
        return this.serverPlayer;
    }

    public void setServerPlayer(ServerPlayer serverPlayer) 
    {
        this.serverPlayer = serverPlayer;
    }

    public String getLang() 
    {
        return this.lang;
    }

    public void setLang(String lang) 
    {
        this.lang = lang;
    }

    public String getNick() 
    {
        return this.nick;
    }

    public void setNick(String nick) 
    {
        this.nick = nick;
    }

    public String getGroup() 
    {
        return this.group;
    }

    public void setGroup(String group) 
    {
        this.group = group;
    }

    public String getLastSeen() 
    {
        return this.lastSeen;
    }

    public void setLastSeen(String lastSeen) 
    {
        this.lastSeen = lastSeen;
    }

    public int getBalance() 
    {
        return this.balance;
    }

    public void setBalance(int balance) 
    {
        this.balance = balance;
    }

    public boolean isMuted() 
    {
        return this.isMuted;
    }

    public boolean getIsMuted() 
    {
        return this.isMuted;
    }

    public void setIsMuted(boolean isMuted) 
    {
        this.isMuted = isMuted;
    }

    public boolean isAFK() 
    {
        return this.isAFK;
    }

    public boolean getIsAFK() 
    {
        return this.isAFK;
    }

    public void setIsAFK(boolean isAFK) 
    {
        this.isAFK = isAFK;
    }

    public boolean isAcceptMessages() 
    {
        return this.acceptMessages;
    }

    public boolean getAcceptMessages() 
    {
        return this.acceptMessages;
    }

    public void setAcceptMessages(boolean acceptMessages) 
    {
        this.acceptMessages = acceptMessages;
    }

    public boolean isAcceptTeleport() 
    {
        return this.acceptTeleport;
    }

    public boolean getAcceptTeleport() 
    {
        return this.acceptTeleport;
    }

    public void setAcceptTeleport(boolean acceptTeleport) 
    {
        this.acceptTeleport = acceptTeleport;
    }

    public boolean isInvis() 
    {
        return this.isInvis;
    }

    public boolean getIsInvis() 
    {
        return this.isInvis;
    }

    public void setIsInvis(boolean isInvis) 
    {
        this.isInvis = isInvis;
    }

    public boolean canFly() 
    {
        return this.canFly;
    }

    public boolean getCanFly() 
    {
        return this.canFly;
    }

    public void setCanFly(boolean canFly) 
    {
        this.canFly = canFly;
    }

    public BlockPos getLogoutPos() 
    {
        return this.logoutPos;
    }

    public void setLogoutPos(BlockPos logoutPos) 
    {
        this.logoutPos = logoutPos;
    }

    public BlockPos[] getHomePos() 
    {
        return this.homePos;
    }

    public void setHomePos(BlockPos[] homePos) 
    {
        this.homePos = homePos;
    }
}