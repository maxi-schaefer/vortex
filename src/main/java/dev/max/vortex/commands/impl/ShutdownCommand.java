package dev.max.vortex.commands.impl;

import dev.max.vortex.commands.Command;

import java.util.List;

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
  public List<String> aliases() {
    return List.of(new String[] { "exit" });
  }

  @Override
  public void execute(String[] args) {
    System.exit(0);
  }
}
