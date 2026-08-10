package io.github.bizcub.autoShare.config;

import java.util.List;

public interface Config {
    static Config get() {
        return Holder.INSTANCE;
    }

    static void set(final Config config) {
        if (config != null) {
            Holder.INSTANCE = config;
        }
    }

    class Holder {
        private static Config INSTANCE = new Config() { };
    }

    default boolean arePacksRequired() {
        return false;
    }

    default List<String> links() {
        return List.of();
    }
}
