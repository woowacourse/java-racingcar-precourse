package racingcar.view;

import static racingcar.utils.StringUtils.*;

import racingcar.car.Car;

public class RacingResultView {
    private final Car car;
    private final StringBuilder result = new StringBuilder();

    public RacingResultView(Car car) {
        this.car = car;
    }

    public StringBuilder writeResult() {
        writeCarName();
        writeDelimiter();
        writeDistanceCovered();
        return result;
    }

    private void writeCarName() {
        result.append(car.getName());
    }

    private void writeDelimiter() {
        result.append(DELIMITER_BETWEEN_NAME_AND_DISTANCE_COVERED);
    }

    private void writeDistanceCovered() {
        for (int i = INITIAL_POSITION; i < car.getPosition(); i++) {
            result.append(MARK_FOR_DISTANCE_COVERED);
        }
    }
}
