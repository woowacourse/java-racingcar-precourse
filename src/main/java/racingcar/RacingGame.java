package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private final InputValidator inputValidator;

    private static final String INPUT_CAR_NAME_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";

    public RacingGame(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void play() {
        System.out.println(INPUT_CAR_NAME_LIST_MESSAGE);
        String[] carNameList = Console.readLine().split(DELIMITER);

        inputValidator.validateCarNameListInput(carNameList);
    }
}
