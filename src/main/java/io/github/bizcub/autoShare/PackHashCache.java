package io.github.bizcub.autoShare;

import com.google.common.hash.Hashing;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public final class PackHashCache {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Map<String, String> HASHES = new ConcurrentHashMap<>();
    private static final Set<String> IN_PROGRESS = ConcurrentHashMap.newKeySet();

    public static String get(String link) {
        return HASHES.getOrDefault(link, "");
    }

    public static void computeAsync(String link, Runnable onComplete) {
        if (HASHES.containsKey(link) || !IN_PROGRESS.add(link)) {
            return;
        }
        CompletableFuture.runAsync(() -> {
            try {
                String hash = compute(link);
                HASHES.put(link, hash);
                LOGGER.info("Computed SHA-1 for {}: {}", link, hash);
                if (onComplete != null) {
                    onComplete.run();
                }
            } catch (Exception e) {
                LOGGER.warn("Failed to compute SHA-1 for {}", link, e);
            } finally {
                IN_PROGRESS.remove(link);
            }
        });
    }

    @SuppressWarnings("deprecation")
    private static String compute(String link) throws Exception {
        URLConnection connection = URI.create(link).toURL().openConnection();
        connection.setConnectTimeout(15_000);
        connection.setReadTimeout(15_000);
        try (InputStream in = connection.getInputStream()) {
            return Hashing.sha1().hashBytes(in.readAllBytes()).toString();
        }
    }
}
