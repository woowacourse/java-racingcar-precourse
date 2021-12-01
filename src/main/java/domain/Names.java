package domain;

import java.util.List;

public class Names {
	private static final String DUPLICATE_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다.";
	private static final String NAMES_COUNT_ERROR_MESSAGE = "이름을 최소 2개 이상 입력해주세요.";

	private static final int MINIMUM_NAMES_COUNT = 2;

	private final List<Name> names;

	public Names(List<Name> names) {
		validateDuplication(names);
		validateCount(names);

		this.names = names;
	}

	public List<Name> getNames() {
		return this.names;
	}

	private void validateDuplication(List<Name> names) {
		boolean duplicated = names.stream()
			.distinct()
			.count() != names.size();

		if (duplicated) {
			throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
		}
	}

	private void validateCount(List<Name> names) {
		if (names.size() < MINIMUM_NAMES_COUNT) {
			throw new IllegalArgumentException(NAMES_COUNT_ERROR_MESSAGE);
		}
	}
}
