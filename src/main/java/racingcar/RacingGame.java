package racingcar;

import camp.nextstep.edu.missionutils.Console;

import racingcar.validation.InputValidation;
import racingcar.validation.RacingGameValidationImpl;

public class RacingGame {

    private final InputValidation validation;
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ERROR_INPUT_CAR_NAME_MESSAGE = "[ERROR] 이름은 ',' 단위로 입력해야 하며 공백 문자 및 특수문자가 포함되선 안된다.\n";
    private static final String ERROR_INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.\n";


    private String[] carNames;
    private int numberOfAttempts;

    public RacingGame() {
        validation = RacingGameValidationImpl.getInstance();
    }

    public void start() {
        inputTheCarName();
        inputTheNumberOfAttempts();
        //businessLogic
    }

    public void inputTheCarName() {
        try {
            printConsoleMessage(INPUT_CAR_NAME_MESSAGE);
            String inputTheCarNames = Console.readLine();
            validation.validCarNames(inputTheCarNames);
            carNames = toStringArray(inputTheCarNames);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INPUT_CAR_NAME_MESSAGE);
            inputTheCarName();
        }
    }

    public void inputTheNumberOfAttempts() {
        try {
            printConsoleMessage(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
            String inputTheNumberOfAttempt = Console.readLine();
            validation.validNumberOfAttempts(inputTheNumberOfAttempt);
            numberOfAttempts = toInteger(inputTheNumberOfAttempt);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
            inputTheNumberOfAttempts();
        }
    }

    private String[] toStringArray(String inputTheCarNames) {
        return inputTheCarNames.split(",");
    }

    private int toInteger(String inputTheNumberOfAttempt) {
        return Integer.parseInt(inputTheNumberOfAttempt);
    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }

}
