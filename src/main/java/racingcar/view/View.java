package racingcar.view;

import racingcar.domain.car.CarInterface;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class View {
    private final String SPACE = " ";
    private final String COLON = ":";
    private final String NEW_LINE = "\n";
    private final String COMMA = ",";

    private Scanner scanner;
    private Validator validator;

    public View(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public List<String> askCarNames() {
        final String ASKING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(ASKING_CAR_NAME_MESSAGE);

        String carNameInput = scanner.nextLine();

        List<String> carNames = new ArrayList<>();
        StringTokenizer carNameToken = new StringTokenizer(carNameInput, COMMA);
        while (carNameToken.hasMoreTokens()) {
            carNames.add(carNameToken.nextToken());
        }

        validator.validateCarNames(carNames);

        return carNames;
    }

    public int askTrialCount() {
        final String ASKING_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
        System.out.println(ASKING_TRIAL_COUNT_MESSAGE);

        String stringTrialCount = scanner.nextLine();

        validator.validateTrialCount(stringTrialCount);

        int trialCount = Integer.parseInt(stringTrialCount);

        return trialCount;
    }

    public void printCurrentPosition(List<CarInterface> cars) {
        StringBuilder currentPositionMessage = new StringBuilder();
        for (CarInterface car : cars) {
            currentPositionMessage.append(car.getName());
            currentPositionMessage.append(SPACE + COLON + SPACE);
            currentPositionMessage.append(makeDash(car.getPosition()));
            currentPositionMessage.append(NEW_LINE);
        }
        System.out.println(currentPositionMessage.toString());
    }

    private String makeDash(int dashCount) {
        StringBuilder dash = new StringBuilder();
        for (int currentDashCount = 0; currentDashCount < dashCount; currentDashCount++) {
            dash.append("-");
        }
        return dash.toString();
    }

    public void printWinner(List<CarInterface> cars) {
        final String WINNER_MESSAGE = "최종 우승자";
        StringBuilder winnerAnnouncementStringBuilder = new StringBuilder();
        winnerAnnouncementStringBuilder.append(WINNER_MESSAGE);
        winnerAnnouncementStringBuilder.append(COLON);
        winnerAnnouncementStringBuilder.append(SPACE);

        List<String> winnerCarNames = new ArrayList<>();
        for (CarInterface car : cars) {
            winnerCarNames.add(car.getName());
        }
        winnerAnnouncementStringBuilder.append(String.join(", ", winnerCarNames));

        String winnerAnnouncementMessage = winnerAnnouncementStringBuilder.toString();
        System.out.println(winnerAnnouncementMessage);
    }

    public void printError(String errorMessage) {
        final String ERROR_PREFIX = "[ERROR] ";
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
