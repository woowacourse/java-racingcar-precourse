package utils.validator;

public class NameValidator {
    public static final String DELIMITER = ",";

    boolean validDelimiter(String inputNames) {
        if (inputNames.startsWith(DELIMITER) || inputNames.endsWith(DELIMITER)) {
            return false;
        }
        return true;
    }
}
