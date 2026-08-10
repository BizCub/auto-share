package io.github.bizcub.autoShare.config;

import io.github.bizcub.autoShare.Main;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.*;

import java.util.List;

@AutoConfig(name = Main.MOD_ID)
public class SimpleConfig implements Config {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class);
    }

    @Tooltip
    public boolean arePacksRequired = Config.super.arePacksRequired();

    @ListConfig(expanded = true)
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
