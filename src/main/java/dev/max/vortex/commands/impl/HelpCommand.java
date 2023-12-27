package dev.max.vortex.commands.impl;

import dev.max.vortex.VortexInstance;
import dev.max.vortex.commands.Command;

import java.util.ArrayList;
import java.util.List;

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
  public List<String> aliases() {
    return List.of(new String[]{"?"});
  }

  @Override
  public void execute(String[] args) {
    terminal.write("");
    terminal.write("&0Commands &6× ");
    VortexInstance.getInstance().getCommandManager().getCommands().forEach(command -> {
      if(!command.name().equals(this.name())) {
        List<String> cAliases = new ArrayList<>();
        cAliases.addAll(command.aliases());
        String aliases = cAliases.toString().replace("[", "").replace("]", "");

        terminal.write(" &6× &0" + command.name() + " &6[&5" + command.description() + "&6]" + (cAliases.isEmpty() ? "" : "&6» &4" + aliases));
      }
    });
    terminal.write("");
  }
}
