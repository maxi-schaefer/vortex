package dev.max.vortex.config;

import com.google.gson.Gson;
import dev.max.vortex.VortexInstance;
import dev.max.vortex.config.impl.TerminalConfig;
import dev.max.vortex.utils.OSUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author gokimax at 12/27/2023
 * @project vortex
 */
public class ConfigLoader {

  public static void loadConfig() throws FileNotFoundException {
    FileReader fileReader = new FileReader(OSUtil.getDefaultDir() + "config.json");

    Configs config = new Gson().fromJson(fileReader, Configs.class);

    TerminalConfig terminalConfig = VortexInstance.getInstance().getTerminalConfig();
    terminalConfig.setPrompt(config.getTerminalConfig().getPrompt());


  }

}
