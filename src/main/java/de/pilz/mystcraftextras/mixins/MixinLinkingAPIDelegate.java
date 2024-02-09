package de.pilz.mystcraftextras.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.xcompwiz.mystcraft.api.impl.linking.LinkingAPIDelegate;
import com.xcompwiz.mystcraft.api.linking.ILinkInfo;

@Mixin(LinkingAPIDelegate.class)
public class MixinLinkingAPIDelegate {

    @Inject(
        method = "createLinkInfoFromPosition(Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;)Lcom/xcompwiz/mystcraft/api/linking/ILinkInfo;",
        at = @At("RETURN"),
        cancellable = true,
        remap = false)
    public void createLinkInfoFromPosition$mystcraftextra$applyIntraLinking(World World, Entity entity,
        CallbackInfoReturnable<ILinkInfo> callback) {}
}
