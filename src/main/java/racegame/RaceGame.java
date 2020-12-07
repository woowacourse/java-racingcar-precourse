package racegame;

import racegame.view.InputView;
import racegame.view.OutputView;
import racingcar.Car;
import utils.RandomUtils;

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
        int maxPosition = getMaximumPosition(carList);
        StringBuffer winners = getWinnersStringBuffer(carList, maxPosition);

        OutputView.printWinners(winners.toString());
    }

    private static int getMaximumPosition(List<Car> carList){
        List<Integer> list = new ArrayList<>();
        for (Car car : carList) {
            list.add(car.getPosition());
        }
        return list.stream().max(Integer::compare).orElse(0);
    }

    private static StringBuffer getWinnersStringBuffer(List<Car> carList, int maxPosition){
        StringBuffer winners = new StringBuffer();
        for(Car car : carList){
            if(car.getPosition() == maxPosition) {
                winners = printNameDelimiter(winners, winners.length());
                winners.append(car.getName());
            }
        }
        return winners;
    }

    private static StringBuffer printNameDelimiter(StringBuffer winners, int length){
        if(length >0){
            winners.append(OUTPUT_VIEW_WINNER_DELIMITER);
        }
        return winners;
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
