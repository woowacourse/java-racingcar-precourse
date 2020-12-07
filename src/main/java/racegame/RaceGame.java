package racegame;

import racegame.view.InputView;
import racegame.view.OutputView;
import racingcar.Car;
import utils.RandomUtils;
import utils.WinnersFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static racegame.Constant.*;

public class RaceGame {

    private final Scanner scanner;
    private List<Car> carList;

    public RaceGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputCarsName() {
        OutputView.printNormal(OUTPUT_VIEW_NAME);
        carList = InputView.getCarList(scanner);
    }

    public void playRounds(int repetitionCount) {
        OutputView.printNormal(OUTPUT_VIEW_ROUND_RESULT_HEADER);
        for (int i = 0; i < repetitionCount; i++) {
            doRound();
        }
    }

    private void doRound() {
        manageCarMovement();
        OutputView.printRoundResult(carList);
    }

    public void printWinners(){
        String winners = WinnersFinder.getWinnersStringBuffer(carList);
        OutputView.printWinners(winners);
    }

    private void manageCarMovement(){
        for(Car car : carList){
            int number = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            if(isOverPivot(number)){
                car.moveForward();
            }
        }
    }

    private boolean isOverPivot(int number){
        if(number >= RANDOM_UTILS_NUMBER_PIVOT){
            return true;
        }
        return false;
    }
}
