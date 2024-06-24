package krelox.spartantwilight.mixin;

import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import krelox.spartantwilight.item.WeaponItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SwordBaseItem.class)
public abstract class SwordBaseItemMixin implements WeaponItem {
}
