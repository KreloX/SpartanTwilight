package krelox.spartantwilight.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import twilightforest.world.TFWorld;

public class SteeleafWeaponProperty extends WeaponPropertyWithCallback
{
	public SteeleafWeaponProperty(String propType, String propModId) 
	{
        super(propType, propModId);
    }
	
	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected)
	{
		if (TFWorld.isTwilightForest(world))
			if(!world.isRemote && stack.isItemDamaged() && entity instanceof EntityPlayer && entity.ticksExisted % 200 == 0)
			{
				stack.setItemDamage(stack.getItem().getDamage(stack) - 1);
			}
	}
}