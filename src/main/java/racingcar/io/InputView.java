package racingcar.io;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;
import utils.Validator;

public class InputView {

    private static final String RACING_CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_CAR_NAME_SEPARATOR = ",";
    private static final String RACING_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static Scanner scanner;

    public InputView(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public List<Car> getCars() {
        System.out.println(RACING_CAR_NAME_REQUEST_MESSAGE);
        try {
            List<String> carNames = parseCarNames(scanner.nextLine());
            List<Car> cars = new LinkedList<>();
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
            return cars;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    private List<String> parseCarNames(String input) {
        input = input.replaceAll(" ", "");
        Validator.validateContainSeparator(input);

        List<String> carNames = Arrays.asList(input.split(RACING_CAR_NAME_SEPARATOR, 0));
        Validator.validateCanSeparated(carNames);
        Validator.validateContainDuplication(carNames);

        List<String> paredCarNames = new LinkedList<>();
        for (String carName : carNames) {
            Validator.validateContainSpecialCharacters(carName);
            Validator.validateLength(carName);
            paredCarNames.add(carName);
        }
        return paredCarNames;
    }

    public int getRaceCount() {
        System.out.println(RACING_MOVE_COUNT_MESSAGE);
        try {
            String input = scanner.nextLine();
            Validator.validateNumber(input);
            int raceCount = Integer.parseInt(input);
            Validator.validateOverZero(raceCount);
            return raceCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRaceCount();
        }
    }

}
