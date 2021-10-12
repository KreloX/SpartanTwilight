package krelox.spartantwilight.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class STItem extends Item
{
	public STItem(ResourceLocation registryName, CreativeTabs tab){
        setRegistryName(registryName);
        setCreativeTab(tab);
    }
}

