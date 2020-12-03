package racingcar.controller;

import racingcar.Car;
import racingcar.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 자동차 경주 게임을 컨트롤하는 클래스 */
public class CarRacingController {

    private static final String CAR_NAME_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA = ",";
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "[ERROR] 자동차 이름의 길이는 1자 이상 5자 이하여야 합니다.";
    private static final String BLANK = " ";
    private static final String INVALID_CAR_NAME_FORMAT = "[ERROR] 자동차 이름은 공백 없이 입력해주세요.";

    private static ArrayList<Car> cars = new ArrayList<>();

    public static void startCarRacing(Scanner scanner) {
        System.out.println(CAR_NAME_TEXT);
        scanCars(scanner);
    }

    public static void scanCars(Scanner scanner) {
        String scannerCars = scanner.nextLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(scannerCars.split(COMMA)));
        for (String carName : carNames) {
            cars.add(validateCar(carName));
        }
    }

    public static Car validateCar(String carName) {
        // 자동차 이름의 길이가 1자 미만 또는 5자 초과인 경우
        if (carName.length() < MINIMUM_CAR_NAME_LENGTH || carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }

        // 자동차 이름에 공백이 있는 경우 (ex. ph o)
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT);
        }

        return new Car(carName);
    }
}