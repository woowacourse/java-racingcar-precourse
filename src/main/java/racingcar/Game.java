package racingcar;

import utils.RandomUtils;

import java.util.Scanner;

public class Game {
    private final Player player;
    private final Printer printer;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVEMENT_BASE_VALUE = 4;
    private Car[] cars;

    public Game(Scanner scanner) {
        player = new Player(scanner);
        printer = new Printer();
    }

    /* 경주할 자동차 이름, 시도할 횟수 입력 받기 */
    public void start() {
        printer.printInputCarNameMessage();
        player.inputCarNameArray();
        generateCar(player.getCarNameArray());
        printer.printInputTryNumberMessage();
        player.inputTryNumber();
    }

    /* 각 차수별로 각 자동차를 전진 또는 멈춤하고 실행 결과 출력 */
    public void showMovingResult() {
        printer.printMovingResultHeader();
        for (int i = 0; i < player.getTryNumber(); i++) {
            produceResult();
        }
    }

    public void produceResult() {
        for (int i = 0; i < cars.length; i++) {
            judgeMovement(cars[i]);
            printer.printOutputEachResultPosition(cars[i].getName(),cars[i].getPosition());
        }
        System.out.println();
    }

    /* 최종 우승자 뽑고 출력 */
    public void finish() {
    }

    public int generateRandomNumber() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    public void judgeMovement(Car car) {
        if (generateRandomNumber() >= MOVEMENT_BASE_VALUE) {
            car.move();
        }
    }

    public void selectWinner() {
    }

    public void generateCar(String[] carNameArray) {
        cars = new Car[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
    }
}
