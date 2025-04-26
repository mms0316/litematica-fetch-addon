package io.github.mms0316.litematica_fetch_addon.event;

import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;
import io.github.mms0316.litematica_fetch_addon.Reference;
import io.github.mms0316.litematica_fetch_addon.config.Hotkeys;

public class InputHandler implements IKeybindProvider
{
    private static final InputHandler INSTANCE = new InputHandler();

    public InputHandler()
    {
    }

    public static InputHandler getInstance()
    {
        return INSTANCE;
    }

    @Override
    public void addKeysToMap(IKeybindManager manager)
    {
        for (IHotkey hotkey : Hotkeys.HOTKEY_LIST)
        {
            manager.addKeybindToMap(hotkey.getKeybind());
        }
    }

    @Override
    public void addHotkeys(IKeybindManager manager)
    {
        manager.addHotkeysForCategory(Reference.MOD_NAME, Reference.MOD_ID+".hotkeys.category.hotkeys", Hotkeys.HOTKEY_LIST);
    }
}
