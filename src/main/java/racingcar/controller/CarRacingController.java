package racingcar.controller;

import racingcar.Car;
import racingcar.generator.NumberGenerator;
import racingcar.type.BoundaryType;
import racingcar.type.ErrorType;
import racingcar.type.TextType;

import java.util.*;

/** 자동차 경주 게임을 컨트롤하는 클래스 */
public class CarRacingController {

    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int ZERO = 0;

    private static ArrayList<Car> cars = new ArrayList<>();
    private static int times;

    public static void startCarRacing(Scanner scanner) {
        System.out.println(TextType.CAR_NAME_TEXT.getText());
        scanCars(scanner);
        System.out.println(TextType.CAR_RACING_TIMES_TEXT.getText());
        scanTimes(scanner);
    }

    public static void scanCars(Scanner scanner) {
        String scannerCars = scanner.nextLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(scannerCars.split(TextType.COMMA.getText())));
        for (String carName : carNames) {
            cars.add(validateCar(carName));
        }
        checkDuplicatedCar(cars);
    }

    public static void scanTimes(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(ErrorType.INVALID_CHARACTER.getError());
        }

        int scannerTimes = scanner.nextInt();
        times = validateTimes(scannerTimes);
    }

    public static Car validateCar(String carName) {
        // 자동차 이름의 길이가 1자 미만 또는 5자 초과인 경우
        if (carName.length() < MINIMUM_CAR_NAME_LENGTH || carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorType.INVALID_LENGTH.getError());
        }

        // 자동차 이름에 공백이 있는 경우
        if (carName.contains(TextType.BLANK.getText())) {
            throw new IllegalArgumentException(ErrorType.INVALID_FORMAT.getError());
        }

        return new Car(carName);
    }

    public static void checkDuplicatedCar(ArrayList<Car> cars) {
        Set<String> carSet = new HashSet<>();

        for (Car oneCar : cars) {
            carSet.add(oneCar.getName());
        }

        // 자동차 이름이 중복되는 경우
        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(ErrorType.INVALID_DUPLICATION.getError());
        }
    }

    public static int validateTimes(int scannerTimes) {
        // 시도할 횟수에 음수 또는 0이 입력되는 경우
        if (scannerTimes <= ZERO) {
            throw new IllegalArgumentException(ErrorType.INVALID_ZERO_TIME.getError());
        }

        return scannerTimes;
    }

    public static boolean moveCar() {
        int randomNumber = NumberGenerator.generateNumber();

            if ((BoundaryType.MINIMUM_MOVE_NUMBER.getBoundary() <= randomNumber) &&
                    (randomNumber <= BoundaryType.MAXIMUM_MOVE_NUMBER.getBoundary())) {
                // 자동차는 전진한다.
                return true;
            }

            if ((BoundaryType.MINIMUM_STOP_NUMBER.getBoundary() <= randomNumber) &&
                    (randomNumber <= BoundaryType.MAXIMUM_STOP_NUMBER.getBoundary())) {
                // 자동차는 멈춘다.
                return false;
            }

            throw new IllegalArgumentException(ErrorType.INVALID_RANDOM_NUMBER.getError());
    }
}
