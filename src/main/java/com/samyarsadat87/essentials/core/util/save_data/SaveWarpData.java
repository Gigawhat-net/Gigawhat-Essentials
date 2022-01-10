// Copyright 2022 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigawhat Essentials, a mod by Gigawhat

package com.samyarsadat87.essentials.core.util.save_data;

/*
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.samyarsadat87.essentials.Essentials;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;

public class SaveWarpData extends WorldSavedData
{
    public static final String NAME = Essentials.MOD_ID + "_warp_data";

    private final List<WarpDataStorageObject> DATA = new ArrayList<>();

    public SaveWarpData(String name) 
    {
        super(name);
    }

    public SaveWarpData() 
    {
        this(NAME);
    }

    @Override
    public void load(CompoundNBT nbt)
    {
        if(!DATA.isEmpty())
        {
            return;
        }

        CompoundNBT saveData = nbt.getCompound("savedata");

        for(int i = 0; saveData.contains("savedata" + i); i++)
        {
            DATA.add(WarpDataStorageObject.serialize(saveData.getCompound("data" + i)));
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) 
    {
        CompoundNBT saveData = new CompoundNBT();

        for(ListIterator<WarpDataStorageObject> iterator = DATA.listIterator(); iterator.hasNext(); )
        {
            saveData.put("data" + iterator.nextIndex(), iterator.next().deserialize());
        }

        nbt.put("savedata", saveData);

        return nbt;
    }

    public static void putData(WarpDataStorageObject object, ServerWorld world)
    {
        SaveWarpData data = world.getDataStorage().computeIfAbsent(SaveWarpData::new, SaveWarpData.NAME);

        data.DATA.add(object);
        data.setDirty();
    }

    public static void putData(int x_pos, int y_pos, int z_pos, String name, ResourceLocation dimension, ServerWorld world)
    {
        putData(new WarpDataStorageObject(x_pos, y_pos, z_pos, name, dimension), world);
    }

    static class WarpDataStorageObject
    {
        private final int x_pos;
        private final int y_pos;
        private final int z_pos;
        private final String name;
        private final ResourceLocation dimension;

        WarpDataStorageObject(int x_pos, int y_pos, int z_pos, String name, ResourceLocation dimension)
        {
            this.x_pos = x_pos;
            this.y_pos = y_pos;
            this.z_pos = z_pos;
            this.name = name;
            this.dimension = dimension;
        }

        public CompoundNBT deserialize()
        {
            CompoundNBT nbt = new CompoundNBT();

            nbt.putInt("x_pos", x_pos);
            nbt.putInt("y_pos", y_pos);
            nbt.putInt("z_pos", z_pos);
            nbt.putString("name", name);
            nbt.putString("dimension", dimension.toString());

            return nbt;
        }

        public static WarpDataStorageObject serialize(CompoundNBT nbt)
        {
            return new WarpDataStorageObject(nbt.getInt("x_pos"), nbt.getInt("y_pos"), nbt.getInt("z_pos"), nbt.getString("name"), ResourceLocation.of(nbt.getString("dimension"), ':'));
        }
    }
}
*/