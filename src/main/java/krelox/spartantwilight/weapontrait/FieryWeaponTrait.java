package krelox.spartantwilight.weapontrait;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;

import krelox.spartantwilight.SpartanTwilight;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class FieryWeaponTrait extends MeleeCallbackWeaponTrait
{
	public FieryWeaponTrait()
	{
		super("fiery", SpartanTwilight.MODID, TraitQuality.POSITIVE);
	}
	
	@Override
	public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) 
	{
		target.setSecondsOnFire(15);
	}
}
