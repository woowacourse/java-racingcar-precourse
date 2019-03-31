/*
 * @CarRacingGame.java      0.1 2019/03/31
 */

package domain;

import java.util.Scanner;

/**
 * 자동차 경주게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.1 2019/03/31
 */
public class CarRacingGame {
    private static final int ERROR = -1;
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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = scanner.nextLine();

        carNames = carNameString.split(",");
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
}
