package krelox.spartantwilight.init;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import krelox.spartantwilight.util.Reference;
import net.minecraft.item.Item;

public class ModelRenderRegistryST 
{
	public static void addItemToRegistry(Item item, String modelLoc) {
        SpartanWeaponryAPI.addItemModelToRegistry(
                item, Reference.modid,
                modelLoc);
    }
}