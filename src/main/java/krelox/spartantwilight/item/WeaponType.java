package krelox.spartantwilight.item;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.data.model.ModelGenerator;
import com.oblivioussp.spartanweaponry.api.data.recipe.RecipeProviderHelper;
import com.oblivioussp.spartanweaponry.api.tags.ModItemTags;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public enum WeaponType {
    DAGGER(ModItemTags.DAGGERS, SpartanWeaponryAPI::createDagger, ModelGenerator::createDaggerModels, (consumer, material) ->
            RecipeProviderHelper.recipeDagger(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("DAGGER")).get(), "has_item")),
    LONGSWORD(ModItemTags.LONGSWORDS, SpartanWeaponryAPI::createLongsword, ModelGenerator::createLongswordModel, (consumer, material) ->
            RecipeProviderHelper.recipeLongsword(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("LONGSWORD")).get(), "has_item")),
    KATANA(ModItemTags.KATANAS, SpartanWeaponryAPI::createKatana, ModelGenerator::createKatanaModel, (consumer, material) ->
            RecipeProviderHelper.recipeKatana(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("KATANA")).get(), "has_item")),
    SABER(ModItemTags.SABERS, SpartanWeaponryAPI::createSaber, ModelGenerator::createSaberModel, (consumer, material) ->
            RecipeProviderHelper.recipeSaber(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("SABER")).get(), "has_item")),
    RAPIER(ModItemTags.RAPIERS, SpartanWeaponryAPI::createRapier, ModelGenerator::createRapierModel, (consumer, material) ->
            RecipeProviderHelper.recipeRapier(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("RAPIER")).get(), "has_item")),
    GREATSWORD(ModItemTags.GREATSWORDS, SpartanWeaponryAPI::createGreatsword, ModelGenerator::createGreatswordModel, (consumer, material) ->
            RecipeProviderHelper.recipeGreatsword(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("GREATSWORD")).get(), "has_item")),
    BATTLE_HAMMER(ModItemTags.BATTLE_HAMMERS, SpartanWeaponryAPI::createBattleHammer, ModelGenerator::createBattleHammerModel, (consumer, material) ->
            RecipeProviderHelper.recipeBattleHammer(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("BATTLE_HAMMER")).get(), "has_item")),
    WARHAMMER(ModItemTags.WARHAMMERS, SpartanWeaponryAPI::createWarhammer, ModelGenerator::createWarhammerModel, (consumer, material) ->
            RecipeProviderHelper.recipeWarhammer(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("WARHAMMER")).get(), "has_item")),
    SPEAR(ModItemTags.SPEARS, SpartanWeaponryAPI::createSpear, ModelGenerator::createSpearModel, (consumer, material) ->
            RecipeProviderHelper.recipeSpear(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("SPEAR")).get(), "has_item")),
    HALBERD(ModItemTags.HALBERDS, SpartanWeaponryAPI::createHalberd, ModelGenerator::createHalberdModel, (consumer, material) ->
            RecipeProviderHelper.recipeHalberd(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("HALBERD")).get(), "has_item")),
    PIKE(ModItemTags.PIKES, SpartanWeaponryAPI::createPike, ModelGenerator::createPikeModel, (consumer, material) ->
            RecipeProviderHelper.recipePike(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("PIKE")).get(), "has_item")),
    LANCE(ModItemTags.LANCES, SpartanWeaponryAPI::createLance, ModelGenerator::createLanceModel, (consumer, material) ->
            RecipeProviderHelper.recipeLance(consumer, material.getHandle(), material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("LANCE")).get(), "has_item")),
    LONGBOW(ModItemTags.LONGBOWS, SpartanWeaponryAPI::createLongbow, ModelGenerator::createLongbowModels, (consumer, material) ->
            RecipeProviderHelper.recipeLongbow(consumer, material.getStick(), material.getString(), material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("LONGBOW")).get(), "has_item")),
    HEAVY_CROSSBOW(ModItemTags.HEAVY_CROSSBOWS, SpartanWeaponryAPI::createHeavyCrossbow, ModelGenerator::createHeavyCrossbowModels, (consumer, material) ->
            RecipeProviderHelper.recipeHeavyCrossbow(consumer, material.getPlanks(), material.getBow(), material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("HEAVY_CROSSBOW")).get(), "has_item")),
    THROWING_KNIFE(ModItemTags.THROWING_KNIVES, SpartanWeaponryAPI::createThrowingKnife, ModelGenerator::createThrowingKnifeModels, (consumer, material) ->
            RecipeProviderHelper.recipeThrowingKnife(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("THROWING_KNIFE")).get(), "has_item")),
    TOMAHAWK(ModItemTags.TOMAHAWKS, SpartanWeaponryAPI::createTomahawk, ModelGenerator::createTomahawkModels, (consumer, material) ->
            RecipeProviderHelper.recipeTomahawk(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("TOMAHAWK")).get(), "has_item")),
    JAVELIN(ModItemTags.JAVELINS, SpartanWeaponryAPI::createJavelin, ModelGenerator::createJavelinModels, (consumer, material) ->
            RecipeProviderHelper.recipeJavelin(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("JAVELIN")).get(), "has_item")),
    BOOMERANG(ModItemTags.BOOMERANGS, SpartanWeaponryAPI::createBoomerang, ModelGenerator::createBoomerangModels, (consumer, material) ->
            RecipeProviderHelper.recipeBoomerang(consumer, material.getPlanks(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("BOOMERANG")).get(), "has_item")),
    BATTLEAXE(ModItemTags.BATTLEAXES, SpartanWeaponryAPI::createBattleaxe, ModelGenerator::createBattleaxeModel, (consumer, material) ->
            RecipeProviderHelper.recipeBattleaxe(consumer, material.getStick(), material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("BATTLEAXE")).get(), "has_item")),
    FLANGED_MACE(ModItemTags.FLANGED_MACES, SpartanWeaponryAPI::createFlangedMace, ModelGenerator::createFlangedMaceModel, (consumer, material) ->
            RecipeProviderHelper.recipeFlangedMace(consumer, material.getStick(), material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("FLANGED_MACE")).get(), "has_item")),
    GLAIVE(ModItemTags.GLAIVES, SpartanWeaponryAPI::createGlaive, ModelGenerator::createGlaiveModel, (consumer, material) ->
            RecipeProviderHelper.recipeGlaive(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("GLAIVE")).get(), "has_item")),
    QUARTERSTAFF(ModItemTags.QUARTERSTAVES, SpartanWeaponryAPI::createQuarterstaff, ModelGenerator::createQuarterstaffModel, (consumer, material) ->
            RecipeProviderHelper.recipeQuarterstaff(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("QUARTERSTAFF")).get(), "has_item")),
    SCYTHE(ModItemTags.SCYTHES, SpartanWeaponryAPI::createScythe, ModelGenerator::createScytheModel, (consumer, material) ->
            RecipeProviderHelper.recipeScythe(consumer, material.getPole(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("SCYTHE")).get(), "has_item")),
    PARRYING_DAGGER(ModItemTags.PARRYING_DAGGERS, SpartanWeaponryAPI::createParryingDagger, ModelGenerator::createParryingDaggerModels, (consumer, material) ->
            RecipeProviderHelper.recipeParryingDagger(consumer, material.getHandle(), material.material.getRepairTag(), STItems.getWeapon(material, valueOf("PARRYING_DAGGER")).get(), "has_item"));

    public final TagKey<Item> tag;
    public final BiFunction<WeaponMaterial, CreativeModeTab, Item> createItem;
    public final BiFunction<ModelGenerator, Item, ResourceLocation> createModel;
    public final BiConsumer<Consumer<FinishedRecipe>, STItems.Material> recipe;

    WeaponType(TagKey<Item> tag, BiFunction<WeaponMaterial, CreativeModeTab, Item> createItem, BiFunction<ModelGenerator, Item, ResourceLocation> createModel, BiConsumer<Consumer<FinishedRecipe>, STItems.Material> recipe) {
        this.tag = tag;
        this.createItem = createItem;
        this.createModel = createModel;
        this.recipe = recipe;
    }
}
