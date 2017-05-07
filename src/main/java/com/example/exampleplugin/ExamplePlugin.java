package com.example.exampleplugin;

import alexanders.api.gpprocessor.annotation.AutoPopulate;
import alexanders.api.gpprocessor.annotation.EventHandler;
import alexanders.api.gpprocessor.annotation.Plugin;
import alexanders.api.gpprocessor.event.IPCEvent;
import alexanders.api.gpprocessor.event.InitializationEvent;
import alexanders.api.gpprocessor.event.PostInitializationEvent;
import alexanders.api.gpprocessor.event.PreInitializationEvent;
import alexanders.api.gpprocessor.plugin.PluginContainer;

import java.util.logging.Level;
import java.util.logging.Logger;

@Plugin (ID = "exampleplugin", name = "ExamplePlugin", version = "0.1", author = "AUTHOR", description = "An example plugin")
public class ExamplePlugin
{
    @AutoPopulate (pluginID = "exampleplugin")
    public static ExamplePlugin instance;

    @AutoPopulate (pluginID = "exampleplugin")
    public static PluginContainer container;

    private Logger logger;

    @EventHandler
    public void preInit(PreInitializationEvent event)
    {
        logger = event.getLogger();
        logger.log(Level.INFO, "ExamplePlugin initializing Step 1");
    }

    @EventHandler
    public void init(InitializationEvent event)
    {
        logger.log(Level.INFO, "ExamplePlugin Initializing Step 2");
    }

    @EventHandler
    public void postInit(PostInitializationEvent event)
    {
        logger.log(Level.INFO, "ExamplePlugin Initializing Step 3");
    }

    @EventHandler
    public void ipcMessageReceived(IPCEvent ipcEvent)
    {
        logger.log(Level.INFO, "ExamplePlugin received message: " + ipcEvent.getMessage().getStringValue() + " from: " + ipcEvent.getSender());
    }
}
