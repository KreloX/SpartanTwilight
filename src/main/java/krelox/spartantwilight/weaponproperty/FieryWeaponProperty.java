package krelox.spartantwilight.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;

import krelox.spartantwilight.handler.ConfigHandlerST;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class FieryWeaponProperty extends WeaponPropertyWithCallback
{
	private static final int BONUS_DAMAGE = ConfigHandlerST.fiery_extra;
	
	public FieryWeaponProperty(String propType, String propModId) 
	{
        super(propType, propModId);
    }
	
	public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) 
	{
		if (target.isBurning()) 
		{
			target.attackEntityFrom(DamageSource.MAGIC, BONUS_DAMAGE);
			target.hurtResistantTime = 0;
		}
	}
}
