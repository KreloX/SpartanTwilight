package krelox.spartantwilight.mixin;

import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import krelox.spartantwilight.SpartanTwilight;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(WeaponTrait.class)
public class WeaponTraitMixin {
    @ModifyArg(
            method = "initTooltipTypes",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/TranslatableComponent;<init>(Ljava/lang/String;)V"),
            index = 0
    )
    private String formatTooltip(String original) {
        return original.replace(SpartanTwilight.MODID, ModSpartanWeaponry.ID);
    }
}
