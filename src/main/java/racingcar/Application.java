package racingcar;

import view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Application {
    private static final String REQUEST_INPUT_RACING_CAR_MSG = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_INPUT_ROUND_MSG = "시도할 횟수는 몇 회인가요?";
    private static final String ERROR_EMPTY_NAME_MSG = "[ERROR] 공백 이름은 사용할 수 없습니다.";
    private static final String ERROR_ID_MAX_LENGTH_MSG = "[ERROR] 사용자의 아이디는 5글자 이하여야 합니다.";
    private static final String ERROR_ID_DUPLICATE_MSG = "[ERROR] 중복된 사용자 이름입니다.";
    private static final String ERROR_MAX_SIZE_OF_PEOPLE_MSG = "[ERROR] 인원숫자를 확인해주십시오. ( 5명 이하)";
    private static final String COMMA = ",";

    private List<Car> cars;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application();
        app.start(scanner);
    }

    private void start(Scanner scanner) {
        ConsoleView view = new ConsoleView(scanner);

        view.println(REQUEST_INPUT_RACING_CAR_MSG);
        String carNames = view.inputNextLine();
        cars = makeCarList(carNames);

        view.println(REQUEST_INPUT_ROUND_MSG);
        int round = view.inputNextInt();
        Racing racing = new Racing(cars, round);

        while (racing.hasNextRound()) {
            racing.nextRound();
            view.println(racing.printResult());
        }
    }

    private List<Car> makeCarList(String userInput) {
        String[] carNames = userInput.split(COMMA);

        validateCarNamesSize(carNames);
        validateDuplicateCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            validateCarNameFormat(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateCarNameFormat(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME_MSG);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_ID_MAX_LENGTH_MSG);
        }
    }

    private void validateDuplicateCarNames(String[] carNames) {
        Set<String> duplicateCheckSet = new HashSet<>(Arrays.asList(carNames));
        if (duplicateCheckSet.size() != carNames.length) {
            throw new IllegalArgumentException(ERROR_ID_DUPLICATE_MSG);
        }
    }

    private void validateCarNamesSize(String[] carNames) {
        if (carNames.length > 5) {
            throw new IllegalArgumentException(ERROR_MAX_SIZE_OF_PEOPLE_MSG);
        }
    }
}
