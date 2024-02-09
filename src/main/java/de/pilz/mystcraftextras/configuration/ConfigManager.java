package de.pilz.mystcraftextras.configuration;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;

public final class ConfigManager {

    public static void registerConfigs() {
        try {
            ConfigurationManager.registerConfig(BlocksAndItemsConfig.class);
            ConfigurationManager.registerConfig(TweaksConfig.class);
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }
    }
}
