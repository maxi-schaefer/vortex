package dev.max.bankingsystem.commands.impl;

import dev.max.bankingsystem.TemplateInstance;
import dev.max.bankingsystem.commands.Command;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class HelpCommand implements Command {

  @Override
  public String name() {
    return "Help";
  }

  @Override
  public String description() {
    return null;
  }

  @Override
  public void execute(String[] args) {
    terminal.write("");
    terminal.write("&0Commands &6× ");
    TemplateInstance.getInstance().getCommandManager().getCommands().forEach(command -> {
      if(!command.name().equals(this.name()))
        terminal.write(" &6× &0" + command.name() + " &6[&5" + command.description() + "&6]");
    });
    terminal.write("");
  }
}
