package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {

    private List<Car> carList = new ArrayList<>();
    private int moves;
    private int maxScore;
    private List<String> racingWinner = new ArrayList<>();
    private PlayerResponse playerResponse;

    public RacingCarGame(Scanner scanner) {
        playerResponse = new PlayerResponse(scanner);
    }

    public void initGame() {
        makeCar(playerResponse.getCarNames());
        moves = playerResponse.getHowManyMoves();
        startRacing();
        announceWinner();
    }

    private void announceWinner() {
        System.out.print("최종 우승자: ");
        addRacingWinnerList();
        System.out.println(String.join(", ", racingWinner));
    }

    private void addRacingWinnerList() {
        for (Car car : carList) {
            if (car.getPosition() == maxScore) {
                racingWinner.add(car.getName());
            }
        }
    }

    private void startRacing() {
        System.out.println("실행결과");
        for (int i = 0; i < moves; i++) {
            oneLap();
            System.out.println();
        }
    }

    private void oneLap() {
        for (Car car : carList) {
            car.moveOrNot();
            System.out.print(car.getName() + " : ");
            setMaxScore(car);
            printPosition(car);
            System.out.println();
        }
    }

    private void setMaxScore(Car car) {
        if (car.getPosition() > maxScore) {
            maxScore = car.getPosition();
        }
    }

    private void printPosition(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print("-");
        }
    }


    private void makeCar(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }


}
