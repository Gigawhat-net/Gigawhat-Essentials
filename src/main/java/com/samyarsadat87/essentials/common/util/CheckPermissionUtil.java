package com.samyarsadat87.essentials.common.util;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.samyarsadat87.essentials.Essentials;

import net.minecraft.entity.player.ServerPlayerEntity;

public class CheckPermissionUtil 
{
    public static boolean checkPerm(String permission, ServerPlayerEntity player)
    {
        String playerGroup = player.getPersistentData().getString(Essentials.MOD_ID + ":group");
        Essentials.LOGGER.info("PLAYER GROUP DATA : " + playerGroup);

        if (!(playerGroup == ""))
        {
            try 
            {
                Reader reader = Files.newBufferedReader(Paths.get("mods/Gigawhat-Essentials/groups/" + playerGroup + ".json"));
                JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
            
                System.out.println(parser.get("id").getAsLong());
            
                reader.close();
            } 
            
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }

            return false;
        }

        else 
        {
            File file = new File("mods/Gigawhat-Essentials/groups/" + "Player" + ".json");

            if (file.exists() && file.isFile())
            {
                player.getPersistentData().putString(Essentials.MOD_ID + ":group", new String("Player"));
                Essentials.LOGGER.info("\u00A7fPlayer " + player.getName().getString() + " has no group assigned! Assigned default group " + "Player");



                return false;
            }

            else
            {
                Essentials.LOGGER.info("Player " + player.getName() + " has no group assigned and default group " + "Player" + " does not exist!");
                Essentials.LOGGER.warn("Creating default group with no permissions. Please configure " + "Player" + " groups permissions!");

                //Essentials getClass = new Essentials();

                //FileUtils.copyFileFromJar(getClass.getClass().getResourceAsStream("files/default_group_no_permission.json"), "mods/Gigawhat-Essentials/groups/Player.json");

                return false;
            }
        }
    }
}