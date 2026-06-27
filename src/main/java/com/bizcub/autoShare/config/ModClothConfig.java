package com.bizcub.autoShare.config;

import com.bizcub.autoShare.Main;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import java.util.List;

@Config(name = Main.MOD_ID)
public class ModClothConfig implements ModConfig, ConfigData {

    public static ModClothConfig getInstance() {
        return AutoConfig.register(ModClothConfig.class, GsonConfigSerializer::new).getConfig();
    }

    @Tooltip public boolean arePacksRequired = ModConfig.super.arePacksRequired();
    public List<String> links = ModConfig.super.links();

    @Override
    public boolean arePacksRequired() {
        return this.arePacksRequired;
    }

    @Override
    public List<String> links() {
        return this.links;
    }
}
