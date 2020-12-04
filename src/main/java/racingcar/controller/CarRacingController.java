package racingcar.controller;

import org.w3c.dom.Text;
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
    private static ArrayList<Integer> carPositions = new ArrayList<>();
    private static int maxPosition = -1;
    private static ArrayList<String> winner = new ArrayList<>();

    public static void startCarRacing(Scanner scanner) {
        System.out.println(TextType.CAR_NAME_TEXT.getText());
        scanCars(scanner);
        System.out.println(TextType.CAR_RACING_TIMES_TEXT.getText());
        scanTimes(scanner);
        System.out.println();
        playCarRacing();
        showWinner();
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

        for (Car car : cars) {
            carSet.add(car.getName());
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

    public static void moveCar(Car car) {
        int randomNumber = NumberGenerator.generateNumber();

        if ((BoundaryType.MINIMUM_MOVE_NUMBER.getBoundary() <= randomNumber) &&
                (randomNumber <= BoundaryType.MAXIMUM_MOVE_NUMBER.getBoundary())) {
            // 자동차는 전진한다.
            car.movePosition();
        }

        if ((BoundaryType.MINIMUM_STOP_NUMBER.getBoundary() <= randomNumber) &&
                (randomNumber <= BoundaryType.MAXIMUM_STOP_NUMBER.getBoundary())) {
            // 자동차는 멈춘다.
            return;
        }
    }

    public static void playCarRacing() {
        System.out.println(TextType.RESULT.getText());

        for (int i = 0; i < times; i++) {
            for(int j = 0; j < cars.size(); j++) {
                Car car = cars.get(j);
                moveCar(car);
            }
            showResult();
            System.out.println();
        }
    }

    public static StringBuffer countPosition(Car car) {
        StringBuffer carPosition = new StringBuffer();
        for (int i = 0; i < car.getPosition(); i++) {
            carPosition.append(TextType.LINE.getText());
        }

        return carPosition;
    }

    public static void showResult() {
        for (Car car : cars) {
            StringBuffer carPosition = countPosition(car);
            System.out.println(car.getName() + " : " + carPosition);
        }
    }

    public static void addPosition() {
        for (Car car : cars) {
            carPositions.add(car.getPosition());
        }
    }

    public static void calculateMaxPosition() {
        addPosition();
        for (int i = 0; i < carPositions.size(); i++) {
            if (maxPosition < carPositions.get(i)) {
                maxPosition = carPositions.get(i);
            }
        }
    }

    public static void checkWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }
    }

    public static void showWinner() {
        calculateMaxPosition();
        checkWinner();

        System.out.print(TextType.WINNER.getText());
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != (winner.size() - 1)) {
                System.out.print(TextType.COMMA.getText() + TextType.BLANK.getText());
            }
        }
    }
}
