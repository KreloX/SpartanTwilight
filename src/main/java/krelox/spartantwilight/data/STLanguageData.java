package krelox.spartantwilight.data;

import krelox.spartantwilight.SpartanTwilight;
import krelox.spartantwilight.item.STItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class STLanguageData extends LanguageProvider {
    public STLanguageData(DataGenerator gen) {
        super(gen, SpartanTwilight.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.spartantwilight", "Spartan Weaponry: Twilight Forest");

        STItems.ITEMS.getEntries().forEach((item) -> add(item.get(), formatName(item)));
        add("tooltip.spartantwilight.trait.fiery", "Blazing");
        add("tooltip.spartantwilight.trait.fiery.desc", "Burns targets on hit");
        add("tooltip.spartantwilight.trait.knightmetal", "Combat Skilled");
        add("tooltip.spartantwilight.trait.knightmetal.desc", "Deals extra damage to armored targets");
    }

    private String formatName(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().replace("_heavy", "-Strengthened_heavy").split("_"))
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.joining(" "));
    }
}
