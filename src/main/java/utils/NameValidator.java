package utils;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import static racingcar.Constant.*;

public class NameValidator {

    public static void checkNameList(List<String> nameList) {
        checkNull(nameList);
        checkPartialSpace(nameList);
        checkRaceAlone(nameList);
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

    private static void checkRaceAlone(List<String> nameList) {
        if(nameList.size() <= 1){
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_ALONE);
        }
    }

    private static void checkNamesLength(List<String> nameList) {
        for(String name : nameList) {
            if (name.length() > CHECK_LENGTH ) {
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_LENGTH);
            }
        }
    }

    private static void checkNameDuplicate(List<String> nameList) {
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < nameList.size(); i++) {
            hashSet.add(nameList.get(i));
        }
        if (hashSet.size() != nameList.size()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_DUPLICATE);
        }
    }
}
