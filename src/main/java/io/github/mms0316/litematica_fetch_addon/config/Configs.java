package io.github.mms0316.litematica_fetch_addon.config;

import java.nio.file.Files;
import java.nio.file.Path;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;
import io.github.mms0316.litematica_fetch_addon.LitematicaFetchAddon;
import io.github.mms0316.litematica_fetch_addon.Reference;

public class Configs implements IConfigHandler
{
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    private static final String INFO_OVERLAYS_KEY = Reference.MOD_ID+".config.info_overlays";
    public static class InfoOverlays
    {
        public static final ConfigBoolean       MATERIAL_LIST_CONTAINER_OVERLAY_ENABLED = new ConfigBoolean("materialListContainerOverlayEnabled", true).apply(INFO_OVERLAYS_KEY);

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                MATERIAL_LIST_CONTAINER_OVERLAY_ENABLED
        );
    }

    private static final String COLORS_KEY = Reference.MOD_ID+".config.colors";
    public static class Colors
    {
        public static final ConfigColor MATERIAL_LIST_FETCH_CONTAINER_COLOR = new ConfigColor("materialListFetchContainerColor",    "#FF33B3FF").apply(COLORS_KEY);

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                MATERIAL_LIST_FETCH_CONTAINER_COLOR
        );
    }

    public static void loadFromFile()
    {
        Path configFile = FileUtils.getConfigDirectoryAsPath().resolve(CONFIG_FILE_NAME);

        if (Files.exists(configFile) && Files.isReadable(configFile))
        {
            JsonElement element = JsonUtils.parseJsonFileAsPath(configFile);

            if (element != null && element.isJsonObject())
            {
                JsonObject root = element.getAsJsonObject();

                ConfigUtils.readConfigBase(root, "Colors", Colors.OPTIONS);
                ConfigUtils.readConfigBase(root, "Hotkeys", Hotkeys.HOTKEY_LIST);
                ConfigUtils.readConfigBase(root, "InfoOverlays", InfoOverlays.OPTIONS);
            }
        }
        else
        {
            LitematicaFetchAddon.LOGGER.error("loadFromFile(): Failed to load config file '{}'.", configFile.toAbsolutePath());
        }
    }

    public static void saveToFile()
    {
        Path dir = FileUtils.getConfigDirectoryAsPath();

        if (!Files.exists(dir))
        {
            FileUtils.createDirectoriesIfMissing(dir);
        }

        if (Files.isDirectory(dir))
        {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Colors", Colors.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Hotkeys", Hotkeys.HOTKEY_LIST);
            ConfigUtils.writeConfigBase(root, "InfoOverlays", InfoOverlays.OPTIONS);

            JsonUtils.writeJsonToFileAsPath(root, dir.resolve(CONFIG_FILE_NAME));
        }
        else
        {
            LitematicaFetchAddon.LOGGER.error("saveToFile(): Config Folder '{}' does not exist!", dir.toAbsolutePath());
        }
    }

    @Override
    public void load()
    {
        loadFromFile();
    }

    @Override
    public void save()
    {
        saveToFile();
    }
}
