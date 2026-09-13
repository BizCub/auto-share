package io.github.bizcub.autoShare.config;

import io.github.bizcub.simpleConfigLib.autoconfig.ConfigProvider;

import java.util.List;

public interface Config {
    static Config get() {
        return ConfigProvider.get(Config.class);
    }
    static void set(Config instance) {
        ConfigProvider.set(Config.class, instance);
    }

    default boolean arePacksRequired() {
        return false;
    }

    default List<LinkProfile> linkProfiles() {
        return List.of();
    }
}
