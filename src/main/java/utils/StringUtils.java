package utils;

public class StringUtils {
    public static String hyphenParser(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append("-");
        }
        return sb.toString();
    }
}
