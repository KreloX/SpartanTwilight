package krelox.spartantwilight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import krelox.spartantwilight.init.ItemRegistryST;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpartanTwilight.MODID)
public class SpartanTwilight 
{
	public static final Logger LOGGER = LogManager.getLogger();
	
	public static final String MODID = "spartantwilight";
	
	public SpartanTwilight() 
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		ItemRegistryST.ITEMS.register(bus);
	}
}
