package krelox.spartantwilight.loot;

import java.util.Arrays;
import java.util.Locale;

import krelox.spartantwilight.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber	
public class LootHandler 
{
	public static String[] labyrinth_room = {"twilightforest:structures/labyrinth_room/labyrinth_room"};
	public static String[] labyrinth_vault = {"twilightforest:structures/labyrinth_vault/labyrinth_vault"};
	public static String[] stronghold_boss = {"twilightforest:structures/stronghold_boss/stronghold_boss"};
	public static String[] stronghold_cache = {"twilightforest:structures/stronghold_cache/stronghold_cache"};
	public static String[] stronghold_room = {"twilightforest:structures/stronghold_room/stronghold_room"};
	public static String[] aurora_room = {"twilightforest:structures/aurora_room/aurora_room"};
	public static String[] darktower_key = {"twilightforest:structures/darktower_key/darktower_key"};
	public static String[] aurora_cache = {"twilightforest:structures/aurora_cache/aurora_cache"};
	public static String[] darktower_cache = {"twilightforest:structures/darktower_cache/darktower_cache"};
	public static String[] hedge_maze = {"twilightforest:structures/hedge_maze/hedge_maze"};
	public static String[] hill_1 = {"twilightforest:structures/hill_1/hill_1"};
	public static String[] hill_2 = {"twilightforest:structures/hill_2/hill_2"};
	public static String[] hill_3 = {"twilightforest:structures/hill_3/hill_3"};
	public static String[] labyrinth_dead_end = {"twilightforest:structures/labyrinth_dead_end/labyrinth_dead_end"};
	
	public static void register()
	{
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/labyrinth_room"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/labyrinth_vault"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/stronghold_boss"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/stronghold_cache"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/stronghold_room"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/aurora_room"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/darktower_key"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/aurora_cache"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/darktower_cache"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/hedge_maze"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/hill_1"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/hill_2"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/hill_3"));
		LootTableList.register(new ResourceLocation(Reference.modid, "inject/labyrinth_dead_end"));
	}
	
	@SubscribeEvent
	public static void onLootTableLoadEvent(LootTableLoadEvent event)
	{
		ResourceLocation[] labyrinth_room = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.labyrinth_room);
		ResourceLocation[] labyrinth_vault = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.labyrinth_vault);
		ResourceLocation[] stronghold_boss = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.stronghold_boss);
		ResourceLocation[] stronghold_cache = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.stronghold_cache);
		ResourceLocation[] stronghold_room = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.stronghold_room);
		ResourceLocation[] aurora_room = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.aurora_room);
		ResourceLocation[] darktower_key = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.darktower_key);
		ResourceLocation[] aurora_cache = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.aurora_cache);
		ResourceLocation[] darktower_cache = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.darktower_cache);
		ResourceLocation[] hedge_maze = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.hedge_maze);
		ResourceLocation[] hill_1 = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.hill_1);
		ResourceLocation[] hill_2 = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.hill_2);
		ResourceLocation[] hill_3 = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.hill_3);
		ResourceLocation[] labyrinth_dead_end = krelox.spartantwilight.loot.LootHandler.toResourceLocations(LootHandler.labyrinth_dead_end);
		
		if(Arrays.asList(labyrinth_room).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/labyrinth_room", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(labyrinth_vault).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/labyrinth_vault", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(stronghold_boss).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/stronghold_boss", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(stronghold_cache).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/stronghold_cache", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(stronghold_room).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/stronghold_room", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(aurora_room).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/aurora_room", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(darktower_key).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/darktower_key", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(aurora_cache).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/aurora_cache", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(darktower_cache).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/darktower_cache", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(hedge_maze).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/hedge_maze", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(hill_1).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/hill_1", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(hill_2).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/hill_2", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(hill_3).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/hill_3", Reference.modid + "_additional_dungeon_loot"));
		}
		if(Arrays.asList(labyrinth_dead_end).contains(event.getName()))
		{
			event.getTable().addPool(getAdditive(Reference.modid + ":inject/labyrinth_dead_end", Reference.modid + "_additional_dungeon_loot"));
		}
	}

	private static LootPool getAdditive(String entryName, String poolName)
	{
		return new LootPool(new LootEntry[]{getAdditiveEntry(entryName, 1)}, new LootCondition[0],
				new RandomValueRange(1), new RandomValueRange(0, 1), Reference.modid + "_" + poolName);
	}

	private static LootEntryTable getAdditiveEntry(String name, int weight)
	{
		return new LootEntryTable(new ResourceLocation(name), weight, 0, new LootCondition[0],
				Reference.modid + "_additive_entry");
	}
	
	public static ResourceLocation[] toResourceLocations(String... strings)
	{
		return Arrays.stream(strings).map(s -> new ResourceLocation(s.toLowerCase(Locale.ROOT).trim())).toArray(ResourceLocation[]::new);
	}
}