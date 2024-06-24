package krelox.spartantwilight.data;

import it.unimi.dsi.fastutil.ints.IntIntPair;
import krelox.spartantwilight.SpartanTwilight;
import krelox.spartantwilight.item.STItems;
import krelox.spartantwilight.item.WeaponType;
import net.minecraft.Util;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.data.tags.ItemTagGenerator;

import java.util.EnumMap;
import java.util.Objects;
import java.util.function.Consumer;

public class STRecipeData extends RecipeProvider {
    public STRecipeData(DataGenerator gen) {
        super(gen);
    }

    private static final EnumMap<WeaponType, IntIntPair> MATERIALS_BY_TYPE = Util.make(new EnumMap<>(WeaponType.class), map -> {
        map.put(WeaponType.DAGGER, IntIntPair.of(1, 1));
        map.put(WeaponType.LONGSWORD, IntIntPair.of(1, 4));
        map.put(WeaponType.KATANA, IntIntPair.of(1, 2));
        map.put(WeaponType.SABER, IntIntPair.of(1, 3));
        map.put(WeaponType.RAPIER, IntIntPair.of(1, 4));
        map.put(WeaponType.GREATSWORD, IntIntPair.of(1, 6));
        map.put(WeaponType.BATTLE_HAMMER, IntIntPair.of(1, 6));
        map.put(WeaponType.WARHAMMER, IntIntPair.of(1, 3));
        map.put(WeaponType.SPEAR, IntIntPair.of(2, 1));
        map.put(WeaponType.HALBERD, IntIntPair.of(2, 4));
        map.put(WeaponType.PIKE, IntIntPair.of(4, 1));
        map.put(WeaponType.LANCE, IntIntPair.of(3, 3));
        map.put(WeaponType.LONGBOW, IntIntPair.of(1, 2));
        map.put(WeaponType.HEAVY_CROSSBOW, IntIntPair.of(1, 2));
        map.put(WeaponType.THROWING_KNIFE, IntIntPair.of(1, 1));
        map.put(WeaponType.TOMAHAWK, IntIntPair.of(1, 2));
        map.put(WeaponType.JAVELIN, IntIntPair.of(2, 1));
        map.put(WeaponType.BOOMERANG, IntIntPair.of(0, 1));
        map.put(WeaponType.BATTLEAXE, IntIntPair.of(1, 5));
        map.put(WeaponType.FLANGED_MACE, IntIntPair.of(1, 3));
        map.put(WeaponType.GLAIVE, IntIntPair.of(2, 3));
        map.put(WeaponType.QUARTERSTAFF, IntIntPair.of(2, 1));
        map.put(WeaponType.SCYTHE, IntIntPair.of(2, 3));
        map.put(WeaponType.PARRYING_DAGGER, IntIntPair.of(1, 2));
    });

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(STItems.BLAZE_POLE.get()).define('#', Items.BLAZE_ROD)
                .pattern(" #")
                .pattern("# ")
                .unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD))
                .save(consumer);

        STItems.WEAPONS.forEach((key, item) -> {
            var material = key.first();
            var type = key.second();
            type.recipe.accept(consumer, material);
            if (material.equals(STItems.Material.FIERY)) {
                ShapelessRecipeBuilder.shapeless(item.get())
                        .requires(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(SpartanTwilight.swId("iron_" + type.toString().toLowerCase()))))
                        .requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL), MATERIALS_BY_TYPE.get(type).secondInt())
                        .requires(Ingredient.of(Tags.Items.RODS_BLAZE), MATERIALS_BY_TYPE.get(type).firstInt())
                        .unlockedBy("has_item", has(ItemTagGenerator.FIERY_VIAL))
                        .save(consumer, SpartanTwilight.id(item.get().getRegistryName().getPath() + "_vial"));
            }
        });
    }
}
