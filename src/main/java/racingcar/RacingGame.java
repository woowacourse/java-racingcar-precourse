package racingcar;

import java.util.Comparator;
import java.util.List;

import racingcar.domain.Player;
import racingcar.service.JudgmentService;
import racingcar.service.JudgmentServiceImplementation;
import racingcar.validation.InputValidation;
import racingcar.validation.RacingGameValidationImpl;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private static final String ERROR_INPUT_CAR_NAME_MESSAGE = "[ERROR] 이름은 ',' 단위로 입력해야 하며 공백 문자 및 특수문자가 포함되선 안된다.\n";
    private static final String ERROR_INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.\n";
    private static final String JUDGMENT_RESULT_MESSAGE = "최종 우승자 : ";
    private final InputValidation validation;
    private final JudgmentService judgmentService;

    private String[] carNames;
    private int numberOfAttempts;
    private StringBuilder racingRecord;

    public RacingGame() {
        validation = RacingGameValidationImpl.getInstance();
        judgmentService = new JudgmentServiceImplementation(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPosition() - o1.getPosition();
            }
        });
    }

    public void start() {
        inputTheCarName();
        inputTheNumberOfAttempts();
        Player player = new Player(carNames, numberOfAttempts);
        startRacing(player);
        List<String> judgeResults = judgmentService.judgeTheWinner(player);
        printConsoleMessage(racingRecord.toString());
        judgeResults.stream().toArray(String[]::new);
        String winners = String.join(", ", judgeResults.stream().toArray(String[]::new));
        printConsoleMessage(JUDGMENT_RESULT_MESSAGE + winners + "\n");
    }

    public void inputTheCarName() {
        boolean isRetry = false;
        do {
            try {
                printConsoleMessage(INPUT_CAR_NAME_MESSAGE);
                String inputTheCarNames = Console.readLine();
                validation.validCarNames(inputTheCarNames);
                carNames = toStringArray(inputTheCarNames);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_INPUT_CAR_NAME_MESSAGE);
                isRetry = true;
            }
        } while (isRetry);
    }

    public void inputTheNumberOfAttempts() {
        boolean isRetry = false;
        do {
            try {
                printConsoleMessage(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
                String inputTheNumberOfAttempt = Console.readLine();
                validation.validNumberOfAttempts(inputTheNumberOfAttempt);
                numberOfAttempts = toInteger(inputTheNumberOfAttempt);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
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

    private String[] toStringArray(String inputTheCarNames) {
        return inputTheCarNames.split(",");
    }

    private int toInteger(String inputTheNumberOfAttempt) {
        return Integer.parseInt(inputTheNumberOfAttempt);
    }

    private void printConsoleMessage(String message) {
        System.out.print(message);
    }
}
