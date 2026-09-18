package io.github.bizcub.autoShare.config;

import io.github.bizcub.autoShare.Main;
import io.github.bizcub.simpleConfigLib.autoconfig.gui.ConfigScreens;
import me.shedaniel.autoconfig.AutoConfigClient;
import net.minecraft.client.gui.screens.Screen;

public class ConfigHelperClient {

    public static Screen getScreen(Screen parent) {
        if (ConfigHelperCommon.isSimpleConfigLoaded()) {
            return ConfigScreens.open(Main.MOD_ID, parent);
        }
        if (ConfigHelperCommon.isClothConfigLoaded()) {
            return AutoConfigClient.getConfigScreen(ClothConfig.class, parent).get();
        }
        return parent;
    }
}
