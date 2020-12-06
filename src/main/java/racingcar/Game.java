package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVEMENT_BASE_VALUE = 4;
    private Car[] cars;

    public Game(Scanner scanner) {
        inputManager = new InputManager(scanner);
        outputManager = new OutputManager();
    }

    /* 경주할 자동차 이름, 시도할 횟수 입력 받기 */
    public void start() {
        outputManager.printInputCarNameMessage();
        inputManager.inputCarNameArray();
        generateCar(inputManager.getCarNameArray());
        outputManager.printInputTryNumberMessage();
        inputManager.inputTryNumber();
        showMovingResult();
        finish();
    }

    /* 각 차수별로 각 자동차를 전진 또는 멈춤하고 실행 결과 출력 */
    public void showMovingResult() {
        outputManager.printMovingResultHeader();
        for (int i = 0; i < inputManager.getTryNumber(); i++) {
            produceResult();
        }
    }

    public void produceResult() {
        for (int i = 0; i < cars.length; i++) {
            judgeMovement(cars[i]);
            outputManager.printOutputEachResultPosition(cars[i].getName(),cars[i].getPosition());
        }
        System.out.println();
    }

    /* 최종 우승자 뽑고 출력 */
    public void finish() {
        outputManager.printOutputFinalWinner(selectWinner());

    }

    public int generateRandomNumber() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    public void judgeMovement(Car car) {
        if (generateRandomNumber() >= MOVEMENT_BASE_VALUE) {
            car.move();
        }
    }

    public List<String> selectWinner() {
        List<String> winnerNameList = new ArrayList<String>();
        int maxPosition = getMaxPosition();
        for (int i =0;i<cars.length;i++){
            if (maxPosition == cars[i].getPosition()) {
                winnerNameList.add(cars[i].getName());
            }
        }
        return winnerNameList;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (int i =0;i<cars.length;i++){
            if (maxPosition < cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
            }
        }
        return maxPosition;
    }
    public void generateCar(String[] carNameArray) {
        cars = new Car[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
    }

}

