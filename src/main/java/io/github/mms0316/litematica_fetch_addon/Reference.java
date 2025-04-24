package io.github.mms0316.litematica_fetch_addon;

import net.minecraft.MinecraftVersion;

import fi.dy.masa.malilib.util.StringUtils;

public class Reference
{
    public static final String MOD_ID = "litematica_fetch_addon";
    public static final String MOD_NAME = "Litematica Fetch Addon";
    public static final String MOD_VERSION = StringUtils.getModVersionString(MOD_ID);
    public static final String MC_VERSION = MinecraftVersion.CURRENT.getName();
    public static final String MOD_TYPE = "fabric";
    public static final String MOD_STRING = MOD_ID + "-" + MOD_TYPE + "-" + MC_VERSION + "-" + MOD_VERSION;
}
