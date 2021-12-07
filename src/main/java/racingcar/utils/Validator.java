package racingcar.utils;

import static racingcar.utils.Constant.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static boolean isValidCount(String input) {
        try {
            if (Integer.parseInt(input) < Constant.ZERO_NUMBER) {
                throw new IllegalArgumentException(MINIMUM_TRY_NUMBER_ERROR_MESSAGE);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<String> isValidNameList(String input) {
        List<String> names = splitNameList(input);
        if (checkLengthAndDuplicate(names)) {
            return names;
        }
        return Collections.emptyList();
    }

    private static boolean checkLengthAndDuplicate(List<String> names) {
        try {
            validateLength(names);
            validateDuplicateCars(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validateDuplicateCars(List<String> names) {
        long overlapRemoveCount = names.stream()
                .distinct()
                .count();
        if (overlapRemoveCount != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private static void validateLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static List<String> splitNameList(String input) {
        return Arrays.stream(input.split(SPLIT_BY))
                .collect(Collectors.toList());
    }
}