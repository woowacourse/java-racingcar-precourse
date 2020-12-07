package racingcar;

import java.util.ArrayList;
import java.util.List;
import utils.ConstantUtils;

public class RacingCarGame {

    private final List<Car> carList = new ArrayList<>();
    private final List<String> winnerList = new ArrayList<>();
    private final int moves;
    private int maxScore = 0;

    public RacingCarGame(String[] carNames, int moves) {
        makeCar(carNames);
        this.moves = moves;
    }

    public void initGame() {
        startRacing();
        announceWinner();
    }

    private void makeCar(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void startRacing() {
        System.out.println();
        System.out.println(ConstantUtils.RACE_RESULT);
        for (int i = 0; i < moves; i++) {
            oneLap();
            System.out.println();
        }
    }

    private void oneLap() {
        for (Car car : carList) {
            car.moveOrNot();
            printResultOfEachCar(car);
            setMaxScore(car);
        }
    }

    private void printResultOfEachCar(Car car) {
        System.out.print(car.getName() + ConstantUtils.NAME_RESULT_SEPARATOR);
        printPosition(car);
        System.out.println();
    }

    private void printPosition(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print(ConstantUtils.RACING_BAR);
        }
    }

    private void setMaxScore(Car car) {
        if (car.getPosition() > maxScore) {
            maxScore = car.getPosition();
        }
    }

    private void announceWinner() {
        System.out.print(ConstantUtils.FINAL_WINNER);
        addWinnerList();
        System.out.println(String.join(ConstantUtils.WINNERS_JOIN_DELIMITER, winnerList));
    }

    private void addWinnerList() {
        for (Car car : carList) {
            if (car.getPosition() == maxScore) {
                winnerList.add(car.getName());
            }
        }
    }

}
