package dev.max.bankingsystem.terminal;

import org.fusesource.jansi.Ansi;

/**
 * @author gokimax at 12/20/2023
 * @project Vortex
 */
public enum Color {

  /* &0 */    MAGENTA(122, 69, 255),
  /* &1 */    RED(255, 61, 61),
  /* &2 */    GREEN(61, 255, 142),
  /* &3 */    BLUE(61, 155, 255),
  /* &4 */    WHITE(255, 255, 255),
  /* &5 */    DEFAULT(200, 200, 200),
  /* &6 */    DARK_DEFAULT(60, 60, 60),
  /* &7 */    ORANGE(255, 194, 25),
  /* &8 */    ВARK_BLUE(31, 41, 55),
  /* &9 */    PINK(255, 99, 247);

  String ansi;

  private static final Color[] VALUES = values();

  Color(int red, int green, int blue) {
    this.ansi = Ansi.ansi().a(Ansi.Attribute.RESET).fgRgb(red, green, blue).toString();
  }

  public static String translate(String output) {
    for(Color color : VALUES) {
      output = output.replace("&" + color.ordinal(), color.ansi);
    }
    return output;
  }

}
