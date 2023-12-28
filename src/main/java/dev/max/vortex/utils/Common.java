package dev.max.vortex.utils;

import dev.max.vortex.VortexInstance;
import dev.max.vortex.terminal.JLine3Terminal;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public class Common {

  public static void printBanner(JLine3Terminal terminal) {
    boolean mySQLConnected = VortexInstance.getInstance().getMySQLConnection().isConnected();
    terminal.write("");
    terminal.write("&0\t\t\t____   ____            __                 ");
    terminal.write("&0\t\t\t\\   \\ /   /___________/  |_  ____ ___  ___");
    terminal.write("&0\t\t\t \\   Y   /  _ \\_  __ \\   __\\/ __ \\\\  \\/  /");
    terminal.write("&0\t\t\t  \\     (  <_> )  | \\/|  | \\  ___/ >    < ");
    terminal.write("&0\t\t\t   \\___/ \\____/|__|   |__|  \\___  >__/\\_ \\");
    terminal.write("&0                                \\/      \\/");
    terminal.write("&5\t\t\tType &0'help' &5to get a list of available commands!");
    terminal.write("\t\t\t      " + (mySQLConnected ? "&2✔️ Successfully connected to MySQL!" : "&0❌ Error whilst connecting to MySQL!"));
    terminal.write("");
    terminal.write("&6──────────═══──═══──═══──═══─────────┤× &5Developed by &0max &6×├─────────═══──═══──═══──═══──────────");
    terminal.write("");
    terminal.write("");
  }

}
