package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RacingCarGame {

    private final InputView inputView;

    RacingCarGame(Scanner scanner) {
        inputView = new InputView(scanner);
    }


    public void runGame() {
        int maxPosition;
        int trial = inputView.getTrials();
        ArrayList<String> winners;
        Car[] cars = inputView.getCars();

        race(cars, trial);
        maxPosition = getMaxPosition(cars);
        winners = getWinners(cars, maxPosition);
        printWinners(winners);

    }

    public void race(Car[] cars, int trial) {
        System.out.println("실행 결과");
        repeatMove(cars, trial);
    }

    public void repeatMove(Car[] cars, int trial) {
        for (int i = 0; i < trial; i++) {
            move(cars);
            breakLine();
        }
    }

    public void move(Car[] cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public void breakLine() {
        System.out.println();
    }

    public int getMaxPosition(Car[] cars) {
        int[] positions = new int[cars.length];
        int maxPosition;

        for (int i = 0; i < cars.length; i++) {
            positions[i] = cars[i].getPosition();
        }
        Arrays.sort(positions);
        maxPosition = positions[positions.length - 1];
        return maxPosition;
    }

    public ArrayList<String> getWinners(Car[] cars, int maxPosition) {
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinners(ArrayList<String> winners) {
        System.out.print("최종 우승자: ");
        System.out.println(String.join(",", winners));
    }
}
