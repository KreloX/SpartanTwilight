package krelox.spartantwilight.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;

import krelox.spartantwilight.handler.ConfigHandlerST;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class KnightlyWeaponProperty extends WeaponPropertyWithCallback
{
	private static final int BONUS_DAMAGE = ConfigHandlerST.knightly_extra;
	
	public KnightlyWeaponProperty(String propType, String propModId) 
	{
        super(propType, propModId);
    }
	
	public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) 
	{
		boolean flag = true;
		if (attacker instanceof EntityPlayer) 
		{
			if(((EntityPlayer)attacker).swingProgress > 0.2) 
			{
				flag = false;
			}
		}
		
		if (target.getTotalArmorValue() > 0 && flag)
		{
			target.attackEntityFrom(DamageSource.MAGIC, BONUS_DAMAGE);
			target.hurtResistantTime = 0;
		}
	}
}
