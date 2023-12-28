package dev.max.vortex.config;

import dev.max.vortex.config.impl.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gokimax at 12/27/2023
 * @project vortex
 */
@Setter
@Getter
public class Configs {

  private TerminalConfig terminalConfig;
  private MySQLConfig mySQLConfig;

}
