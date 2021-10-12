package krelox.spartantwilight;

import krelox.spartantwilight.loot.LootHandler;
import krelox.spartantwilight.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.modid , name = Reference.name, version = Reference.version, dependencies = Reference.dependencies)

public class SpartanTwilight 
{

	@EventHandler
    public void preInit(FMLPreInitializationEvent event) 
	{
		LootHandler.register();
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event) 
	{}
}
