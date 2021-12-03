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

        int index = 1;
        while (index < cars.size() && cars.get(index).compareTo(winner) == 0) {
            finalWinner.append(Constant.STANDARD_FOR_FINAL_WINNER);
            finalWinner.append(cars.get(index).getName());
            index++;
        }

        System.out.println(finalWinner);

    }
}
