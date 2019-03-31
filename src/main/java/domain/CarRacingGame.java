/*
 * @CarRacingGame.java      0.2 2019/03/31
 */

package domain;

import java.util.Random;
import java.util.Scanner;

/**
 * 자동차 경주게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.2 2019/03/31
 */
public class CarRacingGame {
    private static final int ERROR = -1;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int CAR_MOVE_CONDITION = 4;

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
    }

    /* 사용자로부터 정보를 입력 받는 메소드 */
    private void inputFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        inputCarName(scanner);
        inputRacingRound(scanner);
    }

    private void inputCarName(Scanner scanner) {
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNameString = scanner.nextLine();

            carNames = carNameString.split(",");
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
            System.out.println("시도할 회수는 몇 회인가요?");

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
}
