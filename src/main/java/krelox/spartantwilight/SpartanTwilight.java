package krelox.spartantwilight;

import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import com.oblivioussp.spartanweaponry.api.data.model.ModelGenerator;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.init.ModEnchantments;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import krelox.spartantoolkit.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.data.tags.ItemTagGenerator;
import twilightforest.util.TwilightItemTier;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

@Mod(SpartanTwilight.MODID)
public class SpartanTwilight extends SpartanAddon {
    public static final String MODID = "spartantwilight";

    public static final WeaponMap WEAPONS = new WeaponMap();
    public static final DeferredRegister<Item> ITEMS = itemRegister(MODID);
    public static final DeferredRegister<WeaponTrait> WEAPON_TRAITS = traitRegister(MODID);

    // Traits
    public static final RegistryObject<WeaponTrait> COMBAT_SKILLED = registerTrait(WEAPON_TRAITS,
            new WeaponTrait("combat_skilled", MODID, WeaponTrait.TraitQuality.POSITIVE).setUniversal(false));
    public static final RegistryObject<WeaponTrait> BLAZING = registerTrait(WEAPON_TRAITS,
            new WeaponTrait("blazing", MODID, WeaponTrait.TraitQuality.POSITIVE).setUniversal(false));

    // Materials
    public static final SpartanMaterial IRONWOOD = new SpartanMaterial("ironwood", MODID, TwilightItemTier.IRONWOOD, ItemTagGenerator.IRONWOOD_INGOTS, Set.of(), Map.of(() -> Enchantments.KNOCKBACK, 1, () -> Enchantments.BLOCK_FORTUNE, 1, ModEnchantments.PROPEL, 1, () -> Enchantments.PUNCH_ARROWS, 1));
    public static final SpartanMaterial STEELEAF = new SpartanMaterial("steeleaf", MODID, TwilightItemTier.STEELEAF, ItemTagGenerator.STEELEAF_INGOTS, Set.of(), Map.of(() -> Enchantments.MOB_LOOTING, 2, () -> Enchantments.BLOCK_EFFICIENCY, 2, ModEnchantments.LUCKY_THROW, 2, () -> Enchantments.QUICK_CHARGE, 2));
    public static final SpartanMaterial KNIGHTMETAL = new SpartanMaterial("knightmetal", MODID, TwilightItemTier.KNIGHTMETAL, ItemTagGenerator.KNIGHTMETAL_INGOTS, Set.of(COMBAT_SKILLED), Map.of());
    public static final SpartanMaterial FIERY = new SpartanMaterial("fiery", MODID, TwilightItemTier.FIERY, ItemTagGenerator.FIERY_INGOTS, Set.of(BLAZING), Map.of()) {
        @Override
        public ItemLike getHandle() {
            return Items.BLAZE_ROD;
        }

        @Override
        public ItemLike getPole() {
            return BLAZE_POLE.get();
        }
    };

    public static final CreativeModeTab SPARTAN_TWILIGHT_TAB = tab(MODID, () -> WEAPONS.get(KNIGHTMETAL, WeaponType.GREATSWORD).get());

    public static final RegistryObject<Item> BLAZE_POLE = ITEMS.register("blaze_pole", () -> new Item(new Item.Properties().tab(SPARTAN_TWILIGHT_TAB)));

    public SpartanTwilight() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        traitDescriptions.put(COMBAT_SKILLED, "Deals extra damage to armored targets");
        traitDescriptions.put(BLAZING, "Burns targets on hit");
        registerSpartanWeapons(ITEMS);
        ITEMS.register(bus);
        WEAPON_TRAITS.register(bus);
    }

    @SubscribeEvent
    public void itemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof WeaponItem weapon && weapon.getMaterial().equals(FIERY)) {
            List<Component> tooltip = event.getToolTip();
            tooltip.set(0, tooltip.get(0).copy().withStyle(ChatFormatting.YELLOW));
        }
    }

    @Override
    protected void addTranslations(LanguageProvider provider, Function<RegistryObject<?>, String> formatName) {
        super.addTranslations(provider, formatName);
        provider.add(BLAZE_POLE.get(), "Blaze Pole");
    }

    @Override
    protected void registerModels(ItemModelProvider provider, ModelGenerator generator) {
        super.registerModels(provider, generator);
        generator.createSimpleModel(BLAZE_POLE.get(), new ResourceLocation(ModSpartanWeaponry.ID, "item/base/pole"));
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        super.buildCraftingRecipes(consumer);

        ShapedRecipeBuilder.shaped(BLAZE_POLE.get()).define('#', Items.BLAZE_ROD)
                .pattern(" #")
                .pattern("# ")
                .unlockedBy("has_blaze_rod", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Items.BLAZE_ROD).build()))
                .save(consumer);

        WEAPONS.forEach((key, item) -> {
            var material = key.first();
            var type = key.second();
            if (material.equals(FIERY)) {
                ShapelessRecipeBuilder.shapeless(item.get())
                        .requires(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModSpartanWeaponry.ID, "iron_" + type.toString().toLowerCase()))))
                        .requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL), MATERIALS_BY_TYPE.get(type).secondInt())
                        .requires(Ingredient.of(Tags.Items.RODS_BLAZE), MATERIALS_BY_TYPE.get(type).firstInt())
                        .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.FIERY_VIAL).build()))
                        .save(consumer, new ResourceLocation(MODID, item.get().getRegistryName().getPath() + "_vial"));
            }
        });
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
    public String modid() {
        return MODID;
    }

    @Override
    public List<SpartanMaterial> getMaterials() {
        return List.of(IRONWOOD, FIERY, STEELEAF, KNIGHTMETAL);
    }

    @Override
    public CreativeModeTab getTab() {
        return SPARTAN_TWILIGHT_TAB;
    }

    @Override
    public WeaponMap getWeaponMap() {
        return WEAPONS;
    }
}
