package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    private static final String FINAL_WINNER = "최종 우승자";
    private static final String POSITION = "-";

    public static void printCurrentCarsPosition(List<Car> cars) {
        cars.forEach(OutputView::printEachCarPosition);
        System.out.println();
    }

    private static void printEachCarPosition(Car car) {
        String position = "";
        for (int i = 0; i < car.position(); i++) {
            position += POSITION;
        }
        System.out.printf("%s : %s%n", car.name(), position);
    }

    public static void printWinner(List<Car> cars) {
        int max = findMaxPosition(cars);
        String winners = findWinners(cars, max);
        System.out.printf("%s : %s%n", FINAL_WINNER, winners);
    }

    private static String findWinners(List<Car> cars, int max) {
        return cars.stream()
            .map(car -> findWinners(max, car))
            .filter(s -> !s.isEmpty())
            .collect(Collectors.joining(","));
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::position).max().orElse(0);
    }

    private static String findWinners(int max, Car car) {
        if (car.position() == max) {
            return car.name();
        }
        return "";
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
