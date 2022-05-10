package krelox.spartantwilight.itemgroup;

import krelox.spartantwilight.init.ItemRegistryST;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupST extends ItemGroup
{
	public static final ItemGroupST ITEM_GROUP_ST = new ItemGroupST(ItemGroup.TABS.length, "sw_twilight_forest");

	public ItemGroupST(int index, String label) 
	{
		super(index, label);
	}

	@Override
	public ItemStack makeIcon() 
	{
		return new ItemStack(ItemRegistryST.GREATSWORD_KNIGHTLY.get());
	}
	
}
