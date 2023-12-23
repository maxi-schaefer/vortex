package dev.max.bankingsystem.commands;

import dev.max.bankingsystem.TemplateInstance;
import dev.max.bankingsystem.terminal.JLine3Terminal;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public interface Command {

  JLine3Terminal terminal = TemplateInstance.getInstance().getTerminal();

  String name();

  String description();

  void execute(String[] args);

}
