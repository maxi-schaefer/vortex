package dev.max.vortex;

import dev.max.vortex.commands.CommandManager;
import dev.max.vortex.config.ConfigLoader;
import dev.max.vortex.config.ConfigSaver;
import dev.max.vortex.config.impl.MySQLConfig;
import dev.max.vortex.config.impl.TerminalConfig;
import dev.max.vortex.database.MySQL;
import dev.max.vortex.database.connection.MySQLConnection;
import dev.max.vortex.terminal.JLine3Terminal;
import dev.max.vortex.utils.Common;
import lombok.Getter;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
@Getter
public class VortexInstance {

  private static VortexInstance instance;
  private final CommandManager commandManager;
  private final JLine3Terminal terminal;
  private static String name = "Template";
  private final TerminalConfig terminalConfig;
  private final MySQLConfig mySQLConfig;
  private final MySQLConnection mySQLConnection;

  public VortexInstance() {
    instance = this;

    // Config
    terminalConfig = new TerminalConfig("&6• &0vortex &6»");
    mySQLConfig = new MySQLConfig("127.0.0.1", 3306, "vortex", "root", "");

    try {
      if(!ConfigSaver.configExists()) {
        ConfigSaver.saveConfig();
      }
      ConfigLoader.loadConfig();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // MySQL
    mySQLConnection = MySQL.createConnection(mySQLConfig.getHost(), mySQLConfig.getPort(), mySQLConfig.getDatabase(), mySQLConfig.getUser(), mySQLConfig.getPassword());

    // Terminal
    this.terminal = new JLine3Terminal();
    Common.printBanner(this.terminal);

    // Manager
    commandManager = new CommandManager();

    Runtime.getRuntime().addShutdownHook(new Thread(VortexInstanceShutdownHandler::run));
  }

  public static VortexInstance getInstance() {
    return instance;
  }

  public static String getName() {
    return name;
  }
}
