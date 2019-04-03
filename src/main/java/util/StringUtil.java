package util;

public class StringUtil {
    public static String repeatString(String str, int repeat) {
        String repeatedStr = "";
        for (int i = 0; i < repeat; i++) {
            repeatedStr += str;
        }
        return repeatedStr;
    }
}
