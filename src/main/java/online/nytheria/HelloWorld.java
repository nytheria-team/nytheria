package online.nytheria;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;

public final class HelloWorld {
    private static final ComponentLogger LOGGER = ComponentLogger.logger(HelloWorld.class);

    public static void main(String[] args) {
        LOGGER.info("Hello, World!");
    }
}
