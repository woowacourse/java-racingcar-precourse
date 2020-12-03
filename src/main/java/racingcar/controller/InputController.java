package racingcar.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputController {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER_COMMA = ",";
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static HashMap<String, Integer> register = new HashMap<>();

    public List<String> inputCarName(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        List<String> participants = parseStringToStringList(scanner.nextLine());
        participants = validateCarNameIsNotDuplicate(participants);
        validateCarNameLengthIsBetween1And5(participants);
        validateCarNameIsNotContainBlank(participants);
        return participants;
    }

    public int inputTryCount(Scanner scanner) {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = scanner.nextLine();
        validateTryCountIsDigit(tryCount);
        return parseStringToInt(tryCount);
    }

    private void validateCarNameLengthIsBetween1And5(List<String> participants) {
        boolean isCarNameLengthBetween1And5 = participants.stream()
                .filter(name -> checkNameLength(name.length()))
                .count() == participants.size();
        if (!isCarNameLengthBetween1And5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private boolean checkNameLength(int length) {
        return ((length >= NAME_MIN_LENGTH) && (length <= NAME_MAX_LENGTH));
    }

    private void validateCarNameIsNotContainBlank(List<String> participants) {
        boolean isCarNameNotContainBlank = participants.stream()
                .filter(name -> name.contains(" "))
                .count() == 0;
        if (!isCarNameNotContainBlank) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백이 포함되어 있습니다.");
        }
    }

    private List<String> validateCarNameIsNotDuplicate(List<String> participants) {
        boolean isCarNameNotDuplicate = participants.stream()
                .distinct()
                .count() == participants.size();
        if (!isCarNameNotDuplicate) {
            return checkNameDuplicate(participants);
        }
        return participants;
    }

    private List<String> checkNameDuplicate(List<String> participants) {
        return participants.stream()
                .map(this::nameGenerator)
                .collect(Collectors.toList());
    }

    private String nameGenerator(String name) {
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

    private void validateTryCountIsDigit(String input) {
        boolean isTryCountDigit = input.chars().allMatch(Character::isDigit);
        if (!isTryCountDigit) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자만 입력가능합니다.");
        }
    }

    private List<String> parseStringToStringList(String input) {
        return Arrays.asList(input.split(DELIMITER_COMMA));
    }

    private int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }
}