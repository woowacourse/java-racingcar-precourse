package view.output;

import dto.AttemptResult;
import dto.Winners;

import java.util.List;

public interface OutputDisplayable {
    void printOperationResultLetters();

    void showAttemptResult(final List<AttemptResult> cars);

    void showWinners(final Winners winners);
}
