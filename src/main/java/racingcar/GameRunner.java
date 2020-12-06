package racingcar;

import exception.CarNameOverFiveException;
import exception.MoveCountNotIntegerException;
import exception.MoveCountNotOverZeroException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class GameRunner {

    private final int CAR_NAME_LENGTH_LIMIT = 5;
    private final int RANDOM_MIN = 0;
    private final int RANDOM_MAX = 9;

    private final String nameSplitter = ",";
    private final String winnerDelimiter = ", ";

    private List<Car> carList;
    private int moveCount;
    private int maxPosition;

    public GameRunner() {
        carList = new ArrayList<>();
        moveCount = 0;
        maxPosition = 0;
    }

    public void getCarName(final Scanner scanner) {
        if (!scanner.hasNext()) {
            throw new IllegalArgumentException();
        }
        String carInput = scanner.nextLine();
        parseCarInput(carInput);
    }

    public void parseCarInput(String carInput) {
        String[] carSplit = carInput.split(nameSplitter);
        for (String carName : carSplit) {
            if (checkCarNameLengthLimit(carName)) {
                Car car = new Car(carName);
                carList.add(car);
            }
        }
    }

    public boolean checkCarNameLengthLimit(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new CarNameOverFiveException();
        }

        return true;
    }

    public void getMoveCount(final Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new MoveCountNotIntegerException();
        }
        int inputMoveCount = scanner.nextInt();
        if (inputMoveCount <= 0) {
            throw new MoveCountNotOverZeroException();
        }
        moveCount = inputMoveCount;
    }

    public void runCarRace() {
        for (int i = 0; i < moveCount; i++) {
            moveAllCar();
            renewMaxPosition();
            printAllCarMovement();
            printEmptyLine();
        }
    }

    public void moveAllCar() {
        for (Car car : carList) {
            int random = getRandomNumber();
            car.move(random);
        }
    }

    public int getRandomNumber() {
        return RandomUtils.nextInt(RANDOM_MIN, RANDOM_MAX);
    }

    public void renewMaxPosition() {
        for (Car car : carList) {
            int curPosition = car.getPosition();

            if (curPosition > maxPosition) {
                maxPosition = curPosition;
            }
        }
    }

    public void printAllCarMovement() {
        for (Car car : carList) {
            printMessage(car.getPositionString());
        }
    }

    public String getWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return String.join(winnerDelimiter, winnerList);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
