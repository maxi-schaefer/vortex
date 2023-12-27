package dev.max.vortex.commands;

import dev.max.vortex.VortexInstance;
import dev.max.vortex.terminal.JLine3Terminal;

import java.util.Collections;
import java.util.List;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public interface Command {

  JLine3Terminal terminal = VortexInstance.getInstance().getTerminal();

  String name();

  String description();

  default List<String> aliases() { return Collections.emptyList(); }

  void execute(String[] args);

}
