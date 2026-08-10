package com.bizcub.autoShare.config;

//~ auto_config
import me.shedaniel.autoconfig.AutoConfigClient;
import net.minecraft.client.gui.screens.Screen;
/*? fabric*/ import net.fabricmc.loader.api.FabricLoader;
/*? neoforge*/ //import net.neoforged.fml.ModList;

public class ConfigHelper {
    public static boolean isModLoaded(String modId) {
        /*? fabric*/ return FabricLoader.getInstance().isModLoaded(modId);
        /*? neoforge*/ //return ModList.get().isLoaded(modId);
    }

    public static boolean isClothConfigLoaded() {
        return isModLoaded(/*$ cloth_config_id >> ')'*/ "cloth-config");
    }

    public static boolean isSimpleConfigLoaded() {
        return isModLoaded("simple_config_lib");
    }

    public static Screen getScreen(Screen parent) {
        if (isSimpleConfigLoaded()) {
            return SimpleConfig.getInstance().createScreen(parent);
        } else if (isClothConfigLoaded()) {
            return AutoConfigClient.getConfigScreen(ClothConfig.class, parent).get();
        } else {
            return parent;
        }
    }
}
