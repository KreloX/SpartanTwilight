package krelox.spartantwilight.data;

import com.oblivioussp.spartanweaponry.data.ModWeaponTraitTagsProvider;
import krelox.spartantwilight.SpartanTwilight;
import krelox.spartantwilight.item.STItems.Material;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class STWeaponTraitTagData extends ModWeaponTraitTagsProvider {

    public STWeaponTraitTagData(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Material.IRONWOOD.material.getTraitsTag());
        tag(Material.STEELEAF.material.getTraitsTag());
        tag(Material.KNIGHTMETAL.material.getTraitsTag()).add(SpartanTwilight.KNIGHTMETAL.get());
        tag(Material.FIERY.material.getTraitsTag()).add(SpartanTwilight.FIERY.get());
    }
}
