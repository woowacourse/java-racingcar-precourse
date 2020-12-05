package utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static racingcar.Constant.*;

public class NameValidator {

    public static void checkNameList(List<String> nameList) {
        checkNull(nameList);
        checkPartialSpace(nameList);
        checkNamesLength(nameList);
        checkNameDuplicate(nameList);
    }

    private static void checkNull(List<String> nameList) {
        for(String name : nameList) {
            if (Pattern.matches(CHECK_NULL_REGEX, name)) {
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_NULL);
            }
        }
    }

    private static void checkPartialSpace(List<String> nameList){
        for(String name : nameList) {
            if (!Pattern.matches(CHECK_PARTIAL_SPACE_REGEX, name)) {
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_PARTIAL_SPACE);
            }
        }
    }

    private static void checkNamesLength(List<String> nameList) {

    }

    private static void checkNameDuplicate(List<String> nameList) {

    }
}
