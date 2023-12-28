package dev.max.vortex.config.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gokimax at 12/28/2023
 * @project vortex
 */
@AllArgsConstructor
@Getter
@Setter
public class MySQLConfig {

  private String host;
  private int port;
  private String database;
  private String user;
  private String password;

}
