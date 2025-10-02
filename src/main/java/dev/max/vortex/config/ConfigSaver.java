package dev.max.vortex.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.max.vortex.VortexInstance;
import dev.max.vortex.config.impl.MySQLConfig;
import dev.max.vortex.config.impl.TerminalConfig;
import dev.max.vortex.utils.OSUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @author gokimax at 12/27/2023
 * @project vortex
 */
public class ConfigSaver {

  public static void saveConfig() throws IOException {
    createDir();

    FileWriter writer = new FileWriter(OSUtil.getDefaultDir() + "config.json", StandardCharsets.UTF_8);

    Configs configs = new Configs();

    configs.setTerminalConfig(VortexInstance.getInstance().getTerminalConfig());
    configs.setMySQLConfig(VortexInstance.getInstance().getMySQLConfig());

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    String json = gson.toJson(configs);
    writer.write(json);
    writer.close();
  }

  private static void createDir() {
    File file = new File(OSUtil.getDefaultDir());
    if(!file.exists()) {
      try {
        Files.createDirectory(file.toPath());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    createFile();
  }

  private static void createFile() {
    File file = new File(OSUtil.getDefaultDir() + "config.json");
    if(!file.exists()) {
      try {
        Files.createFile(file.toPath());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static boolean configExists() {
    File file = new File(OSUtil.getDefaultDir() + "config.json");
    return file.exists();
  }

}
