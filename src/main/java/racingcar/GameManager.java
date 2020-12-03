package racingcar;

import utils.InputManager;
import utils.Sentences;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    public static final int MAXIMUM_CARNAME_LENGTH = 5;

    public GameManager(Scanner scanner) {
        InputManager inputManager = new InputManager();
        ArrayList<Car> cars = new ArrayList<>(inputManager.scanCarNames(scanner));
        Round round = new Round(inputManager.scanRound(scanner));
        System.out.println("최종 우승자 : " + Sentences.SHOW_RESULT);

        while(true) {
            startRace(cars);
            showRace(cars);
            if(judge(cars, round).size() != 0) {
                System.out.println(judge(cars, round));
                break;
            }
        }
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
            System.out.println(car.getName() + " : " + progress);
            System.out.println("\n");
        }
    }

    public ArrayList<String> judge(ArrayList<Car> cars, Round round) {
        ArrayList<String> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getPosition() == round.getRound()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
