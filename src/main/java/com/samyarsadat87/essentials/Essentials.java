// Copyright 2021 Samyar Sadat Akhavi
// Written by Samyar Sadat Akhavi
// Gigamod, a mod by Gigawhat

package com.samyarsadat87.gigamod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.samyarsadat87.gigamod.common.entities.EntityTypeInit;
import com.samyarsadat87.gigamod.common.entities.render.GigalandProtectorRenderer;
//import com.samyarsadat87.gigamod.common.entities.EntityTypeInit;
//import com.samyarsadat87.gigamod.common.entities.custom.GigalandProtectorEntity;
import com.samyarsadat87.gigamod.core.init.BlockInit;
import com.samyarsadat87.gigamod.core.init.ItemInit;
import com.samyarsadat87.gigamod.world.biome.BiomeInit;
import com.samyarsadat87.gigamod.world.carver.CarverInit;
import com.samyarsadat87.gigamod.world.gen.OreGeneration;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
// import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Gigamod.MOD_ID)
public class Gigamod 
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gigawhat_gigamod";

    public Gigamod() 
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.info("Pre-init stage");

        EntityTypeInit.register(bus);
        ItemInit.register(bus);
        BlockInit.register(bus);
        BiomeInit.register(bus);
        CarverInit.register(bus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        bus.addListener(this::doClientStuff);
        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) 
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        event.enqueueWork(() -> 
        {
            RenderTypeLookup.setRenderLayer(BlockInit.BLOCK_MODEL_TEST.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockInit.GIGALAND_TELEPORTER_BLOCK.get(), RenderType.cutout());
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.GIGALAND_PROTECTOR.get(), GigalandProtectorRenderer::new);
    }

    public static Logger getLOGGER() 
    {
        return LOGGER;
    }
}