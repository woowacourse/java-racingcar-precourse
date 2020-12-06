package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {

    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String RACE_RESULT = "실행결과";
    private static final String NAME_RESULT_SEPARATOR = " : ";
    private static final String RACING_BAR = "-";
    private static final String JOIN_DELIMITER = ", ";
    private final List<Car> carList = new ArrayList<>();
    private final List<String> winnerList = new ArrayList<>();
    private final PlayerResponse playerResponse;
    private int moves;
    private int maxScore = 0;

    public RacingCarGame(Scanner scanner) {
        playerResponse = new PlayerResponse(scanner);
    }

    public void initGame() {
        makeCar(playerResponse.getCarNames());
        moves = playerResponse.getHowManyMoves();
        startRacing();
        announceWinner();
    }

    private void makeCar(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    private void startRacing() {
        System.out.println(RACE_RESULT);
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
        System.out.print(car.getName() + NAME_RESULT_SEPARATOR);
        printPosition(car);
        System.out.println();
    }

    private void printPosition(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print(RACING_BAR);
        }
    }

    private void setMaxScore(Car car) {
        if (car.getPosition() > maxScore) {
            maxScore = car.getPosition();
        }
    }

    private void announceWinner() {
        System.out.print(FINAL_WINNER);
        addWinnerList();
        System.out.println(String.join(JOIN_DELIMITER, winnerList));
    }

    private void addWinnerList() {
        for (Car car : carList) {
            if (car.getPosition() == maxScore) {
                winnerList.add(car.getName());
            }
        }
    }

}
