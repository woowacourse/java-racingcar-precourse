package racingcar.domain;

import racingcar.Car;
import racingcar.util.Util;

import java.util.function.Function;

public class ResultStringGenerator {

    public static Function<Car, String> generateExecutionResult() {
        return car -> car.getName() + " : " + Util.convertPositionToBar(car.getPosition()) + "\n";
    }
}
