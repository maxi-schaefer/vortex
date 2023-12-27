package dev.max.vortex.commands;

import dev.max.vortex.commands.impl.ClearCommand;
import dev.max.vortex.commands.impl.HelpCommand;
import dev.max.vortex.commands.impl.ShutdownCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class CommandManager {

  public List<Command> commands = new ArrayList<>();

  public CommandManager() {
    commands.add(new HelpCommand());
    commands.add(new ClearCommand());
    commands.add(new ShutdownCommand());
  }

  public void call(String[] args) {
    var arguments = new ArrayList<>(Arrays.stream(args).toList());
    var name = arguments.remove(0);

    for(Command c : commands) {
      if(!(c.aliases().isEmpty())) {
        for(String alias : c.aliases()) {
          if(c.name().equalsIgnoreCase(name) || name.equalsIgnoreCase(alias)) {
            c.execute(arguments.toArray(new String[0]));
          }
        }
      } else {
        if(c.name().equalsIgnoreCase(name)) {
          c.execute(arguments.toArray(new String[0]));
        }
      }


    }
  }

  public List<Command> getCommands() {
    return commands;
  }
}
