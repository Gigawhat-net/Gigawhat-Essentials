package com.samyarsadat87.essentials.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samyarsadat87.essentials.Essentials;

public class FileUtils 
{
    public static boolean deleteFile(String filePath)
    {
        File file = new File(filePath);

        if (file.delete())
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public static boolean renameFile(String filePath, String newPath)
    {
        File file = new File(filePath);
        File new_file = new File(newPath);

        if (file.renameTo(new_file))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public static boolean copyFileFromJar(InputStream source, String dest)
    {
        boolean success = true;

        try 
        {
            Files.copy(source, Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
        } 
        
        catch (IOException ex) 
        {
            ex.printStackTrace();
            Essentials.LOGGER.warn(ex);
            success = false;
        }

        return success;
    }

    public static boolean fileExists(String filePath)
    {
        File file = new File(filePath);

        if (file.exists() && file.isFile())
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public static boolean dirExists(String dirPath)
    {
        if (Files.isDirectory(Paths.get(dirPath)))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public static String[] listDir(String dirPath)
    {
        File directory = new File(dirPath);
        return directory.list();
    }

    public static boolean makeDirs(String dirPath)
    {
        File dirs = new File(dirPath);
        boolean dirs_success = dirs.mkdirs();
        
        if (dirs_success)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }

    public static boolean writeJson(Map<String, Object> map, String filePath)
    {
        boolean success = true;

        try
        {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            writer.write(gson.toJson(map));
            writer.close();
        }

        catch (IOException ex) 
        {
            ex.printStackTrace();
            Essentials.LOGGER.warn(ex);
            success = false;
        }

        return success;
    }
}