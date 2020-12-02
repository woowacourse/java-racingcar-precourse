package racingcar;

import exception.CarNameOverFiveException;
import exception.MoveCountNotIntegerException;
import exception.MoveCountNotOverZeroException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class GameRunner {

    private List<Car> carList;
    private int moveCount;
    private int maxPosition;

    public GameRunner() {
        carList = new ArrayList<>();
        moveCount = 0;
        maxPosition = 0;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
