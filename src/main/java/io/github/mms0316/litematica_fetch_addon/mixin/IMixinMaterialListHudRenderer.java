package io.github.mms0316.litematica_fetch_addon.mixin;

import fi.dy.masa.litematica.materials.MaterialListHudRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = MaterialListHudRenderer.class, remap = false)
public interface IMixinMaterialListHudRenderer
{
    @Accessor("lastUpdateTime")
    void setLastUpdateTime(long lastUpdateTime);
}
