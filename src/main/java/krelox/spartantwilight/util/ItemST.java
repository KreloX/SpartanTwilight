package krelox.spartantwilight.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemST extends Item {

    public ItemST(ResourceLocation registryName, CreativeTabs tab){
        setRegistryName(registryName);
        setUnlocalizedName(registryName.getResourcePath());
        setCreativeTab(tab);
    }
}