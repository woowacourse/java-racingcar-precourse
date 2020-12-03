package racingcar;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        initializeRace(scanner);
    }

    public static void initializeRace(Scanner scanner){
        InputView inputView = new InputView(scanner);
        inputView.parseUserNames();
        inputView.parseUserTrialCount();

        Cars cars = new Cars();
        cars.makeCars(inputView.getUserNames());

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.initiate(cars);


    }
}
