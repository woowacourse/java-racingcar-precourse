package utils.validator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class NameValidator {
    public static final String DELIMITER = ",";
    private static final int NAME_MAX_LEN = 5;
    private static final String CHAR_PATTERN = "^[a-zA-Z0-9ㄱ-ㅎ가-힣]*$";

    boolean validDelimiter(String inputNames) {
        if (inputNames.startsWith(DELIMITER) || inputNames.endsWith(DELIMITER)) {
            return false;
        }
        return true;
    }

    boolean validLength(String[] names) {
        return Arrays.stream(names)
                .allMatch(name -> name.length() > 0 && name.length() <= NAME_MAX_LEN);
    }

    boolean validCharacter(String[] names) {
        return Arrays.stream(names)
                .allMatch(name -> Pattern.matches(CHAR_PATTERN, name));
    }

    boolean duplicate(String[] names) {
        return Arrays.stream(names)
                .distinct()
                .count() != names.length;
    }
}
