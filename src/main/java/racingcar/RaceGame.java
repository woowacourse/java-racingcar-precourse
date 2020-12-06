package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import utils.RandomUtils;

import javax.print.attribute.standard.PrinterName;
import java.util.List;
import java.util.Scanner;

import static racingcar.Constant.*;

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
        for (int i = 0; i < repetitionCount; i++) {
            doRound();
        }
    }

    private void doRound() {
        manageCarMovement();
        OutputView.printRaceResults();
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
