package krelox.spartantwilight.mixin;

import krelox.spartantwilight.item.STItems.Material;
import krelox.spartantwilight.item.WeaponItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.extensions.IForgeItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements IForgeItemStack {
    @Shadow
    public abstract void enchant(Enchantment p_41664_, int p_41665_);

    @Inject(
            method = "<init>(Lnet/minecraft/world/level/ItemLike;ILnet/minecraft/nbt/CompoundTag;)V",
            at = @At("RETURN")
    )
    public void init(ItemLike item, int p_41605_, CompoundTag p_41606_, CallbackInfo ci) {
        if (item instanceof WeaponItem weapon) {
            for (Material material : Material.values()) {
                if (weapon.getMaterial().equals(material.material)) {
                    for (var enchantment : material.enchantments) {
                        if (canApplyAtEnchantingTable(enchantment.first().get())) {
                            enchant(enchantment.first().get(), enchantment.second());
                        }
                    }
                    break;
                }
            }
        }
    }
}
