package racingcar;

import static racingcar.InputCarNames.getCarNames;
import static racingcar.InputTryCount.getTryCount;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        int tryCount = getTryCount(scanner);
        Car[] racingCars = makeCars(carNames);

        System.out.println("\n실행 결과");
        while (tryCount > 0) {
            startGame(racingCars);
            tryCount--;
        }
        ArrayList<String> winners = getWinners(racingCars);
        System.out.print("최종 우승자: " + String.join(", ", winners));
    }

    private static Car[] makeCars(String[] carNames) {
        int carCount = carNames.length;
        Car[] racingCars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            racingCars[i] = new Car(carNames[i]);
        }
        return racingCars;
    }

    private static void startGame(Car[] racingCars) {
        for (Car car : racingCars) {
            car.ride();
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static ArrayList<String> getWinners(Car[] racingCars) {
        ArrayList<String> winners = new ArrayList<>();
        int max = 0;

        for (Car car : racingCars) {
            if (max < car.getPosition()) {
                // first car is included
                winners.clear();
                winners.add(car.getName());
                max = car.getPosition();
                continue;
            }
            if (max == car.getPosition()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
