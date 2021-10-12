package krelox.spartantwilight.util;

import java.util.ArrayList;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;

public class TFMatConverter 
{
	public final ToolMaterialEx material;

    public final String name;

    public final ArrayList<WeaponProperty> properties;
    
    public TFMatConverter(String name, ToolMaterialEx material, WeaponProperty... properties) 
    {
        this.name = name;
        this.material = material;
        this.properties = new ArrayList<>();
        for (WeaponProperty prop : properties)
        {
            this.properties.add(prop);
        }
    }
}
