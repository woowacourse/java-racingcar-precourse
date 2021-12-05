package util;

public class StringRepeater {
    private StringRepeater() {
    }

    public static String repeat(String source, int repeatCount) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < repeatCount; index++) {
            result.append(source);
        }
        return result.toString();
    }
}
