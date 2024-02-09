package de.pilz.mystcraftextras.configuration;

import com.gtnewhorizon.gtnhlib.config.Config;
import com.gtnewhorizon.gtnhlib.config.Config.Comment;
import com.gtnewhorizon.gtnhlib.config.Config.DefaultBoolean;
import com.gtnewhorizon.gtnhlib.config.Config.RequiresMcRestart;

import de.pilz.mystcraftextras.MystcraftExtras;

@Config(modid = MystcraftExtras.MODID, category = "tweaks")
public class TweaksConfig {

    @Comment("Enables Intra Linking on newly created linking books by default.")
    @DefaultBoolean(true)
    public static boolean enableIntraLinkingByDefault;

    @Comment("Enables the ability to rename Linking Books on a Tool Station from Tinkers Construct.")
    @DefaultBoolean(true)
    @RequiresMcRestart
    public static boolean enableRenameOnTinkerToolStation;
}
