package dev.max.vortex;

import dev.max.vortex.config.ConfigLoader;
import dev.max.vortex.config.ConfigSaver;

/**
 * @author gokimax at 12/20/2023
 * @project BankingSystem
 */
public class VortexInstanceShutdownHandler {

    public static void run() {

        // Config
        try {
            if(!ConfigSaver.configExists()) {
                ConfigSaver.saveConfig();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        VortexInstance.getInstance().getTerminal().close();
    }

}
