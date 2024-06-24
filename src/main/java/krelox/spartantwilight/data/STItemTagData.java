package krelox.spartantwilight.data;

import krelox.spartantwilight.item.STItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class STItemTagData extends ItemTagsProvider {
    public STItemTagData(DataGenerator generator, BlockTagsProvider blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        STItems.WEAPONS.forEach((key, item) -> tag(key.second().tag).add(item.get()));
    }
}
