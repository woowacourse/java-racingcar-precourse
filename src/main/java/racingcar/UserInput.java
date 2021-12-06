package racingcar;

import java.lang.String;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private static final String RACINGCAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACINGCAR_NUMBER_OF_ATTEMPTS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    protected static final String[] inputCarName() {
        String[] carNameArray;
        do {
            System.out.println(RACINGCAR_NAME_INPUT_MESSAGE);
            String carTotalName = Console.readLine();
            carNameArray = carTotalName.split(CAR_NAME_DELIMITER);
        } while (!InputValidator.validateCarName(carNameArray));

        return carNameArray;
    }

    protected static final int inputNumberOfAttempts() {
        String numberOfAttempts;
        do {
            System.out.println(RACINGCAR_NUMBER_OF_ATTEMPTS_INPUT_MESSAGE);
            numberOfAttempts = Console.readLine();
        } while (!InputValidator.validateNumberOfAttempts(numberOfAttempts));

        return Integer.parseInt(numberOfAttempts);
    }
}

