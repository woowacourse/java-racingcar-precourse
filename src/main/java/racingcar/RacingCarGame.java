package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class RacingCarGame {

    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNERS = "최종 우승자: ";
    private static final String JOIN_DELIM = ",";
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 0;

    private final InputView inputView;

    RacingCarGame(Scanner scanner) {
        inputView = new InputView(scanner);
    }


    public void runGame() {
        int maxPosition;
        ArrayList<String> winners;
        Car[] cars = inputView.getCars();
        int trial = inputView.getTrials();

        race(cars, trial);
        maxPosition = getMaxPosition(cars);
        winners = getWinners(cars, maxPosition);
        printWinners(winners);

    }

    private void race(Car[] cars, int trial) {
        System.out.println(RESULT);
        repeatMove(cars, trial);
    }

    private void repeatMove(Car[] cars, int trial) {
        for (int i = 0; i < trial; i++) {
            move(cars);
            breakLine();
        }
    }

    private void move(Car[] cars) {
        for (Car car : cars) {
            car.move(getRandom());
        }
    }

    private int getRandom() {
        return RandomUtils.nextInt(LOWER_BOUND, UPPER_BOUND);
    }


    private void breakLine() {
        System.out.println();
    }

    private int getMaxPosition(Car[] cars) {
        int[] positions = new int[cars.length];

        for (int i = 0; i < cars.length; i++) {
            positions[i] = cars[i].getPosition();
        }
        Arrays.sort(positions);
        return positions[positions.length - 1];
    }

    private ArrayList<String> getWinners(Car[] cars, int maxPosition) {
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printWinners(ArrayList<String> winners) {
        System.out.print(FINAL_WINNERS);
        System.out.println(String.join(JOIN_DELIM, winners));
    }
}
