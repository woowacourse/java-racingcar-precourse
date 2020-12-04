package racingcar;

import utils.ErrorUtils;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private int tryNum;
    private List<Car> cars;

    public RacingGame() {
        cars = new ArrayList<Car>();
    }

    public void startGame(Scanner scanner) {
        InputUtils.inputNames(scanner, cars);
        tryNum = InputUtils.inputTryNumber(scanner);
        if (tryNum < 1) {
            ErrorUtils.printNumError(tryNum);
            tryNum = InputUtils.inputTryNumber(scanner);
        }
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNum; i++) {
            playOneRound();
        }
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.tryToMoveForward();
            Result.printCarName(car.getName());
            Result.printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    public void endGame() {
        Result.printFinalWinner(setWinner());
    }

    public List<String> setWinner() {
        List<String> winners = new ArrayList<String>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
