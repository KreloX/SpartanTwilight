package krelox.spartantwilight.data;

import com.oblivioussp.spartanweaponry.api.data.model.ModelGenerator;
import krelox.spartantwilight.SpartanTwilight;
import krelox.spartantwilight.item.STItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class STItemModelData extends ItemModelProvider {
    public STItemModelData(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SpartanTwilight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        final ModelGenerator generator = new ModelGenerator(this);

        generator.createSimpleModel(STItems.BLAZE_POLE.get(), SpartanTwilight.swId("item/base/pole"));

        STItems.WEAPONS.forEach((key, item) -> key.second().createModel.apply(generator, item.get()));
    }
}
