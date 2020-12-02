package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputController {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER_COMMA = ",";
    private static final int NAME_MAX_LENGTH = 5;

    public List<String> inputCarName(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        List<String> participants = parseStringToStringList(scanner.nextLine());
        validateCarNameLengthIs5OrLess(participants);
        validateCarNameIsNotContainBlank(participants);
        return participants;
    }

    private void validateCarNameLengthIs5OrLess(List<String> participants) {
        boolean isCarNameLength5OrLess = participants.stream()
                .filter(name -> name.length() <= NAME_MAX_LENGTH)
                .count() == participants.size();
        if (!isCarNameLength5OrLess) {
            throw new IllegalArgumentException("이름의 길이는 5이하여야 합니다.");
        }
    }

    private void validateCarNameIsNotContainBlank(List<String> participants) {
        boolean isCarNameNotContainBlank = participants.stream()
                .filter(name -> name.contains(" "))
                .count() == 0;
        if(!isCarNameNotContainBlank) {
            throw new IllegalArgumentException("이름에 공백이 포함되어 있습니다.");
        }
    }

    private List<String> parseStringToStringList(String input) {
        return Arrays.asList(input.split(DELIMITER_COMMA));
    }
}
