package io.github.bizcub.autoShare.config;

import io.github.bizcub.autoShare.Main;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.*;

import java.util.List;

@AutoConfig(name = Main.MOD_ID, translate = true)
public class SimpleConfig implements Config {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class);
    }

    @Tooltip
    public boolean arePacksRequired = Config.super.arePacksRequired();

    @ListConfig(expanded = true, translateElements = true)
    public List<LinkProfile> linkProfiles = Config.super.linkProfiles();

    @Override
    public boolean arePacksRequired() {
        return this.arePacksRequired;
    }

    @Override
    public List<LinkProfile> linkProfiles() {
        return this.linkProfiles;
    }
}
