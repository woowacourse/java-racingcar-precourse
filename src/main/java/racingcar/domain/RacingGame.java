package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class RacingGame {

    private static final String NAME_SEPARATOR = ",";
    private static final String ERROR_MESSAGE_CAR_NAME = "[ERROR] 자동차 이름은 길이 5 이하의 영어 대소문자로 구성되어야 합니다.";
    private static final String REGULAR_CAR_NAME_EXPRESSION = "^[a-zA-Z]{1,5}$";
    private static final String ERROR_MESSAGE_CAR_COUNT = "[ERROR] 자동차는 2대 이상 입력되어야 합니다.";
    private static final String SPACE = " ";
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String NEW_LINE = "\n";
    private static final String COLON = " : ";

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;

    public RacingGame(InputDisplay inputDisplay, OutputDisplay outputDisplay) {
        this.inputDisplay = inputDisplay;
        this.outputDisplay = outputDisplay;
    }

    public String announceWinner(List<Car> carNames) {
        Cars cars = new Cars(carNames);
        List<String> winners = cars.makeWinnerList(carNames);

        return makeWinnerPrintFormat(winners);
    }

    protected String makeWinnerPrintFormat(List<String> winners) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PRINT_WINNER_MESSAGE);

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i));

            if (i != (winners.size() - 1)) {
                stringBuilder.append(NAME_SEPARATOR).append(SPACE);
            }
        }

        return stringBuilder.toString();
    }

    public void playTotalRound(final List<Car> cars, final int rounds) {
        outputDisplay.printEmptyLine();
        outputDisplay.printExecutionResultMessage();

        for (int i = 0; i < rounds; i++) {
            String oneRoundResult = playOneRound(cars);

            outputDisplay.printEachRoundResult(oneRoundResult);
            outputDisplay.printEmptyLine();
        }
    }

    protected String playOneRound(List<Car> cars) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            int randomNumberToMove = car.inputMoveForwardNumber();

            if (car.decideMoveCar(randomNumberToMove)) {
                car.moveCar(car);
            }

            stringBuilder.append(connectEachCarOneRoundResult(car));
        }

        return stringBuilder.toString();
    }

    private StringBuilder connectEachCarOneRoundResult(Car car) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(car.getCarName())
                .append(COLON)
                .append(car.getSpeed())
                .append(NEW_LINE);

        return stringBuilder;
    }

    public List<Car> makeCarNameList() {
        String inputCarNames = "";

        do {
            try {
                inputCarNames = inputCarNames();
                checkCarNamesError(inputCarNames);
                checkCarCountError(inputCarNames);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputDisplay.printErrorMessage(illegalArgumentException);
            }
        } while (!validateCarNames(inputCarNames));

        return splitInputCarNames(inputCarNames);
    }

    protected String inputCarNames() {
        inputDisplay.printInputCarNameMessage();

        return inputValue();
    }

    protected boolean checkCarNamesMatchFormat(final Car splitCarName) {
        return !(splitCarName.getCarName().matches(REGULAR_CAR_NAME_EXPRESSION));
    }

    protected void checkCarNamesError(final String inputCarNames) {
        List<Car> splitInputCarNames = splitInputCarNames(inputCarNames);

        for (Car splitCarName : splitInputCarNames) {
            if (checkCarNamesMatchFormat(splitCarName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME);
            }
        }

    }

    protected boolean validateCarNames(final String inputCarNames) {
        List<Car> splitInputCarNames = splitInputCarNames(inputCarNames);
        boolean checkCarNamesRule = !checkCarCountRule(splitInputCarNames);

        for (Car splitCarName : splitInputCarNames) {
            if (checkCarNamesMatchFormat(splitCarName)) {
                checkCarNamesRule = false;
            }
        }

        return checkCarNamesRule;
    }

    protected boolean checkCarCountRule(final List<Car> splitInputCarNames) {
        return splitInputCarNames.size() < 2;
    }

    protected void checkCarCountError(final String inputCarNames) {
        List<Car> splitInputCarNames = splitInputCarNames(inputCarNames);
        if (checkCarCountRule(splitInputCarNames)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_COUNT);
        }
    }

    protected String inputValue() {
        return Console.readLine();
    }

    protected List<Car> splitInputCarNames(final String inputCarNames) {
        final StringTokenizer stringTokenizer = new StringTokenizer(inputCarNames, NAME_SEPARATOR);
        final List<Car> carNames = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            carNames.add(new Car(stringTokenizer.nextToken()));
        }

        return carNames;
    }

}
