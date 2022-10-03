package krelox.spartantwilight.init;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;

import krelox.spartantwilight.SpartanTwilight;
import krelox.spartantwilight.itemgroup.ItemGroupST;
import krelox.spartantwilight.weapontrait.FieryWeaponTrait;
import krelox.spartantwilight.weapontrait.KnightlyWeaponTrait;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.data.ItemTagGenerator;
import twilightforest.enums.TwilightItemTier;

public class ItemRegistryST 
{
	public static WeaponMaterial IRONWOOD = new WeaponMaterial("ironwood", TwilightItemTier.TOOL_IRONWOOD, ItemTagGenerator.IRONWOOD_INGOTS.getName());
    public static WeaponMaterial FIERY = new WeaponMaterial("fiery", TwilightItemTier.TOOL_FIERY, ItemTagGenerator.FIERY_INGOTS.getName(), new FieryWeaponTrait());
    public static WeaponMaterial KNIGHTLY = new WeaponMaterial("knightly", TwilightItemTier.TOOL_KNIGHTLY, ItemTagGenerator.KNIGHTMETAL_INGOTS.getName(), new KnightlyWeaponTrait());
    public static WeaponMaterial STEELEAF = new WeaponMaterial("steeleaf", TwilightItemTier.TOOL_STEELEAF, ItemTagGenerator.STEELEAF_INGOTS.getName());
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpartanTwilight.MODID);
	
	public static final RegistryObject<Item> BLAZE_POLE = ITEMS.register("blaze_pole", () -> new Item(new Item.Properties().tab(ItemGroupST.ITEM_GROUP_ST)));

	public static final RegistryObject<Item> DAGGER_IRONWOOD = ITEMS.register("dagger_ironwood", () -> SpartanWeaponryAPI.createDagger(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> DAGGER_FIERY = ITEMS.register("dagger_fiery", () -> SpartanWeaponryAPI.createDagger(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> DAGGER_STEELEAF = ITEMS.register("dagger_steeleaf", () -> SpartanWeaponryAPI.createDagger(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> DAGGER_KNIGHTLY = ITEMS.register("dagger_knightly", () -> SpartanWeaponryAPI.createDagger(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> LONGSWORD_IRONWOOD = ITEMS.register("longsword_ironwood", () -> SpartanWeaponryAPI.createLongsword(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LONGSWORD_FIERY = ITEMS.register("longsword_fiery", () -> SpartanWeaponryAPI.createLongsword(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LONGSWORD_STEELEAF = ITEMS.register("longsword_steeleaf", () -> SpartanWeaponryAPI.createLongsword(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LONGSWORD_KNIGHTLY = ITEMS.register("longsword_knightly", () -> SpartanWeaponryAPI.createLongsword(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> KATANA_IRONWOOD = ITEMS.register("katana_ironwood", () -> SpartanWeaponryAPI.createKatana(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> KATANA_FIERY = ITEMS.register("katana_fiery", () -> SpartanWeaponryAPI.createKatana(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> KATANA_STEELEAF = ITEMS.register("katana_steeleaf", () -> SpartanWeaponryAPI.createKatana(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> KATANA_KNIGHTLY = ITEMS.register("katana_knightly", () -> SpartanWeaponryAPI.createKatana(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> SABER_IRONWOOD = ITEMS.register("saber_ironwood", () -> SpartanWeaponryAPI.createSaber(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SABER_FIERY = ITEMS.register("saber_fiery", () -> SpartanWeaponryAPI.createSaber(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SABER_STEELEAF = ITEMS.register("saber_steeleaf", () -> SpartanWeaponryAPI.createSaber(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SABER_KNIGHTLY = ITEMS.register("saber_knightly", () -> SpartanWeaponryAPI.createSaber(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> RAPIER_IRONWOOD = ITEMS.register("rapier_ironwood", () -> SpartanWeaponryAPI.createRapier(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> RAPIER_FIERY = ITEMS.register("rapier_fiery", () -> SpartanWeaponryAPI.createRapier(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> RAPIER_STEELEAF = ITEMS.register("rapier_steeleaf", () -> SpartanWeaponryAPI.createRapier(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> RAPIER_KNIGHTLY = ITEMS.register("rapier_knightly", () -> SpartanWeaponryAPI.createRapier(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> GREATSWORD_IRONWOOD = ITEMS.register("greatsword_ironwood", () -> SpartanWeaponryAPI.createGreatsword(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> GREATSWORD_FIERY = ITEMS.register("greatsword_fiery", () -> SpartanWeaponryAPI.createGreatsword(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> GREATSWORD_STEELEAF = ITEMS.register("greatsword_steeleaf", () -> SpartanWeaponryAPI.createGreatsword(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> GREATSWORD_KNIGHTLY = ITEMS.register("greatsword_knightly", () -> SpartanWeaponryAPI.createGreatsword(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> HAMMER_IRONWOOD = ITEMS.register("hammer_ironwood", () -> SpartanWeaponryAPI.createBattleHammer(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> HAMMER_FIERY = ITEMS.register("hammer_fiery", () -> SpartanWeaponryAPI.createBattleHammer(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> HAMMER_STEELEAF = ITEMS.register("hammer_steeleaf", () -> SpartanWeaponryAPI.createBattleHammer(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> HAMMER_KNIGHTLY = ITEMS.register("hammer_knightly", () -> SpartanWeaponryAPI.createBattleHammer(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> WARHAMMER_IRONWOOD = ITEMS.register("warhammer_ironwood", () -> SpartanWeaponryAPI.createWarhammer(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> WARHAMMER_FIERY = ITEMS.register("warhammer_fiery", () -> SpartanWeaponryAPI.createWarhammer(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> WARHAMMER_STEELEAF = ITEMS.register("warhammer_steeleaf", () -> SpartanWeaponryAPI.createWarhammer(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> WARHAMMER_KNIGHTLY = ITEMS.register("warhammer_knightly", () -> SpartanWeaponryAPI.createWarhammer(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> SPEAR_IRONWOOD = ITEMS.register("spear_ironwood", () -> SpartanWeaponryAPI.createSpear(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SPEAR_FIERY = ITEMS.register("spear_fiery", () -> SpartanWeaponryAPI.createSpear(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SPEAR_STEELEAF = ITEMS.register("spear_steeleaf", () -> SpartanWeaponryAPI.createSpear(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SPEAR_KNIGHTLY = ITEMS.register("spear_knightly", () -> SpartanWeaponryAPI.createSpear(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> HALBERD_IRONWOOD = ITEMS.register("halberd_ironwood", () -> SpartanWeaponryAPI.createHalberd(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> HALBERD_FIERY = ITEMS.register("halberd_fiery", () -> SpartanWeaponryAPI.createHalberd(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> HALBERD_STEELEAF = ITEMS.register("halberd_steeleaf", () -> SpartanWeaponryAPI.createHalberd(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> HALBERD_KNIGHTLY = ITEMS.register("halberd_knightly", () -> SpartanWeaponryAPI.createHalberd(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> PIKE_IRONWOOD = ITEMS.register("pike_ironwood", () -> SpartanWeaponryAPI.createPike(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> PIKE_FIERY = ITEMS.register("pike_fiery", () -> SpartanWeaponryAPI.createPike(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> PIKE_STEELEAF = ITEMS.register("pike_steeleaf", () -> SpartanWeaponryAPI.createPike(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> PIKE_KNIGHTLY = ITEMS.register("pike_knightly", () -> SpartanWeaponryAPI.createPike(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> LANCE_IRONWOOD = ITEMS.register("lance_ironwood", () -> SpartanWeaponryAPI.createLance(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LANCE_FIERY = ITEMS.register("lance_fiery", () -> SpartanWeaponryAPI.createLance(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LANCE_STEELEAF = ITEMS.register("lance_steeleaf", () -> SpartanWeaponryAPI.createLance(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LANCE_KNIGHTLY = ITEMS.register("lance_knightly", () -> SpartanWeaponryAPI.createLance(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> LONGBOW_IRONWOOD = ITEMS.register("longbow_ironwood", () -> SpartanWeaponryAPI.createLongbow(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LONGBOW_FIERY = ITEMS.register("longbow_fiery", () -> SpartanWeaponryAPI.createLongbow(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LONGBOW_STEELEAF = ITEMS.register("longbow_steeleaf", () -> SpartanWeaponryAPI.createLongbow(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> LONGBOW_KNIGHTLY = ITEMS.register("longbow_knightly", () -> SpartanWeaponryAPI.createLongbow(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> CROSSBOW_IRONWOOD = ITEMS.register("heavy_crossbow_ironwood", () -> SpartanWeaponryAPI.createHeavyCrossbow(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> CROSSBOW_FIERY = ITEMS.register("heavy_crossbow_fiery", () -> SpartanWeaponryAPI.createHeavyCrossbow(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> CROSSBOW_STEELEAF = ITEMS.register("heavy_crossbow_steeleaf", () -> SpartanWeaponryAPI.createHeavyCrossbow(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> CROSSBOW_KNIGHTLY = ITEMS.register("heavy_crossbow_knightly", () -> SpartanWeaponryAPI.createHeavyCrossbow(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> THROWING_KNIFE_IRONWOOD = ITEMS.register("throwing_knife_ironwood", () -> SpartanWeaponryAPI.createThrowingKnife(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> THROWING_KNIFE_FIERY = ITEMS.register("throwing_knife_fiery", () -> SpartanWeaponryAPI.createThrowingKnife(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> THROWING_KNIFE_STEELEAF = ITEMS.register("throwing_knife_steeleaf", () -> SpartanWeaponryAPI.createThrowingKnife(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> THROWING_KNIFE_KNIGHTLY = ITEMS.register("throwing_knife_knightly", () -> SpartanWeaponryAPI.createThrowingKnife(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> TOMAHAWK_IRONWOOD = ITEMS.register("tomahawk_ironwood", () -> SpartanWeaponryAPI.createTomahawk(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> TOMAHAWK_FIERY = ITEMS.register("tomahawk_fiery", () -> SpartanWeaponryAPI.createTomahawk(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> TOMAHAWK_STEELEAF = ITEMS.register("tomahawk_steeleaf", () -> SpartanWeaponryAPI.createTomahawk(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> TOMAHAWK_KNIGHTLY = ITEMS.register("tomahawk_knightly", () -> SpartanWeaponryAPI.createTomahawk(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> JAVELIN_IRONWOOD = ITEMS.register("javelin_ironwood", () -> SpartanWeaponryAPI.createJavelin(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> JAVELIN_FIERY = ITEMS.register("javelin_fiery", () -> SpartanWeaponryAPI.createJavelin(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> JAVELIN_STEELEAF = ITEMS.register("javelin_steeleaf", () -> SpartanWeaponryAPI.createJavelin(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> JAVELIN_KNIGHTLY = ITEMS.register("javelin_knightly", () -> SpartanWeaponryAPI.createJavelin(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> BOOMERANG_IRONWOOD = ITEMS.register("boomerang_ironwood", () -> SpartanWeaponryAPI.createBoomerang(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> BOOMERANG_FIERY = ITEMS.register("boomerang_fiery", () -> SpartanWeaponryAPI.createBoomerang(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> BOOMERANG_STEELEAF = ITEMS.register("boomerang_steeleaf", () -> SpartanWeaponryAPI.createBoomerang(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> BOOMERANG_KNIGHTLY = ITEMS.register("boomerang_knightly", () -> SpartanWeaponryAPI.createBoomerang(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> BATTLEAXE_IRONWOOD = ITEMS.register("battleaxe_ironwood", () -> SpartanWeaponryAPI.createBattleaxe(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> BATTLEAXE_FIERY = ITEMS.register("battleaxe_fiery", () -> SpartanWeaponryAPI.createBattleaxe(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> BATTLEAXE_STEELEAF = ITEMS.register("battleaxe_steeleaf", () -> SpartanWeaponryAPI.createBattleaxe(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> BATTLEAXE_KNIGHTLY = ITEMS.register("battleaxe_knightly", () -> SpartanWeaponryAPI.createBattleaxe(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> MACE_IRONWOOD = ITEMS.register("flanged_mace_ironwood", () -> SpartanWeaponryAPI.createFlangedMace(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> MACE_FIERY = ITEMS.register("flanged_mace_fiery", () -> SpartanWeaponryAPI.createFlangedMace(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> MACE_STEELEAF = ITEMS.register("flanged_mace_steeleaf", () -> SpartanWeaponryAPI.createFlangedMace(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> MACE_KNIGHTLY = ITEMS.register("flanged_mace_knightly", () -> SpartanWeaponryAPI.createFlangedMace(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> GLAIVE_IRONWOOD = ITEMS.register("glaive_ironwood", () -> SpartanWeaponryAPI.createGlaive(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> GLAIVE_FIERY = ITEMS.register("glaive_fiery", () -> SpartanWeaponryAPI.createGlaive(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> GLAIVE_STEELEAF = ITEMS.register("glaive_steeleaf", () -> SpartanWeaponryAPI.createGlaive(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> GLAIVE_KNIGHTLY = ITEMS.register("glaive_knightly", () -> SpartanWeaponryAPI.createGlaive(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> QUARTERSTAFF_IRONWOOD = ITEMS.register("quarterstaff_ironwood", () -> SpartanWeaponryAPI.createQuarterstaff(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> QUARTERSTAFF_FIERY = ITEMS.register("quarterstaff_fiery", () -> SpartanWeaponryAPI.createQuarterstaff(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> QUARTERSTAFF_STEELEAF = ITEMS.register("quarterstaff_steeleaf", () -> SpartanWeaponryAPI.createQuarterstaff(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> QUARTERSTAFF_KNIGHTLY = ITEMS.register("quarterstaff_knightly", () -> SpartanWeaponryAPI.createQuarterstaff(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> SCYTHE_IRONWOOD = ITEMS.register("scythe_ironwood", () -> SpartanWeaponryAPI.createScythe(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SCYTHE_FIERY = ITEMS.register("scythe_fiery", () -> SpartanWeaponryAPI.createScythe(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SCYTHE_STEELEAF = ITEMS.register("scythe_steeleaf", () -> SpartanWeaponryAPI.createScythe(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> SCYTHE_KNIGHTLY = ITEMS.register("scythe_knightly", () -> SpartanWeaponryAPI.createScythe(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));

	public static final RegistryObject<Item> PARRYING_DAGGER_IRONWOOD = ITEMS.register("parrying_dagger_ironwood", () -> SpartanWeaponryAPI.createParryingDagger(IRONWOOD, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> PARRYING_DAGGER_FIERY = ITEMS.register("parrying_dagger_fiery", () -> SpartanWeaponryAPI.createParryingDagger(FIERY, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> PARRYING_DAGGER_STEELEAF = ITEMS.register("parrying_dagger_steeleaf", () -> SpartanWeaponryAPI.createParryingDagger(STEELEAF, ItemGroupST.ITEM_GROUP_ST, true));
	public static final RegistryObject<Item> PARRYING_DAGGER_KNIGHTLY = ITEMS.register("parrying_dagger_knightly", () -> SpartanWeaponryAPI.createParryingDagger(KNIGHTLY, ItemGroupST.ITEM_GROUP_ST, true));
}