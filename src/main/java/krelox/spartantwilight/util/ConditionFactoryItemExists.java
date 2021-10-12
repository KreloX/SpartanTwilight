package krelox.spartantwilight.util;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConditionFactoryItemExists implements IConditionFactory
{
	public ConditionFactoryItemExists() {
    }

    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        String itemName = json.get("item").getAsString();
        boolean result = !GameRegistry.makeItemStack(itemName, 0, 1, (String)null).isEmpty();
        return () -> {
            return result;
        };
    }
}