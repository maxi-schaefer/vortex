package dev.max.vortex.utils;

import java.io.File;

public class OSUtil {

    private static final String currentOS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() { return (currentOS.contains("windows")); }
    public static boolean isMacOS() { return (currentOS.contains("mac")); }
    public static boolean isLinus() { return (currentOS.contains("linux")); }

    public static String getDefaultDir() {
        return "config" + File.separator;
    }

}