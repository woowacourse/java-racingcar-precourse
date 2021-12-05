package racingcar;

import static racingcar.StringConstants.DELIMITER_BETWEEN_NAME_AND_DISTANCE_RECORD;
import static racingcar.StringConstants.MARK_FOR_DISTANCE_RECORD;

import java.util.stream.IntStream;

public class RacingResultView {
    private final Car car;
    private final StringBuilder result = new StringBuilder();

    public RacingResultView(Car car) {
        this.car = car;
    }

    public StringBuilder writeResult(Car car) {
        writeCarName();
        writeDelimiter();
        writeDistanceCovered();
        return result;
    }

    private void writeCarName() {
        result.append(car.getName());
    }

    private void writeDelimiter() {
        result.append(DELIMITER_BETWEEN_NAME_AND_DISTANCE_RECORD);
    }

    private void writeDistanceCovered() {
        IntStream.range(0, car.getPosition()).forEach(i -> result.append(MARK_FOR_DISTANCE_RECORD));
    }
}
