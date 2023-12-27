package dev.max.vortex.commands.impl;

import dev.max.vortex.commands.Command;
import dev.max.vortex.utils.Common;

import java.util.List;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class ClearCommand implements Command {

  @Override
  public String name() {
    return "clear";
  }

  @Override
  public String description() {
    return "Clear the terminal!";
  }

  @Override
  public List<String> aliases() {
    return List.of(new String[] { "cl" });
  }

  @Override
  public void execute(String[] args) {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    Common.printBanner(terminal);
  }
}
