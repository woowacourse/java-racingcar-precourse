package racingcar.view.validator;

import java.util.Collections;
import java.util.List;

import racingcar.exception.CountTooSmallMessageException;
import racingcar.exception.NameDuplicateMessageException;
import racingcar.exception.NameEmptyMessageException;
import racingcar.exception.NameTooLongMessageException;
import racingcar.utils.CountRange;
import racingcar.utils.NameLength;

public class InputViewValidator {

	private static final InputViewValidator instance = new InputViewValidator();

	public static void validateNames(List<String> names) {
		instance.validateNameContainsEmpty(names);
		instance.validateNameIsDuplicated(names);
		instance.validateNameTooLong(names);
	}

	private void validateNameContainsEmpty(List<String> names) {
		if (names.stream().anyMatch(String::isEmpty)) {
			throw new NameEmptyMessageException();
		}
	}

	public void validateNameIsDuplicated(List<String> names) {
		if (names.stream().anyMatch(name -> checkNameDuplicated(names, name))) {
			throw new NameDuplicateMessageException();
		}
	}

	private boolean checkNameDuplicated(List<String> names, String name) {
		return (Collections.frequency(names, name) > 1);
	}

	private void validateNameTooLong(List<String> names) {
		if (names.stream().anyMatch(NameLength::isTooLong)) {
			throw new NameTooLongMessageException();
		}
	}

	public static void validateExecutionCount(int executionCount) {
		instance.validateExecutionCountIsBiggerThanStandard(executionCount);
	}

	private void validateExecutionCountIsBiggerThanStandard(int executionCount) {
		if (CountRange.isTooSmall(executionCount)) {
			throw new CountTooSmallMessageException();
		}
	}

}
