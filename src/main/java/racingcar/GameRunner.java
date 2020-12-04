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

    private final String nameSplitter = ",";

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

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
