package krelox.spartantwilight;

import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.data.model.ModelGenerator;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.init.ModEnchantments;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import krelox.spartantoolkit.*;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.data.tags.ItemTagGenerator;
import twilightforest.util.TwilightItemTier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

@Mod(SpartanTwilight.MODID)
public class SpartanTwilight extends SpartanAddon {
    public static final String MODID = "spartantwilight";

    public static final WeaponMap WEAPONS = new WeaponMap();
    public static final DeferredRegister<Item> ITEMS = itemRegister(MODID);
    public static final DeferredRegister<WeaponTrait> TRAITS = traitRegister(MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = tabRegister(MODID);

    public static final RegistryObject<Item> BLAZE_POLE = ITEMS.register("blaze_pole", () -> new Item(new Item.Properties()));

    // Traits
    public static final RegistryObject<WeaponTrait> COMBAT_SKILLED = registerTrait(TRAITS,
            new BetterWeaponTrait("combat_skilled", MODID, WeaponTrait.TraitQuality.POSITIVE) {
                private static final int KNIGHTMETAL_BONUS_DAMAGE = 2;

                @Override
                public float modifyDamageDealt(WeaponMaterial material, float baseDamage, DamageSource source, LivingEntity attacker, LivingEntity victim) {
                    if (!(victim.level() instanceof ServerLevel world)) return baseDamage;
                    if (attacker.swinging) return baseDamage;

                    WeaponItem weapon = (WeaponItem) attacker.getMainHandItem().getItem();

                    if (weapon.getMaterial().getBonusTraits().contains(SpartanTwilight.COMBAT_SKILLED.get()) && victim.getArmorValue() > 0) {
                        // enchantment attack sparkles
                        world.getChunkSource().broadcastAndSend(victim, new ClientboundAnimatePacket(victim, 5));
                        if (victim.getArmorCoverPercentage() > 0) {
                            int moreBonus = (int) (KNIGHTMETAL_BONUS_DAMAGE * victim.getArmorCoverPercentage());
                            return baseDamage + moreBonus;
                        } else {
                            return baseDamage + KNIGHTMETAL_BONUS_DAMAGE;
                        }
                    }
                    return baseDamage;
                }
            }.setUniversal(false));
    public static final RegistryObject<WeaponTrait> BLAZING = registerTrait(TRAITS,
            new BetterWeaponTrait("blazing", MODID, WeaponTrait.TraitQuality.POSITIVE) {
                @Override
                public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
                    if (!(target.level() instanceof ServerLevel world)) return;

                    WeaponItem weapon = (WeaponItem) stack.getItem();

                    if (weapon.getMaterial().getBonusTraits().contains(SpartanTwilight.BLAZING.get())) {
                        if (!target.fireImmune()) {
                            target.setSecondsOnFire(15);
                        } else {
                            for (int i = 0; i < 20; ++i) {
                                double px = target.getX() + world.getRandom().nextFloat() * target.getBbWidth() * 2.0F - target.getBbWidth();
                                double py = target.getY() + world.getRandom().nextFloat() * target.getBbHeight();
                                double pz = target.getZ() + world.getRandom().nextFloat() * target.getBbWidth() * 2.0F - target.getBbWidth();
                                world.sendParticles(ParticleTypes.FLAME, px, py, pz, 0, 0.02, 0.02, 0.02, 1);
                            }
                        }
                    }
                }
            }.setUniversal(false));

    // Materials
    public static final SpartanMaterial IRONWOOD = new SpartanMaterial("ironwood", MODID, TwilightItemTier.IRONWOOD, ItemTagGenerator.IRONWOOD_INGOTS, Set.of(), Map.of(() -> Enchantments.KNOCKBACK, 1, () -> Enchantments.BLOCK_FORTUNE, 1, ModEnchantments.PROPEL, 1, () -> Enchantments.PUNCH_ARROWS, 1));
    public static final SpartanMaterial STEELEAF = new SpartanMaterial("steeleaf", MODID, TwilightItemTier.STEELEAF, ItemTagGenerator.STEELEAF_INGOTS, Set.of(), Map.of(() -> Enchantments.MOB_LOOTING, 2, () -> Enchantments.BLOCK_EFFICIENCY, 2, ModEnchantments.LUCKY_THROW, 2, () -> Enchantments.QUICK_CHARGE, 2));
    public static final SpartanMaterial KNIGHTMETAL = new SpartanMaterial("knightmetal", MODID, TwilightItemTier.KNIGHTMETAL, ItemTagGenerator.KNIGHTMETAL_INGOTS, COMBAT_SKILLED);
    public static final SpartanMaterial FIERY = new SpartanMaterial("fiery", MODID, TwilightItemTier.FIERY, ItemTagGenerator.FIERY_INGOTS, BLAZING)
            .setRarity(Rarity.UNCOMMON).setHandle(() -> Items.BLAZE_ROD).setPole(BLAZE_POLE);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> SPARTAN_TWILIGHT_TAB = registerTab(TABS, MODID, () -> WEAPONS.get(KNIGHTMETAL, WeaponType.GREATSWORD).get(),
            (parameters, output) -> ITEMS.getEntries().forEach(item -> output.accept(item.get())));

    public SpartanTwilight() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        registerSpartanWeapons(ITEMS);
        ITEMS.register(bus);
        TRAITS.register(bus);
        TABS.register(bus);
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
    @SuppressWarnings("DataFlowIssue")
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        super.buildCraftingRecipes(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BLAZE_POLE.get()).define('#', Items.BLAZE_ROD)
                .pattern(" #")
                .pattern("# ")
                .unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD))
                .save(consumer);

        WEAPONS.forEach((key, item) -> {
            SpartanMaterial material = key.first();
            WeaponType type = key.second();
            if (material.equals(FIERY)) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item.get())
                        .requires(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModSpartanWeaponry.ID, "iron_" + type.name().toLowerCase())))
                        .requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL), MATERIAL_COUNTS.get(type).secondInt())
                        .requires(Ingredient.of(Tags.Items.RODS_BLAZE), MATERIAL_COUNTS.get(type).firstInt())
                        .unlockedBy("has_item", has(ItemTagGenerator.FIERY_VIAL))
                        .save(consumer, new ResourceLocation(MODID, ForgeRegistries.ITEMS.getKey(item.get()).getPath() + "_vial"));
            }
        });
    }

    private static final EnumMap<WeaponType, IntIntPair> MATERIAL_COUNTS = Util.make(new EnumMap<>(WeaponType.class), map -> {
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
    protected Map<RegistryObject<WeaponTrait>, String> getTraitDescriptions() {
        return Map.of(
                COMBAT_SKILLED, "Extra damage to armored targets",
                BLAZING, "Burns targets"
        );
    }

    @Override
    public String modid() {
        return MODID;
    }

    @Override
    public List<SpartanMaterial> getMaterials() {
        return List.of(IRONWOOD, FIERY, STEELEAF, KNIGHTMETAL);
    }

    @Override
    public WeaponMap getWeaponMap() {
        return WEAPONS;
    }
}
