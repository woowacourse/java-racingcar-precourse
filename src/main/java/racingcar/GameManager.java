package racingcar;

import utils.InputManager;
import utils.Sentences;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    public static final int MAXIMUM_CARNAME_LENGTH = 5;
    public String winners = "";

    public GameManager(Scanner scanner) {
        InputManager inputManager = new InputManager();
        ArrayList<Car> cars = new ArrayList<>(inputManager.scanCarNames(scanner));
        Round round = new Round(inputManager.scanRound(scanner));

        System.out.println(Sentences.SHOW_RESULT);
        for(int i = 0; i < round.getRound(); i++) {
            startRace(cars);
            showRace(cars);
            }
        judgeWinner(cars);
        winners = winners.substring(0, winners.length()-1);
        System.out.print(winners);
    }

    public void startRace(ArrayList<Car> cars) {
        for(Car car : cars) {
            car.moveForward();
        }
    }

    public void showRace(ArrayList<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print(Sentences.PROGRESS);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void judgeWinner(ArrayList<Car> cars) {
        int winCount = 0;
        //StringBuffer winners = new StringBuffer();
        for(Car car : cars) {
            if(car.getPosition() > winCount) {
                winCount = car.getPosition();
            }
        }
        System.out.print(Sentences.SHOW_WINNER);
        for(Car car : cars) {
            if(car.getPosition() == winCount) {
                winners += car.getName() + ",";
            }
        }
    }
}
