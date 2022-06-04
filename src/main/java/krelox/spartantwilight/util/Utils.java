package krelox.spartantwilight.util;

import org.apache.commons.lang3.StringUtils;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;

import net.minecraft.item.Item;

public class Utils 
{
	public static ToolMaterialEx spartanMatFromToolMat(String name, Item.ToolMaterial material,
            										int color1, int color2, String repairName,
            										float attackDamage)
	{
		return new ToolMaterialEx(
				name,
				repairName,
				Reference.modid,
				color1,
				color2,
				material.getHarvestLevel(),
				material.getMaxUses(),
				material.getEfficiency(),
				attackDamage,
				material.getEnchantability());
	}
}

