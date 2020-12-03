package racingcar;

import utils.InputManager;
import utils.Sentences;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    public static final int MAXIMUM_CARNAME_LENGTH = 5;

    public GameManager(Scanner scanner) {
        InputManager inputManager = new InputManager();
        ArrayList<Car> cars = new ArrayList<>(inputManager.scanCarNames(scanner));
        Round round = new Round(inputManager.scanRound(scanner));
        System.out.println(Sentences.SHOW_RESULT);

        for(int i = 0; i < round.getRound(); i++) {
            startRace(cars);
            showRace(cars);
            System.out.println("\n");
            }

        printWinner(cars, round);
    }

    public void startRace(ArrayList<Car> cars) {
        for(Car car : cars) {
            car.moveForward();
        }
    }

    public void showRace(ArrayList<Car> cars) {
        for(Car car : cars) {
            ArrayList<String> progress = new ArrayList<>();
            for(int i = 0; i < car.getPosition(); i++) {
                progress.add(Sentences.PROGRESS);
            }
            System.out.println(car.getName() + " : " + progress.toString());
        }
    }

    public void printWinner(ArrayList<Car> cars, Round round) {
        int winCount = 0;
        for(Car car : cars) {
            if(car.getPosition() > winCount) {
                winCount = car.getPosition();
            }
        }
        System.out.println(Sentences.SHOW_WINNER);
        for(Car car : cars) {
            if(car.getPosition() == winCount) {
                System.out.println(car.getName());
            }
        }
        return;
    }
}
