package io.github.mms0316.litematica_fetch_addon.event;

import java.util.function.Supplier;

import org.joml.Matrix4f;

import fi.dy.masa.litematica.data.DataManager;
import fi.dy.masa.malilib.interfaces.IRenderer;
import io.github.mms0316.litematica_fetch_addon.Reference;
import io.github.mms0316.litematica_fetch_addon.materials.ContainerManager;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Fog;
import net.minecraft.client.render.Frustum;
import net.minecraft.util.profiler.Profiler;

public class RenderHandler implements IRenderer
{
    @Override
    public void onRenderWorldPreWeather(Matrix4f posMatrix, Matrix4f projMatrix, Frustum frustum, Camera camera, Fog fog, Profiler profiler)
    {
        ContainerManager.getInstance().renderMatchingMaterials(DataManager.getMaterialList(), projMatrix);
    }

    @Override
    public Supplier<String> getProfilerSectionSupplier()
    {
        return () -> Reference.MOD_ID+"_render_handler";
    }
}
