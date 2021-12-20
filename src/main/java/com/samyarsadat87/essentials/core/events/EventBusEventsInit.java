package com.samyarsadat87.gigamod.core.events;

import com.samyarsadat87.gigamod.common.entities.EntityTypeInit;
import com.samyarsadat87.gigamod.common.entities.custom.GigalandProtectorEntity;
import com.samyarsadat87.gigamod.common.items.Spawn_Egg_Item;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventBusEventsInit 
{
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) 
    {
        event.put(EntityTypeInit.GIGALAND_PROTECTOR.get(), GigalandProtectorEntity.setCustomAttributes().build());
    }
    
    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) 
    {
        Spawn_Egg_Item.initSpawnEggs();
    }    
}