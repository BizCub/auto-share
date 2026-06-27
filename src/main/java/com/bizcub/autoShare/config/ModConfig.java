package com.bizcub.autoShare.config;


import java.util.List;

public interface ModConfig {
    ModConfig CONFIG = Compat.isClothConfigLoaded() ? ModClothConfig.getInstance() : new ModConfig() { };

    default boolean arePacksRequired() {
        return false;
    }

    default List<String> links() {
        return List.of();
    }
}
