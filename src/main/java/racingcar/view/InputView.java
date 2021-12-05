package racingcar.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.CountNotNumberMessageException;
import racingcar.exception.CountTooSmallMessageException;
import racingcar.exception.NameDuplicateMessageException;
import racingcar.exception.NameEmptyMessageException;
import racingcar.exception.NameTooLongMessageException;
import racingcar.exception.RacingCarException;
import racingcar.resource.message.OutputMessage;
import racingcar.resource.rule.CountRange;
import racingcar.resource.rule.Delimiter;
import racingcar.resource.rule.NameLength;
import racingcar.view.input.Reader;

public class InputView {

    private final Reader reader;
    private final OutputView outputView;

    public InputView(Reader reader, OutputView outputView) {
        this.reader = reader;
        this.outputView = outputView;
    }

    public List<String> getNames() {
        try {
            outputView.printMessage(OutputMessage.INPUT_NAMES_MESSAGE);
            List<String> names = inputNames();

            validateNames(names);

            return names;

        } catch (RacingCarException ex) {
            outputView.printErrorMessage(ex.getMessage());
            return getNames();
        }
    }

    private List<String> inputNames() {
        String inputString = reader.readLine();
        return Arrays.stream(Delimiter.splitWithComma(inputString))
            .map(String::trim).collect(Collectors.toList());
    }

    private void validateNames(List<String> names) {
        validateNameIsDuplicated(names);
        validateNameContainsEmpty(names);
        validateNameTooLong(names);
    }

    private void validateNameIsDuplicated(List<String> names) {
        if (names.stream().anyMatch(name -> Collections.frequency(names, name) > 1)) {
            throw new NameDuplicateMessageException();
        }
    }

    private void validateNameContainsEmpty(List<String> names) {
        if (names.stream().anyMatch(String::isEmpty)) {
            throw new NameEmptyMessageException();
        }
    }

    private void validateNameTooLong(List<String> names) {
        if (names.stream().anyMatch(NameLength::isTooLong)) {
            throw new NameTooLongMessageException();
        }
    }

    public int getExecutionCount() {
        try {
            outputView.printMessage(OutputMessage.INPUT_EXECUTION_COUNT_MESSAGE);
            int executionCount = inputExecutionCount();

            validateExecutionCountIsBiggerThanStandard(executionCount);

            return executionCount;

        } catch (RacingCarException ex) {
            return getExecutionCount();
        }
    }

    private int inputExecutionCount() {
        try {
            String inputString = reader.readLine();
            return Integer.parseInt(inputString);
        } catch (NumberFormatException ex) {
            throw new CountNotNumberMessageException();
        }
    }

    private void validateExecutionCountIsBiggerThanStandard(int executionCount) {
        if (CountRange.isTooSmall(executionCount)) {
            throw new CountTooSmallMessageException();
        }
    }

}
