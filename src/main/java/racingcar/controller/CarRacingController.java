package racingcar.controller;

import racingcar.Car;
import racingcar.generator.NumberGenerator;

import java.util.*;

/** 자동차 경주 게임을 컨트롤하는 클래스 */
public class CarRacingController {

    private static final String CAR_NAME_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_RACING_TIME_TEXT = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "[ERROR] 자동차 이름의 길이는 1자 이상 5자 이하여야 합니다.";
    private static final String BLANK = " ";
    private static final String INVALID_CAR_NAME_FORMAT = "[ERROR] 자동차 이름은 공백 없이 입력해주세요.";
    private static final String INVALID_CAR_NAME_DUPLICATION = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_SCANNER_TYPE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    private static final int ZERO = 0;
    private static final String INVALID_SCANNER_TIMES = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";

    private static ArrayList<Car> cars = new ArrayList<>();
    private static int times;

    public static void startCarRacing(Scanner scanner) {
        System.out.println(CAR_NAME_TEXT);
        scanCars(scanner);
        System.out.println(CAR_RACING_TIME_TEXT);
        scanTimes(scanner);
    }

    public static void scanCars(Scanner scanner) {
        String scannerCars = scanner.nextLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(scannerCars.split(COMMA)));
        for (String carName : carNames) {
            cars.add(validateCar(carName));
        }
        checkDuplicatedCar(cars);
    }

    public static void scanTimes(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(INVALID_SCANNER_TYPE);
        }

        int scannerTimes = scanner.nextInt();
        times = validateTimes(scannerTimes);
    }

    public static Car validateCar(String carName) {
        // 자동차 이름의 길이가 1자 미만 또는 5자 초과인 경우
        if (carName.length() < MINIMUM_CAR_NAME_LENGTH || carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }

        // 자동차 이름에 공백이 있는 경우
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT);
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
            throw new IllegalArgumentException(INVALID_CAR_NAME_DUPLICATION);
        }
    }

    public static int validateTimes(int scannerTimes) {
        // 시도할 횟수에 0이 입력되는 경우
        if (scannerTimes == ZERO) {
            throw new IllegalArgumentException(INVALID_SCANNER_TIMES);
        }

        return scannerTimes;
    }
}
