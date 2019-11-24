package edu.neu.coe.info6205.life.library;

import java.util.HashMap;
import java.util.Map;

public class Library {

    final public static String Blip = "0 0";

    final public static String Blip2 = "0 0, 1 0";

    final public static String Block = "1 1, 1 2, 2 2, 2 1";

    final public static String Beehive = "1 2, 2 1, 3 1, 4 2, 3 3, 2 3";

    final public static String Loaf = "1 3, 2 4, 3 4, 4 3, 4 2, 3 1, 2 2";

    final public static String Blinker = "0 -1, 0 0, 0 1";

    final public static String Glider1 = "0 0, 1 0, 2 0, 2 -1, 1 -2";

    final public static String Glider2 = "2 0, 1 0, 0 0, 0 -1, 1 -2";

    final public static String Glider3 = "0 0, 1 0, 2 0, 2 1, 1 2";

    final public static String GosperGliderGun1 = "0 2, 1 2, 0 3, 1 3, 9 2, 10 2, 8 3, 10 3, 8 4, 9 4, 16 4, 16 5, 16 6, 17 4, 18 5, 22 1, 22 2, 23 0, 23 2, 24 0, 24 1, 24 12, 24 13, 25 12, 25 14, 26 12, 34 0, 34 1, 35 0, 35 1, 35 7, 35 8, 35 9, 36 7, 37 8";

    final public static Map<String, String> map = new HashMap<>();

    public static String get(String key) {
        return map.get(key.toLowerCase());
    }

    public static String put(String key, String value) {
        return map.put(key.toLowerCase(), value);
    }

    static {
        put("Blip", Blip);
        put("Blip2", Blip2);
        put("Block", Block);
        put("Beehive", Beehive);
        put("Loaf", Loaf);
        put("Blinker", Blinker);
        put("Glider1", Glider1);
        put("Glider2", Glider2);
        put("Glider3", Glider3);
        put("GosperGliderGun1", GosperGliderGun1);
    }
}
