package dev.max.bankingsystem.commands.impl;

import dev.max.bankingsystem.commands.Command;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class ShutdownCommand implements Command {

  @Override
  public String name() {
    return "stop";
  }

  @Override
  public String description() {
    return "Stops the terminal and the service!";
  }

  @Override
  public void execute(String[] args) {
    System.exit(0);
  }
}
