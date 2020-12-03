package racingcar;

import utils.InputHandler;
import utils.RandomUtils;
import utils.SysMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {

    private final InputHandler inputHandler;
    private static final int maximum = 9;
    private static final int minimum = 0;
    private static final int criticalPoint = 4;
    private int roundCount;
    private final List<Car> carList;
    private final List<String> winnerNames;

    public GameManager(Scanner scanner) {
        this.inputHandler = new InputHandler(scanner);
        carList = new ArrayList<>();
        winnerNames = new ArrayList<>();
    }

    public void gameStart() {
        carListInitializer();
        roundCountInitializer();

        System.out.println(SysMessages.executeMessage);
        while (!hasAnyWinner()) {
            moveAllCars();
            displayAllCarState();
        }

        winnerListPrinter();
    }

    private void carListInitializer() {
        String[] carNames = inputHandler.getValidCarNames();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void roundCountInitializer() {
        roundCount = inputHandler.getValidRoundCount();
    }

    private boolean hasAnyWinner() {
        boolean returnFlag = false;
        for (Car car : carList) {
            if (car.getPosition() == roundCount) {
                returnFlag = true;
                winnerNames.add(car.getName());
            }
        }
        return returnFlag;
    }

    private void moveAllCars() {
        for (Car car : carList) {
            int engine = RandomUtils.nextInt(minimum, maximum);
            if (engine >= criticalPoint) car.increasePosition();
        }
    }

    private void displayAllCarState() {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            System.out.println(positionPrint(car));
        }
        System.out.println();
    }

    private String positionPrint(Car car) {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            position.append("-");
        }
        return position.toString();
    }

    private void winnerListPrinter() {
        System.out.print(SysMessages.winnerPrizeMessage);
        for (int i = 0; i < winnerNames.size(); i++) {
            System.out.print(winnerNames.get(i));
            if (i != winnerNames.size() - 1) System.out.print(", ");
        }
    }

}
