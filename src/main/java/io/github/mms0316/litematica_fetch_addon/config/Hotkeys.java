package io.github.mms0316.litematica_fetch_addon.config;

import java.util.List;

import com.google.common.collect.ImmutableList;

import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import io.github.mms0316.litematica_fetch_addon.Reference;

public class Hotkeys
{
    private static final String HOTKEYS_KEY = Reference.MOD_ID+".config.hotkeys";

    public static final ConfigHotkey OPEN_CONFIG_GUI                        = new ConfigHotkey("openConfigGui",                         "").apply(HOTKEYS_KEY);

    public static final ConfigHotkey MATERIAL_LIST_CONTAINER_REGISTER       = new ConfigHotkey("materialListContainerRegister",         "", KeybindSettings.MODIFIER_GUI).apply(HOTKEYS_KEY);
    public static final ConfigHotkey MATERIAL_LIST_CONTAINER_UNREGISTER     = new ConfigHotkey("materialListContainerUnregister",       "").apply(HOTKEYS_KEY);
    public static final ConfigHotkey MATERIAL_LIST_CONTAINER_UNREGISTER_ALL = new ConfigHotkey("materialListContainerUnregisterAll",    "").apply(HOTKEYS_KEY);
    public static final ConfigHotkey MATERIAL_LIST_FETCH                    = new ConfigHotkey("materialListFetch",                     "", KeybindSettings.MODIFIER_GUI).apply(HOTKEYS_KEY);
    public static final ConfigHotkey MATERIAL_LIST_FETCH_KEEP_STACKS        = new ConfigHotkey("materialListFetchKeepStacks",           "", KeybindSettings.MODIFIER_GUI).apply(HOTKEYS_KEY);

    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            OPEN_CONFIG_GUI,

            MATERIAL_LIST_CONTAINER_REGISTER,
            MATERIAL_LIST_CONTAINER_UNREGISTER,
            MATERIAL_LIST_CONTAINER_UNREGISTER_ALL,
            MATERIAL_LIST_FETCH,
            MATERIAL_LIST_FETCH_KEEP_STACKS
    );
}
