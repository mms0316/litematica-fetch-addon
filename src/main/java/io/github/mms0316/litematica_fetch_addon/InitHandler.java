package io.github.mms0316.litematica_fetch_addon;

import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.event.RenderEventHandler;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;
import fi.dy.masa.malilib.interfaces.IRenderer;
import fi.dy.masa.malilib.registry.Registry;
import fi.dy.masa.malilib.util.data.ModInfo;
import io.github.mms0316.litematica_fetch_addon.config.Configs;
import io.github.mms0316.litematica_fetch_addon.event.InputHandler;
import io.github.mms0316.litematica_fetch_addon.event.KeyCallbacks;
import io.github.mms0316.litematica_fetch_addon.event.RenderHandler;
import io.github.mms0316.litematica_fetch_addon.gui.GuiConfigs;
import net.minecraft.client.MinecraftClient;

public class InitHandler implements IInitializationHandler
{
    @Override
    public void registerModHandlers()
    {
        ConfigManager.getInstance().registerConfigHandler(Reference.MOD_ID, new Configs());
        Registry.CONFIG_SCREEN.registerConfigScreenFactory(
                new ModInfo(Reference.MOD_ID, Reference.MOD_NAME, GuiConfigs::new)
        );

        InputEventHandler.getKeybindManager().registerKeybindProvider(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerKeyboardInputHandler(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerMouseInputHandler(InputHandler.getInstance());

        IRenderer renderer = new RenderHandler();
        RenderEventHandler.getInstance().registerWorldPreWeatherRenderer(renderer);

        KeyCallbacks.init(MinecraftClient.getInstance());
    }
}
