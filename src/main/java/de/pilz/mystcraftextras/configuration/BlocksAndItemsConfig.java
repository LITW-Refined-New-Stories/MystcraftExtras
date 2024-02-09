package de.pilz.mystcraftextras.configuration;

import com.gtnewhorizon.gtnhlib.config.Config;
import com.gtnewhorizon.gtnhlib.config.Config.Comment;
import com.gtnewhorizon.gtnhlib.config.Config.DefaultBoolean;
import com.gtnewhorizon.gtnhlib.config.Config.RequiresMcRestart;

import de.pilz.mystcraftextras.MystcraftExtras;

@Config(modid = MystcraftExtras.MODID, category = "blocksAndItems")
public class BlocksAndItemsConfig {

    @Comment("Enables some different textured variants of book stands.")
    @DefaultBoolean(true)
    @RequiresMcRestart
    public static boolean enableAdditionalBookStands;
}
