package krelox.spartantwilight.weapontrait;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;

import krelox.spartantwilight.SpartanTwilight;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class KnightlyWeaponTrait extends MeleeCallbackWeaponTrait 
{
	private static final int BONUS_DAMAGE = 2;
	
	public KnightlyWeaponTrait()
	{
		super("knightly", SpartanTwilight.MODID, TraitQuality.POSITIVE);
	}
	
	@Override
	public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) 
	{
		boolean flag = true;
		if(attacker instanceof PlayerEntity) 
		{
            if(((PlayerEntity)attacker).swingTime > 0.2)
            {
                flag = false;
            }
		}
		
		if(flag)
		{
			if (target.getArmorValue() > 0) 
			{
				target.hurt(DamageSource.MAGIC, BONUS_DAMAGE);
				target.invulnerableTime = 0;
			}
		}
	}
}
