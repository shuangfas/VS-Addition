package io.github.xiewuzhiying.vs_addition.fabric.mixin.computercraft;

import dan200.computercraft.shared.pocket.core.PocketServerComputer;
import dan200.computercraft.shared.pocket.items.ItemPocketComputer;
import io.github.xiewuzhiying.vs_addition.compats.computercraft.VSAdditionCC;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(ItemPocketComputer.class)
public abstract class ItemPocketComputerMixin {
    @Inject(
            method = "createServerComputer",
            at = @At("RETURN"),
            remap = false
    )
    private void vs_addition$addAPI(Level world, Container inventory, Entity entity, ItemStack stack, CallbackInfoReturnable<PocketServerComputer> cir) {
        PocketServerComputer computer = cir.getReturnValue();
        VSAdditionCC.applyCCAPIs(computer, (ServerLevel) world);
    }
}
