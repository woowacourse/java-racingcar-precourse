package racingcar.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.NameDuplicateMessageException;
import racingcar.exception.NameEmptyMessageException;
import racingcar.exception.NameTooLongMessageException;
import racingcar.resource.rule.Delimiter;
import racingcar.resource.rule.NameLength;
import racingcar.view.input.Reader;

public class InputView {

    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public List<String> getNames() {
        String inputString = reader.readLine();
        List<String> names = convertStringToList(inputString);

        validateNames(names);

        return names;
    }

    private List<String> convertStringToList(String inputString) {
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

}
