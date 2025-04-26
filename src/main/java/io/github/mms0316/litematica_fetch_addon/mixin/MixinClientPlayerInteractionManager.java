package io.github.mms0316.litematica_fetch_addon.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.mms0316.litematica_fetch_addon.materials.ContainerManager;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

@Mixin(value = ClientPlayerInteractionManager.class)
public class MixinClientPlayerInteractionManager
{
    @Inject(method = "interactBlock(Lnet/minecraft/client/network/ClientPlayerEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/util/hit/BlockHitResult;)Lnet/minecraft/util/ActionResult;",
            at = @At(value = "HEAD"))
    private void onInteractBlock(ClientPlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir)
    {
        var pos = hitResult.getBlockPos();
        BlockEntity blockEntity = player.getWorld().getBlockEntity(pos);
        if (blockEntity instanceof LootableContainerBlockEntity)
        {
            ContainerManager.getInstance().setContainerPos(pos);
        }
    }
}
