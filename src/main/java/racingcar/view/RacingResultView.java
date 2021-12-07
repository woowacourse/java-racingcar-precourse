package racingcar.view;

import static racingcar.utils.StringUtils.*;

import java.util.stream.IntStream;

import racingcar.gameresult.RacingResult;

public class RacingResultView {
    private final RacingResult racingResult;
    private final StringBuilder resultToPrint = new StringBuilder();

    public RacingResultView(RacingResult racingResult) {
        this.racingResult = racingResult;
        writeResult();
    }

    public void print() {
        System.out.println(resultToPrint.toString());
    }

    public void writeResult() {
        writeCarName();
        writeDelimiter();
        writeDistanceCovered();
    }

    private void writeCarName() {
        resultToPrint.append(racingResult.getCarName());
    }

    private void writeDelimiter() {
        resultToPrint.append(DELIMITER_BETWEEN_NAME_AND_DISTANCE_COVERED);
    }

    private void writeDistanceCovered() {
        IntStream.range(INITIAL_POSITION, racingResult.getPosition())
                .forEach(i -> resultToPrint.append(MARK_FOR_DISTANCE_COVERED));
    }
}
