package racingcar;

import java.util.ArrayList;

public class Winner {
    private static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String MORE_THAN_ONE_WINNER = ", ";
    private static final int NONE = 0;

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
            stringBuilder.append(MORE_THAN_ONE_WINNER);
        }
    }

    private boolean isWinner(Car car) {
        return car.getPosition() == Result.getMax();
    }
}
