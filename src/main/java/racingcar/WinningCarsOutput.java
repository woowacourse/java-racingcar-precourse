package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinningCarsOutput {
    private static final String SEPARATOR = ", ";
    private static final String WINNING_CARS_ANNOUNCEMENT = "최종 우승자: ";

    public static void announceWinningCars(List<Car> winningCars) {
        System.out.print(WINNING_CARS_ANNOUNCEMENT);
        String winningCarsNames = winningCars.stream()
            .map(car -> car.toString())
            .collect(Collectors.joining(SEPARATOR));
        System.out.println(winningCarsNames);
    }
}
