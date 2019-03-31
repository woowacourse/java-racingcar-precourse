/*
 * @CarRacingGame.java      0.3 2019/04/01
 */

package domain;

import java.util.Random;
import java.util.Scanner;

/**
 * 자동차 경주게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.3 2019/04/01
 */
public class CarRacingGame {
    private static final int ERROR = -1;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int CAR_MOVE_CONDITION = 4;

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String INPUT_RACING_ROUND_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String PRINT_RACING_CARS_MESSAGE = "실행결과";

    /* 자동차의 이동을 나타내는 문자열 */
    private static final String CAR_MOVING_STRING = "-";

    private String[] carNames;
    private Car[] cars;
    private int round;

    public CarRacingGame() {
    }

    public void turnOn() {
        start();
    }

    private void start() {
        inputFromPlayer();
        readyCar();
        moveCars();
        printRacingCars();
    }

    /* 사용자로부터 정보를 입력 받는 메소드 */
    private void inputFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        inputCarName(scanner);
        inputRacingRound(scanner);
    }

    private void inputCarName(Scanner scanner) {
        do {
            System.out.println(INPUT_CAR_NAME_MESSAGE);
            String carNameString = scanner.nextLine();

            carNames = carNameString.split(CAR_NAME_SEPARATOR);
        } while (isCarNameError());
    }

    /* 자동차 이름이 5자 초과이면 에러를 반환하는 메소드 */
    private boolean isCarNameError() {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
                return true;
            }
        }

        return false;
    }

    private void inputRacingRound(Scanner scanner) {
        do {
            System.out.println(INPUT_RACING_ROUND_MESSAGE);

            try {
                round = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                round = ERROR;
            }
        } while (round == ERROR || round < 0);
    }

    /* Car 객체를 생성하는 메소드 */
    private void readyCar() {
        int size = carNames.length;
        cars = new Car[size];

        for (int i = 0; i < size; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            if (isMove(randomNumber())) {
                car.move();
            }
        }
    }

    /* 자동차를 전진시킬지 정지할지 판단하는 메소드 */
    private boolean isMove(int randomNumber) {
        return randomNumber >= CAR_MOVE_CONDITION;
    }

    private int randomNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_NUMBER_RANGE) + MIN_RANDOM_NUMBER;
    }

    private void printRacingCars() {
        System.out.println(PRINT_RACING_CARS_MESSAGE);

        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(CAR_MOVING_STRING);
            }
            System.out.println();
        }
    }
}
