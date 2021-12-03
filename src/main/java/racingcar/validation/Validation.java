package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void isCommaOrAlphabet(String target) {
        for(char c : target.toCharArray()) {
            validChar(c);
        }
    }

    private static void validChar(char c) {
        if(c != ',' && !Character.isAlphabetic(c))
            throw new IllegalArgumentException("[ERROR] 허용하지 않은 문자가 포함된 입력값입니다.");
    }

    public static void isProperLength(String target) {
        for(String eachName : target.split(",")) {
            validLength(eachName);
        }
    }

    private static void validLength(String target) {
        if(target.length() < 1 || target.length() > 5)
            throw new IllegalArgumentException("[ERROR] 입력값의 길이가 올바르지 못합니다.");
    }

    public static void hasDuplicatedName(String target) {
        Set<String> nameSet = new HashSet<>();

        for(String eachName : target.split(",")) {
            validateDuplication(nameSet, eachName);
            nameSet.add(eachName);
        }
    }

    private static void validateDuplication(Set<String> nameSet, String name) {
        if(nameSet.contains(name))
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
    }
}
