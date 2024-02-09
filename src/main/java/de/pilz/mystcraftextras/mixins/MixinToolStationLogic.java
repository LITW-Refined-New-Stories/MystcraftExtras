package de.pilz.mystcraftextras.mixins;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.xcompwiz.mystcraft.item.ItemLinkbook;
import com.xcompwiz.mystcraft.linking.LinkOptions;

import mantle.blocks.abstracts.InventoryLogic;
import tconstruct.tools.logic.ToolStationLogic;

@Mixin(ToolStationLogic.class)
public abstract class MixinToolStationLogic extends InventoryLogic {

    public MixinToolStationLogic(int invSize) {
        super(invSize);
    }

    @Inject(
        method = "canRename(Lnet/minecraft/nbt/NBTTagCompound;Lnet/minecraft/item/ItemStack;)Z",
        at = @At("RETURN"),
        cancellable = true,
        remap = false)
    private static void canRename$mystcraftextras$canRenameLinkingBook(NBTTagCompound tags, ItemStack tool,
        CallbackInfoReturnable<Boolean> callback) {
        if (tool != null && tool.getItem() instanceof ItemLinkbook) {
            callback.setReturnValue(true);
        }
    }

    @Inject(
        method = "tryRenameTool(Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Lnet/minecraft/item/ItemStack;",
        at = @At("HEAD"),
        cancellable = true,
        remap = false)
    protected void tryRenameTool$mystcraftextras$renameLinkingBook(ItemStack output, String name,
        CallbackInfoReturnable<ItemStack> callback) {
        var temp = output != null ? output : this.inventory[1].copy();

        if (temp != null && temp.getItem() instanceof ItemLinkbook && name != null && !name.equals("")) {
            LinkOptions.setDisplayName(temp.stackTagCompound, name);
            output = temp;
            callback.setReturnValue(output);
            callback.cancel();
        }
    }
}
