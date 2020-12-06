package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVEMENT_BASE_VALUE = 4;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private Car[] cars;

    public Game(Scanner scanner) {
        inputManager = new InputManager(scanner);
        outputManager = new OutputManager();
    }

    public void run() {
        setUp();
        showMovingResult();
        finish();
    }

    public void setUp() {
        outputManager.printInputCarNameMessage();
        inputManager.inputCarNameArray();
        generateCar(inputManager.getCarNameArray());
        outputManager.printInputTryNumberMessage();
        inputManager.inputTryNumber();
    }

    public void generateCar(String[] carNameArray) {
        cars = new Car[carNameArray.length];
        for (int i = 0; i < carNameArray.length; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
    }

    public void showMovingResult() {
        outputManager.printMovingResultHeader();
        for (int i = 0; i < inputManager.getTryNumber(); i++) {
            produceResult();
        }
    }

    public void produceResult() {
        for (int i = 0; i < cars.length; i++) {
            judgeMovement(cars[i]);
            outputManager.printOutputEachResultPosition(cars[i].getName(), cars[i].getPosition());
        }
        System.out.println();
    }

    public void judgeMovement(Car car) {
        if (generateRandomNumber() >= MOVEMENT_BASE_VALUE) {
            car.move();
        }
    }

    public int generateRandomNumber() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    public void finish() {
        outputManager.printOutputFinalWinner(selectWinner());
    }

    public List<String> selectWinner() {
        List<String> winnerNameList = new ArrayList<String>();
        int maxPosition = getMaxPosition();
        for (int i = 0; i < cars.length; i++) {
            if (maxPosition == cars[i].getPosition()) {
                winnerNameList.add(cars[i].getName());
            }
        }
        return winnerNameList;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (int i = 0; i < cars.length; i++) {
            if (maxPosition < cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
            }
        }
        return maxPosition;
    }
}

