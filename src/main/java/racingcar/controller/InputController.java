package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputController {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER_COMMA = ",";

    public List<String> inputCarName(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String participants = scanner.nextLine();
        //validate
        return parseStringToStringList(participants);
    }

    private List<String> parseStringToStringList(String participants) {
        return Arrays.asList(participants.split(DELIMITER_COMMA));
    }
}
