package io.github.mms0316.litematica_fetch_addon.event;

import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import io.github.mms0316.litematica_fetch_addon.config.Hotkeys;
import io.github.mms0316.litematica_fetch_addon.materials.ContainerManager;
import net.minecraft.client.MinecraftClient;

public class KeyCallbacks
{
    public static void init(MinecraftClient mc)
    {
        IHotkeyCallback callbackHotkeys = new KeyCallbackHotkeys(mc);

        Hotkeys.MATERIAL_LIST_CONTAINER_REGISTER.getKeybind().setCallback(callbackHotkeys);
        Hotkeys.MATERIAL_LIST_CONTAINER_UNREGISTER.getKeybind().setCallback(callbackHotkeys);
        Hotkeys.MATERIAL_LIST_CONTAINER_UNREGISTER_ALL.getKeybind().setCallback(callbackHotkeys);
        Hotkeys.MATERIAL_LIST_FETCH.getKeybind().setCallback(callbackHotkeys);
        Hotkeys.MATERIAL_LIST_FETCH_KEEP_STACKS.getKeybind().setCallback(callbackHotkeys);
    }

    private static class KeyCallbackHotkeys implements IHotkeyCallback
    {
        private final MinecraftClient mc;

        public KeyCallbackHotkeys(MinecraftClient mc)
        {
            this.mc = mc;
        }

        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key)
        {
            if (this.mc.player == null || this.mc.world == null)
            {
                return false;
            }

            if (key == Hotkeys.MATERIAL_LIST_CONTAINER_REGISTER.getKeybind())
            {
                ContainerManager.getInstance().registerContainer(mc);
                return true;
            }
            else if (key == Hotkeys.MATERIAL_LIST_CONTAINER_UNREGISTER.getKeybind())
            {
                ContainerManager.getInstance().unregisterContainer(mc);
                return true;
            }
            else if (key == Hotkeys.MATERIAL_LIST_CONTAINER_UNREGISTER_ALL.getKeybind())
            {
                ContainerManager.getInstance().unregisterContainerAll(mc);
                return true;
            }
            else if (key == Hotkeys.MATERIAL_LIST_FETCH.getKeybind())
            {
                ContainerManager.getInstance().fetchMaterials(mc);
                return true;
            }
            else if (key == Hotkeys.MATERIAL_LIST_FETCH_KEEP_STACKS.getKeybind())
            {
                ContainerManager.getInstance().fetchMaterialsKeepStacks(mc);
                return true;
            }

            return false;
        }
    }
}
