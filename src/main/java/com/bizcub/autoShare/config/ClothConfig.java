package com.bizcub.autoShare.config;

import com.bizcub.autoShare.Main;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import java.util.List;

@me.shedaniel.autoconfig.annotation.Config(name = Main.MOD_ID)
public class ClothConfig implements Config, ConfigData {

    public static ClothConfig getInstance() {
        return AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new).getConfig();
    }

    @Tooltip
    public boolean arePacksRequired = Config.super.arePacksRequired();

    public List<String> links = Config.super.links();

    @Override
    public boolean arePacksRequired() {
        return this.arePacksRequired;
    }

    @Override
    public List<String> links() {
        return this.links;
    }
}
