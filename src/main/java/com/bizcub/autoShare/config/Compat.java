package com.bizcub.autoShare.config;

//~ auto_config
import me.shedaniel.autoconfig.AutoConfigClient;
import net.minecraft.client.gui.screens.Screen;
/*? fabric*/ import net.fabricmc.loader.api.FabricLoader;
/*? neoforge*/ //import net.neoforged.fml.ModList;

public class Compat {
    public static final String clothConfigId =
            /*? fabric && >=1.18*/ "cloth-config";
            /*? fabric && <1.18*/ //"cloth-config2"
            /*? neoforge*/ //"cloth_config";

    public static boolean isModLoaded(String modId) {
        /*? fabric*/ return FabricLoader.getInstance().isModLoaded(modId);
        /*? neoforge*/ //return ModList.get().isLoaded(modId);
    }

    public static boolean isClothConfigLoaded() {
        return isModLoaded(clothConfigId);
    }

    public static Screen getScreen(Screen parent) {
        return AutoConfigClient.getConfigScreen(ModClothConfig.class, parent).get();
    }
}
