package de.pilz.mystcraftextras;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class MystcraftExtrasLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.mystcraftextras.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> list = new ArrayList<String>();

        // Mystcraft
        if (loadedMods.contains("Mystcraft")) {
            list.add("MixinLinkingAPIDelegate");
        }

        // Tinkers Construct
        if (loadedMods.contains("TConstruct")) {
            list.add("MixinToolStationLogic");
        }

        return list;
    }
}
