package racingcar;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private Scanner scanner;
    public static final String MSG_RACE_RESULT = "\n실행 결과";
    public static final String DELIMITER_WINNER_STRING = ", ";
    public static final String PREFIX_WINNER_LIST = "최종 우승자: ";
    private ArrayList<String> carNames;
    private ArrayList<Car> carList;
    private ArrayList<String> winnerList;
    private int round;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        this.carNames = Input.askCarInfo(this.scanner);
        this.round = Input.askRound(this.scanner);

        convertStringToCarList();
        race();
        finalRound();
    }

    public void convertStringToCarList() {
        carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public void race() {
        System.out.println(MSG_RACE_RESULT);
        for (int i = 0; i < round; i++) {
            moveAndPrintPosition();
            System.out.println();
        }
    }

    public void moveAndPrintPosition() {
        carList.forEach(car -> {
            car.move();
            car.printPosition();
        });
    }

    public void finalRound() {
        winnerList = Winner.getWinner(carList);
        printFinalResult();
    }

    public void printFinalResult() {
        String winnerString = String.join(DELIMITER_WINNER_STRING, winnerList);
        System.out.println(PREFIX_WINNER_LIST + winnerString);
    }
}
