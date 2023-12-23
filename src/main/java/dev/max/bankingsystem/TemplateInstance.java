package dev.max.bankingsystem;

import dev.max.bankingsystem.commands.CommandManager;
import dev.max.bankingsystem.terminal.JLine3Terminal;
import dev.max.bankingsystem.utils.Common;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class TemplateInstance {

  private static TemplateInstance instance;
  private final CommandManager commandManager;
  private final JLine3Terminal terminal;
  private static String name = "Template";

  public TemplateInstance() {
    instance = this;

    // Manager
    commandManager = new CommandManager();

    // Terminal
    this.terminal = new JLine3Terminal();
    Common.printBanner(this.terminal);

    Runtime.getRuntime().addShutdownHook(new Thread(TemplateInstanceShutdownHandler::run));
  }

  public static TemplateInstance getInstance() {
    return instance;
  }

  public JLine3Terminal getTerminal() {
    return terminal;
  }

  public static String getName() {
    return name;
  }

  public CommandManager getCommandManager() {
    return commandManager;
  }
}
