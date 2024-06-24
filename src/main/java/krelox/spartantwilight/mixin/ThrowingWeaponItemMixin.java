package krelox.spartantwilight.mixin;

import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import krelox.spartantwilight.item.WeaponItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ThrowingWeaponItem.class)
public abstract class ThrowingWeaponItemMixin implements WeaponItem {
}
