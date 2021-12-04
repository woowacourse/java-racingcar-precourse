package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public RacingGame(){}

    public void start() {
        inputTheCarName();
        inputTheNumberOfAttempts();
    }

    public String[] inputTheCarName() {
        boolean isValidInput = true;
        String[] carNames;
        do {
            printConsoleMessage(INPUT_CAR_NAME_MESSAGE);
            carNames = parseStringArray(Console.readLine());
        } while (!isValidInput);

        return carNames;
    }

    public String inputTheNumberOfAttempts() {
        String numberOfAttempts = "";
        boolean isValidInput = true;

        do {
            printConsoleMessage(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
            numberOfAttempts = Console.readLine();
        } while (!isValidInput);

        return numberOfAttempts;
    }

    private String[] parseStringArray(String inputTheCarNames) {
        return inputTheCarNames.split(",");
    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }

}
