package racingcar;

import utils.GameUtils;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private Scanner scanner;
    private List<Car> racingCars = new ArrayList<Car>();
    private int numberOfRuns;
    private final int RANDOM_NUM_START = 0;
    private final int RANDOM_NUM_END = 9;
    private final int ARRAY_FIRST_WINNER_CAR = 0;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        registerCars();
        getNumberOfRunsFromUser();
        for (int i = 0; i < numberOfRuns; i++) {
            moveCars();
            printCars();
            System.out.println();
        }
        printWinner(findWinner());
    }

    public void registerCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.next().split("\\,");
        for (String carName : carNames) {
            GameUtils.isCarNameRight(carName);
            racingCars.add(new Car(carName));
        }
    }

    public void getNumberOfRunsFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        this.numberOfRuns = GameUtils.isNumOfRunsRight(scanner.next());
    }

    public void moveCars() {
        for (Car car : racingCars) {
            if(RandomUtils.nextInt(RANDOM_NUM_START, RANDOM_NUM_END) > 3){
                car.moveForward();
            }
        }
    }

    public void printCars() {
        for (Car car : racingCars) {
            System.out.println(car.getName() + " : " + (String.join("", Collections.nCopies(car.getPosition(), "-"))));
        }
    }

    public List<Car> findWinner() {
        List<Car> winner = new ArrayList<Car>();
        for (Car car : racingCars) {
            if (winner.isEmpty()) {
                winner.add(car);
                continue;
            }

            if (winner.get(ARRAY_FIRST_WINNER_CAR).getPosition() == car.getPosition()) {
                winner.add(car);
            }

            if (winner.get(ARRAY_FIRST_WINNER_CAR).getPosition() < car.getPosition()) {
                winner.clear();
                winner.add(car);
            }
        }

        return winner;
    }

    public void printWinner(List<Car> winner) {
        ArrayList<String> cars = new ArrayList<String>();
        for (Car car : winner) {
            cars.add(car.getName());
        }
        String winnerName = String.join(", ", cars);
        System.out.println("최종 우승자: " + winnerName);
    }
}
