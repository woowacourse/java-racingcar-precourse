package utils;

public class StringUtils {

    private StringUtils(){}

    public static String hyphenParser(int n) {
        final char HYPHEN = '-';
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(HYPHEN);
        }
        return sb.toString();
    }
}
