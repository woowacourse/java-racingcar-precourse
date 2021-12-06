package racingcar.racingsystem;

import racingcar.configuration.DependencyInjectionContainer;
import racingcar.domain.Car;
import racingcar.domain.Player;
import racingcar.service.JudgmentService;
import racingcar.validation.InputValidation;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private static final String CAR_NAME_INPUT_CLASSIFICATION_RULE = ",";
    private static final String WINNER_NAME_OUTPUT_CLASSIFICATION_RULE = ", ";
    private final InputValidation validation;
    private final JudgmentService judgmentService;

    private int numberOfAttempts;
    private String[] carNames;
    private StringBuilder racingRecord;

    public RacingGame() {
        validation = DependencyInjectionContainer.racingGameInputValidation();
        judgmentService = DependencyInjectionContainer.judgmentService();
    }

    public void start() {
        inputTheCarName();
        inputTheNumberOfAttempts();
        Player player = new Player(carNames, numberOfAttempts);
        startRacing(player);
        printConsoleMessage(racingRecord.toString());
        String winners = String.join(WINNER_NAME_OUTPUT_CLASSIFICATION_RULE, ToStringArray(player));
        printConsoleMessage(SystemMessage.JUDGMENT_RESULT_MESSAGE.getMessage() + winners + "\n");
    }

    public void inputTheCarName() {
        boolean isRetry;
        do {
            try {
                printConsoleMessage(SystemMessage.INPUT_CAR_NAME_MESSAGE.getMessage());
                String inputTheCarNames = Console.readLine();
                validation.validCarNames(inputTheCarNames);
                carNames = splitCarName(inputTheCarNames);
                isRetry=false;
            } catch (IllegalArgumentException e) {
                System.out.println(SystemMessage.ERROR_INPUT_CAR_NAME_MESSAGE.getMessage());
                isRetry = true;
            }
        } while (isRetry);
    }

    public void inputTheNumberOfAttempts() {
        boolean isRetry;
        do {
            try {
                printConsoleMessage(SystemMessage.INPUT_NUMBER_OF_ATTEMPTS_MESSAGE.getMessage());
                String inputTheNumberOfAttempt = Console.readLine();
                validation.validNumberOfAttempts(inputTheNumberOfAttempt);
                numberOfAttempts = toInteger(inputTheNumberOfAttempt);
                isRetry=false;
            } catch (IllegalArgumentException e) {
                printConsoleMessage(
                    SystemMessage.ERROR_INPUT_NUMBER_OF_ATTEMPTS_MESSAGE.getMessage());
                isRetry = true;
            }
        } while (isRetry);
    }

    private void startRacing(Player player) {
        int playerInputNumberOfAttempts = player.getNumberOfAttempts();
        racingRecord = new StringBuilder();
        racingRecord.append("실행결과\n");
        for (int attempts = 0; attempts < playerInputNumberOfAttempts; attempts++) {
            for (int sequence = 0; sequence < player.getCars().size(); sequence++) {
                Car currentCar = player.getCars().get(sequence);
                currentCar.goForward();
                recordCurrentRacing(currentCar);
            }
            processNewLine();
        }
    }

    private void processNewLine() {
        racingRecord.append("\n");
    }

    private void recordCurrentRacing(Car currentCar) {
        racingRecord.append(currentCar.getName()).append(" : ")
            .append(currentCar.printCurrentPosition()).append("\n");
    }

    private int toInteger(String inputTheNumberOfAttempt) {
        return Integer.parseInt(inputTheNumberOfAttempt);
    }

    private String[] ToStringArray(Player player) {
        return judgmentService.judgeTheWinner(player).stream().toArray(String[]::new);
    }

    private String[] splitCarName(String inputTheCarNames) {
        return inputTheCarNames.split(CAR_NAME_INPUT_CLASSIFICATION_RULE);
    }

    private void printConsoleMessage(String message) {
        System.out.print(message);
    }
}
