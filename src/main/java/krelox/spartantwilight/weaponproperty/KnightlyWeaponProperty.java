package krelox.spartantwilight.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class KnightlyWeaponProperty extends WeaponPropertyWithCallback
{
	private static final int BONUS_DAMAGE = 3;
	
	public KnightlyWeaponProperty(String propType, String propModId) 
	{
        super(propType, propModId);
    }
	
	public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) 
	{
		if (target.getTotalArmorValue() > 0) 
		{
			target.attackEntityFrom(DamageSource.MAGIC, BONUS_DAMAGE);
			target.hurtResistantTime = 0;
		}
	}
}