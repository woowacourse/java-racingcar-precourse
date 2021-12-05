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
import racingcar.utils.CountRange;
import racingcar.utils.Delimiter;
import racingcar.utils.NameLength;
import racingcar.view.input.Reader;

public class InputView {

    private final Reader reader;
    private final OutputView outputView;

    public InputView(Reader reader, OutputView outputView) {
        this.reader = reader;
        this.outputView = outputView;
    }

    public List<String> getNames() {
        outputView.printMessage(OutputMessage.INPUT_NAMES_MESSAGE);
        return getValidNames();
    }

    private List<String> getValidNames() {
        while (true) {
            try {
                List<String> names = parsingNames();
                validateNames(names);
                return names;
            } catch (RacingCarException ex) {
                outputView.printErrorMessage(ex.getMessage());
            }
        }
    }

    private List<String> parsingNames() {
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
        outputView.printMessage(OutputMessage.INPUT_EXECUTION_COUNT_MESSAGE);
        return getValidExecutionCount();
    }

    private int getValidExecutionCount() {
        while (true) {
            try {
                int executionCount = parsingExecutionCount();
                validateExecutionCountIsBiggerThanStandard(executionCount);
                return executionCount;
            } catch (RacingCarException ex) {
                outputView.printErrorMessage(ex.getMessage());
            }
        }
    }

    private int parsingExecutionCount() {
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
