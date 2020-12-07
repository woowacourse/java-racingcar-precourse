package utils.validator;

import java.util.Arrays;

public class NameValidator {
    public static final String DELIMITER = ",";
    private static final int NAME_MAX_LEN = 5;

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
}
