package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class User {

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;

    private static final String NAME_SEPARATOR = ",";
    private static final String ERROR_MESSAGE_CAR_NAME = "[ERROR] 자동차 이름은 길이 5 이하의 영어 대소문자로 구성되어야 합니다.";
    private static final String REGULAR_CAR_NAME_EXPRESSION = "^[a-zA-Z]{1,5}$";
    private static final String ERROR_MESSAGE_CAR_COUNT = "[ERROR] 자동차는 2대 이상 입력되어야 합니다.";

    public User(InputDisplay inputDisplay, OutputDisplay outputDisplay) {
        this.inputDisplay = inputDisplay;
        this.outputDisplay = outputDisplay;
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
