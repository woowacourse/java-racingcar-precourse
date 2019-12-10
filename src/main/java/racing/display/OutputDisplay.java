package racing.display;

import racing.domain.Car;
import racing.domain.CarList;
import racing.domain.Winner;

public class OutputDisplay {

    public static void printResult(Winner winner) {

    }

    public static void printCarsStatus(CarList cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car);
            stringBuilder.append('\n');
        }

        System.out.println(stringBuilder);
    }

}
