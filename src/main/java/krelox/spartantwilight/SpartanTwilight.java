package krelox.spartantwilight;

import com.oblivioussp.spartanweaponry.ModSpartanWeaponry;
import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import krelox.spartantwilight.data.*;
import krelox.spartantwilight.item.STItems;
import krelox.spartantwilight.item.WeaponType;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(SpartanTwilight.MODID)
public class SpartanTwilight {
    public static final String MODID = "spartantwilight";

    public static final DeferredRegister<WeaponTrait> WEAPON_TRAITS = DeferredRegister.create(WeaponTraits.REGISTRY_KEY, SpartanTwilight.MODID);

    public static final RegistryObject<WeaponTrait> FIERY = WEAPON_TRAITS.register("fiery", () ->
            new WeaponTrait("fiery", SpartanTwilight.MODID, WeaponTrait.TraitQuality.POSITIVE).setUniversal(false));
    public static final RegistryObject<WeaponTrait> KNIGHTMETAL = WEAPON_TRAITS.register("knightmetal", () ->
            new WeaponTrait("knightmetal", SpartanTwilight.MODID, WeaponTrait.TraitQuality.POSITIVE).setUniversal(false));

    public static final CreativeModeTab SPARTAN_TWILIGHT_TAB = new CreativeModeTab("spartantwilight") {
        public ItemStack makeIcon() {
            return new ItemStack(STItems.getWeapon(STItems.Material.KNIGHTMETAL, WeaponType.GREATSWORD).get());
        }
    };

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MODID, path);
    }

    public static ResourceLocation swId(String path) {
        return new ResourceLocation(ModSpartanWeaponry.ID, path);
    }

    public SpartanTwilight() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::gatherData);

        WEAPON_TRAITS.register(bus);
        STItems.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var fileHelper = event.getExistingFileHelper();

        generator.addProvider(new STLanguageData(generator));
        generator.addProvider(new STWeaponTraitTagData(generator, fileHelper));
        generator.addProvider(new STItemTagData(generator, new BlockTagsProvider(generator, MODID, fileHelper), MODID, fileHelper));
        generator.addProvider(new STItemModelData(generator, fileHelper));
        generator.addProvider(new STRecipeData(generator));
    }
}
