package racingcar.View;

import racingcar.Constant;
import racingcar.Model.Car;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printExecutionResult(List<Car> cars) {
        StringBuilder execution_result = new StringBuilder();
        for (Car car : cars) {
            execution_result.append(car.printPosition());
        }
        System.out.println(execution_result);
    }

    public static void printFinalWinner(List<Car> cars) {
        Collections.sort(cars);
        Car winner = cars.get(0);

        StringBuilder finalWinner = new StringBuilder(Constant.FINAL_WINNER);
        finalWinner.append(winner.getName());

        finalWinner.append(isMoreThanOneWinner(winner, cars.subList(1, cars.size())));

        System.out.println(finalWinner);
    }

    private static String isMoreThanOneWinner(Car winner, List<Car> cars) {
        StringBuilder winners = new StringBuilder("");
        for (Car candidate : cars) {
            if (candidate.compareTo(winner) != 0) {
                break;
            }
            winners.append(Constant.STANDARD_FOR_FINAL_WINNER);
            winners.append(candidate.getName());
        }
        return winners.toString();
    }

}
