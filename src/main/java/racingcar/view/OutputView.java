package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarDto;

public class OutputView {

    private static final String FINAL_WINNER = "최종 우승자";
    private static final String POSITION = "-";
    private static final String NOT_WINNER = "";

    public static void printCurrentCarsPosition(List<CarDto> cars) {
        cars.forEach(OutputView::printEachCarPosition);
        System.out.println();
    }

    private static void printEachCarPosition(CarDto car) {
        String position = "";
        for (int i = 0; i < car.position(); i++) {
            position += POSITION;
        }
        System.out.printf("%s : %s%n", car.name(), position);
    }

    public static void printWinner(List<CarDto> cars) {
        int max = findMaxPosition(cars);
        String winners = findWinners(cars, max);
        System.out.printf("%s : %s%n", FINAL_WINNER, winners);
    }

    private static String findWinners(List<CarDto> cars, int max) {
        return cars.stream()
            .map(car -> findWinners(max, car))
            .filter(carName -> !carName.equals(NOT_WINNER))
            .collect(Collectors.joining(","));
    }

    private static int findMaxPosition(List<CarDto> cars) {
        return cars.stream().mapToInt(CarDto::position).max().orElse(0);
    }

    private static String findWinners(int max, CarDto car) {
        if (car.position() == max) {
            return car.name();
        }
        return NOT_WINNER;
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
