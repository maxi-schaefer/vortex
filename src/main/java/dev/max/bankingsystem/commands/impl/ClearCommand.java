package dev.max.bankingsystem.commands.impl;

import dev.max.bankingsystem.commands.Command;
import dev.max.bankingsystem.utils.Common;

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
  public void execute(String[] args) {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    Common.printBanner(terminal);
  }
}
