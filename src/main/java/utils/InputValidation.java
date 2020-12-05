package utils;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static HashMap<String, Integer> register = new HashMap<>();

    public static void validateCarNameLengthIsBetween1And5(List<String> participants) {
        boolean isCarNameLengthBetween1And5 = participants.stream()
                .filter(name -> checkNameLength(name.length()))
                .count() == participants.size();
        if (!isCarNameLengthBetween1And5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    public static void validateCarNameIsNotContainBlank(List<String> participants) {
        boolean isCarNameNotContainBlank = participants.stream()
                .filter(name -> name.contains(" "))
                .count() == 0;
        if (!isCarNameNotContainBlank) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백이 포함되어 있습니다.");
        }
    }

    public static void validateTryCountIsDigit(String input) {
        boolean isTryCountDigit = input.chars().allMatch(Character::isDigit);
        if (!isTryCountDigit) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자만 입력가능합니다.");
        }
    }

    public static List<String> validateCarNameIsNotDuplicate(List<String> participants) {
        boolean isCarNameNotDuplicate = participants.stream()
                .distinct()
                .count() == participants.size();
        if (!isCarNameNotDuplicate) {
            return checkNameDuplicate(participants);
        }
        return participants;
    }

    private static boolean checkNameLength(int length) {
        return ((length >= NAME_MIN_LENGTH) && (length <= NAME_MAX_LENGTH));
    }

    private static List<String> checkNameDuplicate(List<String> participants) {
        return participants.stream()
                .map(InputValidation::nameGenerator)
                .collect(Collectors.toList());
    }

    private static String nameGenerator(String name) {
        int order = 0;
        if (register.containsKey(name)) {
            order = register.get(name);
            register.put(name, order+1);
            register.put(name+order, 1);
            name += order;
        }
        if (!register.containsKey(name)) {
            register.put(name, 1);
        }
        return name;
    }
}