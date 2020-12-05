package racingcar.controller;

import java.util.List;
import java.util.Scanner;

import static utils.InputValidation.*;
import static utils.ParseUtils.parseStringToInt;
import static utils.ParseUtils.parseStringToStringList;

public class InputController {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

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
}