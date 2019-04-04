package error;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int DEFAULT_STANDARD_LEN = 5;
    private int maxLenOfCarName;
    private InputError inputError;

    public Validator() {
        maxLenOfCarName = DEFAULT_STANDARD_LEN;
    }

    public Validator(int maxLenOfCarName) {
        this.maxLenOfCarName = maxLenOfCarName;
    }

    public boolean checkAccuracyOfNames(String[] names) {
        inputError = InputError.PASS;
        if (hasUnnamed(names)) {
            inputError = InputError.UNNAMED;
        }
        if (names.length == 1) {
            inputError = InputError.COUNT_OF_CARS;
        }
        if (hasTooLongName(names)) {
            inputError = InputError.LONG_NAME;
            inputError.setMaxLenOfCarName(maxLenOfCarName);
        }
        if (hasDuplicated(names)) {
            inputError = InputError.DUPLICATED;
        }
        return (inputError == InputError.PASS);
    }

    public boolean checkAccuracyOfTries(String input) {
        inputError = InputError.PASS;
        if (!isInteger(input)) {
            inputError = InputError.NOT_INTEGER;
        }
        int tries = Integer.parseInt(input);
        if (tries < 1) {
            inputError = InputError.SIZE_OF_INTEGER;
        }
        return (inputError == InputError.PASS);
    }

    public boolean hasUnnamed(String[] names) {
        for (String name : names) {
            if (name.equals("")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTooLongName(String[] names) {
        for (String name : names) {
            if (name.trim().length() > maxLenOfCarName) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicated(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));
        if (names.length != set.size()) {
            return true;
        }
        return false;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public InputError getInputError() {
        return inputError;
    }
}
