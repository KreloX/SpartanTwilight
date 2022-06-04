package krelox.spartantwilight.init;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.util.ConfigHandler;

import krelox.spartantwilight.handler.ConfigHandlerST;
import krelox.spartantwilight.util.Reference;
import krelox.spartantwilight.util.TFMatConverter;
import krelox.spartantwilight.util.Utils;
import krelox.spartantwilight.weaponproperty.FieryWeaponProperty;
import krelox.spartantwilight.weaponproperty.KnightlyWeaponProperty;
import krelox.spartantwilight.weaponproperty.SteeleafWeaponProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

@Mod.EventBusSubscriber
public class ItemRegistryST 
{
	public static final Set<TFMatConverter> MATERIALS_TO_REGISTER = new LinkedHashSet<>();

    public static final String IRONWOOD = "ironwood";
    public static final String FIERY = "fiery";
    public static final String KNIGHTLY = "knightly";
    public static final String STEELEAF = "steeleaf";

    public static final Set<Item> ALL_ITEMS = new HashSet<>();
    
    static 
    {
        MATERIALS_TO_REGISTER.add(new TFMatConverter(IRONWOOD,
                Utils.spartanMatFromToolMat(IRONWOOD, TFItems.TOOL_IRONWOOD,
                9867904, 14999238, "ingotIronwood", ConfigHandlerST.ironwood_damage)));
        
    	if(ConfigHandlerST.fiery == true) 
    	{
	        MATERIALS_TO_REGISTER.add(new TFMatConverter(FIERY,
	                Utils.spartanMatFromToolMat(FIERY, TFItems.TOOL_FIERY,
	                9867904, 14999238, "ingotFiery", ConfigHandlerST.fiery_damage),
	                new FieryWeaponProperty(FIERY, Reference.modid)));
    	} else {
	        MATERIALS_TO_REGISTER.add(new TFMatConverter(FIERY,
	                Utils.spartanMatFromToolMat(FIERY, TFItems.TOOL_FIERY,
	                9867904, 14999238, "ingotFiery", ConfigHandlerST.fiery_damage)));
    	}
    	
    	if(ConfigHandlerST.knightly == true) 
    	{
	        MATERIALS_TO_REGISTER.add(new TFMatConverter(KNIGHTLY,
	                Utils.spartanMatFromToolMat(KNIGHTLY, TFItems.TOOL_KNIGHTLY,
	                        9867904, 14999238, "ingotKnightly", ConfigHandlerST.knightly_damage),
	        		new KnightlyWeaponProperty(KNIGHTLY, Reference.modid)));
	    } else {
	    	MATERIALS_TO_REGISTER.add(new TFMatConverter(KNIGHTLY,
	                Utils.spartanMatFromToolMat(KNIGHTLY, TFItems.TOOL_KNIGHTLY,
	                        9867904, 14999238, "ingotKnightly", ConfigHandlerST.knightly_damage)));
	    }
	        
    	if(ConfigHandlerST.steeleaf == true) {
	        MATERIALS_TO_REGISTER.add(new TFMatConverter(STEELEAF,
	        		Utils.spartanMatFromToolMat(STEELEAF, TFItems.TOOL_STEELEAF,
	                        9867904, 14999238, "ingotSteeleaf", ConfigHandlerST.steeleaf_damage),
	                new SteeleafWeaponProperty(STEELEAF, Reference.modid)));
        } else {
	        MATERIALS_TO_REGISTER.add(new TFMatConverter(STEELEAF,
	        		Utils.spartanMatFromToolMat(STEELEAF, TFItems.TOOL_STEELEAF,
	                        9867904, 14999238, "ingotSteeleaf", ConfigHandlerST.steeleaf_damage)));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev) 
    {

        Set<Item> item_set = new LinkedHashSet<>();
        for (TFMatConverter mat : MATERIALS_TO_REGISTER){
            if (!ConfigHandler.disableKatana){
                Item katana = SpartanWeaponryAPI.createKatana(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(katana,
                        "katana_" + mat.material.getUnlocName());
                item_set.add(katana);
            }
            if (!ConfigHandler.disableGreatsword){
                Item greatsword = SpartanWeaponryAPI.createGreatsword(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(greatsword, "greatsword_" + mat.material.getUnlocName());
                item_set.add(greatsword);
            }
            if (!ConfigHandler.disableLongsword){
                Item longsword = SpartanWeaponryAPI.createLongsword(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(longsword, "longsword_" + mat.material.getUnlocName());
                item_set.add(longsword);
            }
            if (!ConfigHandler.disableSaber){
                Item saber = SpartanWeaponryAPI.createSaber(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(saber, "saber_" + mat.material.getUnlocName());
                item_set.add(saber);
            }
            if (!ConfigHandler.disableRapier){
                Item rapier = SpartanWeaponryAPI.createRapier(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(rapier, "rapier_" + mat.material.getUnlocName());
                item_set.add(rapier);
            }
            if (!ConfigHandler.disableDagger) {
                Item dagger = SpartanWeaponryAPI.createDagger(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(dagger,"dagger_" + mat.material.getUnlocName());
                item_set.add(dagger);
            }
            if (!ConfigHandler.disableSpear) {
                Item spear = SpartanWeaponryAPI.createSpear(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(spear,"spear_" + mat.material.getUnlocName());
                item_set.add(spear);
            }
            if (!ConfigHandler.disablePike) {
                Item pike = SpartanWeaponryAPI.createPike(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(pike, "pike_" + mat.material.getUnlocName());
                item_set.add(pike);
            }
            if (!ConfigHandler.disableLance) {
                Item lance = SpartanWeaponryAPI.createLance(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(lance, "lance_" + mat.material.getUnlocName());
                item_set.add(lance);
            }
            if (!ConfigHandler.disableHalberd) {
                Item halberd = SpartanWeaponryAPI.createHalberd(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(halberd, "halberd_" + mat.material.getUnlocName());
                item_set.add(halberd);
            }
            if (!ConfigHandler.disableWarhammer) {
                Item warhammer = SpartanWeaponryAPI.createWarhammer(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(warhammer, "warhammer_" + mat.material.getUnlocName());
                item_set.add(warhammer);
            }
            if (!ConfigHandler.disableHammer) {
                Item hammer = SpartanWeaponryAPI.createHammer(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(hammer,"hammer_" + mat.material.getUnlocName());
                item_set.add(hammer);
            }
            if (!ConfigHandler.disableThrowingAxe) {
                Item throwing_axe = SpartanWeaponryAPI.createThrowingAxe(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(throwing_axe,
                        "throwing_axe_" + mat.material.getUnlocName());
                item_set.add(throwing_axe);
            }
            if (!ConfigHandler.disableThrowingKnife) {
                Item throwing_knife = SpartanWeaponryAPI.createThrowingKnife(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(throwing_knife,
                        "throwing_knife_" + mat.material.getUnlocName());
                item_set.add(throwing_knife);
            }
            if (!ConfigHandler.disableLongbow && !ConfigHandler.woodenLongbowOnly) {
				Item longbow = SpartanWeaponryAPI.createLongbow(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        null
            	);
            	
                ModelRenderRegistryST.addItemToRegistry(longbow, "longbow_" + mat.material.getUnlocName());
                item_set.add(longbow);
            }
            if (!ConfigHandler.disableCrossbow && !ConfigHandler.woodenCrossbowOnly) {
                Item crossbow = SpartanWeaponryAPI.createCrossbow(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        null
                );

                ModelRenderRegistryST.addItemToRegistry(crossbow,"crossbow_" + mat.material.getUnlocName());
                item_set.add(crossbow);
            }
            if (!ConfigHandler.disableJavelin) {
                Item javelin = SpartanWeaponryAPI.createJavelin(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(javelin,"javelin_" + mat.material.getUnlocName());
                item_set.add(javelin);
            }
            if (!ConfigHandler.disableBattleaxe) {
                Item battleaxe = SpartanWeaponryAPI.createBattleaxe(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(battleaxe, "battleaxe_" + mat.material.getUnlocName());
                item_set.add(battleaxe);

            }
            if (!ConfigHandler.disableBoomerang && !ConfigHandler.woodenBoomerangOnly) {
                Item boomerang = SpartanWeaponryAPI.createBoomerang(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(boomerang,
                        "boomerang_" + mat.material.getUnlocName());
                item_set.add(boomerang);
            }
            if (!ConfigHandler.disableMace) {
                Item mace = SpartanWeaponryAPI.createMace(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(mace, "mace_" + mat.material.getUnlocName());
                item_set.add(mace);
            }
            if (!ConfigHandler.disableQuarterstaff){
                Item quarterstaff = SpartanWeaponryAPI.createQuarterstaff(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(quarterstaff, "staff_" + mat.material.getUnlocName());
                item_set.add(quarterstaff);
            }
            if (!ConfigHandler.disableGlaive){
                Item glaive = SpartanWeaponryAPI.createGlaive(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(glaive, "glaive_" + mat.material.getUnlocName());
                item_set.add(glaive);
            }
            if (!ConfigHandler.disableParryingDagger){
            	Item parrying_dagger = SpartanWeaponryAPI.createParryingDagger(
                        mat.material,
                        Reference.modid,
                        CreativeTabsSW.TAB_SW_MOD,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistryST.addItemToRegistry(parrying_dagger, "parrying_dagger_" + mat.material.getUnlocName());
                item_set.add(parrying_dagger);
            }
        }
        for (Item it : item_set){
            ev.getRegistry().register(it);
        }
        ALL_ITEMS.forEach(ev.getRegistry()::register);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ALL_ITEMS.stream()
                .filter(item -> item.getRegistryName() != null)
                .forEach(item ->
                        ModelLoader.setCustomModelResourceLocation(item, 0,
                                new ModelResourceLocation(item.getRegistryName(), "inventory")));
    }
}
