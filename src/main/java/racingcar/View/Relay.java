package racingcar.View;

import racingcar.Car;
import racingcar.Util.TypeParser;

import java.util.List;

import static racingcar.Message.Rule.CAR_IN_LAPSE_SEPARATOR;

public class Relay extends TypeParser {

    public String showLapse(List<Car> cars) {
        StringBuilder lapse = new StringBuilder();

        for (Car car : cars) {
            lapse.append(car.getName());
            lapse.append(CAR_IN_LAPSE_SEPARATOR);
            lapse.append(positionToGauge(car.getPosition()));
            lapse.append("\n");
        }

        return lapse.toString();
    }

}
