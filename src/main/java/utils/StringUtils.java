package utils;

import java.util.List;
import java.util.StringJoiner;

public class StringUtils {
    public static String join(List<String> stringList, String delimiter) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        for (String string : stringList) {
            stringJoiner.add(string);
        }

        return stringJoiner.toString();
    }
}
