package racingcar.view;

import static racingcar.utils.StringUtils.*;

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
        for (int i = INITIAL_POSITION; i < racingResult.getPosition(); i++) {
            resultToPrint.append(MARK_FOR_DISTANCE_COVERED);
        }
    }
}
