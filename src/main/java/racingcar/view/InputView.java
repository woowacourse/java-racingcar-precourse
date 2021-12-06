package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.CountNotNumberMessageException;
import racingcar.exception.RacingCarException;
import racingcar.resource.message.InputMessage;
import racingcar.utils.Delimiter;
import racingcar.view.reader.Reader;
import racingcar.view.validator.InputViewValidator;

public class InputView {

    private final Reader reader;
    private final OutputView outputView;

    public InputView(Reader reader, OutputView outputView) {
        this.reader = reader;
        this.outputView = outputView;
    }

    public List<String> getNames() {
        outputView.printMessage(InputMessage.INPUT_NAMES_MESSAGE);
        return getValidNames();
    }

    private List<String> getValidNames() {
        while (true) {
            try {
                List<String> names = parsingNames();
                InputViewValidator.validateNames(names);
                return names;
            } catch (RacingCarException ex) {
                outputView.printErrorMessage(ex.getMessage());
            }
        }
    }

    private List<String> parsingNames() {
        String inputString = reader.readLine();
        inputString = appendSpaceBeforeSplit(inputString);
        return Arrays.stream(Delimiter.splitWithComma(inputString))
            .map(String::trim).collect(Collectors.toList());
    }

    private String appendSpaceBeforeSplit(String targetString) {
        return Delimiter.appendSpaceBehind(targetString);
    }

    public int getExecutionCount() {
        outputView.printMessage(InputMessage.INPUT_EXECUTION_COUNT_MESSAGE);
        return getValidExecutionCount();
    }

    private int getValidExecutionCount() {
        while (true) {
            try {
                int executionCount = parsingExecutionCount();
                InputViewValidator.validateExecutionCount(executionCount);
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

}
