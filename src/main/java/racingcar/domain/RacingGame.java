package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGameMain {

    private static final String NAME_SEPARATOR = ",";
    private static final String ERROR_MESSAGE_CAR_NAME = "[ERROR] 자동차 이름은 길이 5 이하의 영어 대소문자로 구성되어야 합니다.";
    private static final String REGULAR_CAR_NAME_EXPRESSION = "^[a-zA-Z]{1,5}$";
    private static final String ERROR_MESSAGE_CAR_COUNT = "[ERROR] 자동차는 2대 이상 입력되어야 합니다.";
    private static final String SPACE = " ";
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;

    public RacingGameMain(InputDisplay inputDisplay, OutputDisplay outputDisplay) {
        this.inputDisplay = inputDisplay;
        this.outputDisplay = outputDisplay;
    }


    private String announceWinner(List<Car> cars) {
        List<String> winners = makeWinnerList(cars);

        return makeWinnerPrintFormat(winners);
    }

    private String makeWinnerPrintFormat(List<String> winners) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PRINT_WINNER_MESSAGE);

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i));

            if (i != winners.size() - 1) {
                stringBuilder.append(NAME_SEPARATOR).append(SPACE);
            }
        }

        return stringBuilder.toString();
    }

    private List<String> makeWinnerList(final List<Car> cars) {
        final List<String> winners = new ArrayList<>();
        final int topSpeed = findTopSpeed(cars);

        for (Car car : cars) {
            if (topSpeed == car.getPosition()) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    private int findTopSpeed(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> makeCarNameList() {
        String inputCarNames = "";

        do {
            try {
                inputCarNames = inputCarNames();
                checkCarNamesError(inputCarNames);
                checkCarCountError(inputCarNames);
            } catch (IllegalArgumentException e) {
                outputDisplay.printErrorMessage(e);
            }
        } while (!validateCarNames(inputCarNames));

        return splitInputCarNames(inputCarNames);
    }

    private String inputCarNames() {
        inputDisplay.printInputCarNameMessage();

        return inputValue();
    }

    private boolean checkCarNamesMatchFormat(final Car splitCarName) {
        return !(splitCarName.getCarName().matches(REGULAR_CAR_NAME_EXPRESSION));
    }

    public void checkCarNamesError(final String inputCarNames) {
        List<Car> splitInputCarNames = splitInputCarNames(inputCarNames);

        for (Car splitCarName : splitInputCarNames) {
            if (checkCarNamesMatchFormat(splitCarName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME);
            }
        }

    }

    public boolean validateCarNames(final String inputCarNames) {
        List<Car> splitInputCarNames = splitInputCarNames(inputCarNames);
        boolean checkCarNamesRule = !checkCarCountRule(splitInputCarNames);

        for (Car splitCarName : splitInputCarNames) {
            if (checkCarNamesMatchFormat(splitCarName)) {
                checkCarNamesRule = false;
            }
        }

        return checkCarNamesRule;
    }

    private boolean checkCarCountRule(final List<Car> splitInputCarNames) {
        return splitInputCarNames.size() < 2;
    }

    public void checkCarCountError(final String inputCarNames) {
        List<Car> splitInputCarNames = splitInputCarNames(inputCarNames);
        if (checkCarCountRule(splitInputCarNames)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_COUNT);
        }
    }

    public String inputValue() {
        return Console.readLine();
    }

    public List<Car> splitInputCarNames(final String inputCarNames) {
        final StringTokenizer stringTokenizer = new StringTokenizer(inputCarNames, NAME_SEPARATOR);
        final List<Car> carNames = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            carNames.add(new Car(stringTokenizer.nextToken()));
        }

        return carNames;
    }

}
