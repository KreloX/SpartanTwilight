package krelox.spartantwilight.item;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.tags.ModWeaponTraitTags;
import com.oblivioussp.spartanweaponry.init.ModEnchantments;
import com.oblivioussp.spartanweaponry.init.ModItems;
import it.unimi.dsi.fastutil.Pair;
import krelox.spartantwilight.SpartanTwilight;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.data.tags.ItemTagGenerator;
import twilightforest.util.TwilightItemTier;

import java.util.HashMap;

public class STItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpartanTwilight.MODID);
    public static final HashMap<Pair<Material, WeaponType>, RegistryObject<Item>> WEAPONS = new HashMap<>();

    public static final RegistryObject<Item> BLAZE_POLE = ITEMS.register("blaze_pole", () -> new Item(new Item.Properties().tab(SpartanTwilight.SPARTAN_TWILIGHT_TAB)));

    static {
        for (Material material : Material.values()) {
            for (WeaponType type : WeaponType.values()) {
                registerWeapon(material, type);
            }
        }
    }

    public static RegistryObject<Item> getWeapon(Material material, WeaponType type) {
        return WEAPONS.get(Pair.of(material, type));
    }

    private static void registerWeapon(Material material, WeaponType type) {
        WEAPONS.put(Pair.of(material, type), ITEMS.register(material.material.getMaterialName() + "_" + type.toString().toLowerCase(), () ->
                type.createItem.apply(material.material, SpartanTwilight.SPARTAN_TWILIGHT_TAB)));
    }

    public enum Material {
        IRONWOOD(new WeaponMaterial("ironwood", SpartanTwilight.MODID, TwilightItemTier.IRONWOOD, ItemTagGenerator.IRONWOOD_INGOTS, ModWeaponTraitTags.create(SpartanTwilight.id("ironwood"))), Pair.of(Lazy.of(() -> Enchantments.KNOCKBACK), 1), Pair.of(Lazy.of(() -> Enchantments.BLOCK_FORTUNE), 1), Pair.of(Lazy.of(ModEnchantments.PROPEL), 1), Pair.of(Lazy.of(() -> Enchantments.PUNCH_ARROWS), 1)),
        STEELEAF(new WeaponMaterial("steeleaf", SpartanTwilight.MODID, TwilightItemTier.STEELEAF, ItemTagGenerator.STEELEAF_INGOTS, ModWeaponTraitTags.create(SpartanTwilight.id("steeleaf"))), Pair.of(Lazy.of(() -> Enchantments.MOB_LOOTING), 2), Pair.of(Lazy.of(() -> Enchantments.BLOCK_EFFICIENCY), 2), Pair.of(Lazy.of(ModEnchantments.LUCKY_THROW), 2), Pair.of(Lazy.of(() -> Enchantments.QUICK_CHARGE), 2)),
        KNIGHTMETAL(new WeaponMaterial("knightmetal", SpartanTwilight.MODID, TwilightItemTier.KNIGHTMETAL, ItemTagGenerator.KNIGHTMETAL_INGOTS, ModWeaponTraitTags.create(SpartanTwilight.id("knightmetal")))),
        FIERY(new WeaponMaterial("fiery", SpartanTwilight.MODID, TwilightItemTier.FIERY, ItemTagGenerator.FIERY_INGOTS, ModWeaponTraitTags.create(SpartanTwilight.id("fiery")))) {
            @Override
            public ItemLike getHandle() {
                return Items.BLAZE_ROD;
            }

            @Override
            public ItemLike getPole() {
                return BLAZE_POLE.get();
            }
        };

        public final WeaponMaterial material;
        public final Pair<Lazy<Enchantment>, Integer>[] enchantments;

        @SafeVarargs
        Material(WeaponMaterial material, Pair<Lazy<Enchantment>, Integer>... enchantments) {
            this.material = material;
            this.enchantments = enchantments;
        }

        public TagKey<Item> getPlanks() {
            return ItemTags.PLANKS;
        }

        public TagKey<Item> getStick() {
            return Tags.Items.RODS_WOODEN;
        }

        public TagKey<Item> getString() {
            return Tags.Items.STRING;
        }

        public ItemLike getBow() {
            return Items.BOW;
        }

        public ItemLike getHandle() {
            return ModItems.HANDLE.get();
        }

        public ItemLike getPole() {
            return ModItems.POLE.get();
        }
    }
}
