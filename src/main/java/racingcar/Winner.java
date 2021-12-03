package racingcar;

import java.util.ArrayList;

import static racingcar.constant.Constraint.NONE;
import static racingcar.constant.Message.OUTPUT_WINNER_MESSAGE;
import static racingcar.constant.Message.WINNER_MORE_THAN_ONE_MESSAGE;

public class Winner {
    private final ArrayList<Car> cars;

    public Winner(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return OUTPUT_WINNER_MESSAGE + decideWinner();
    }

    public String decideWinner() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            appendIfRaceWinner(stringBuilder, car);
        }

        return stringBuilder.toString();
    }

    private void appendIfRaceWinner(StringBuilder stringBuilder, Car car) {
        if (isWinner(car)) {
            appendIfNotFirstWinner(stringBuilder);
            stringBuilder.append(car.getName());
        }
    }

    private void appendIfNotFirstWinner(StringBuilder stringBuilder) {
        if (stringBuilder.length() != NONE) {
            stringBuilder.append(WINNER_MORE_THAN_ONE_MESSAGE);
        }
    }

    private boolean isWinner(Car car) {
        return car.getPosition() == Result.getMax();
    }
}
