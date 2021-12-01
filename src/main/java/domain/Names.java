package domain;

import java.util.List;

public class Names {
	private static final String DUPLICATE_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다.";

	private final List<Name> names;

	public Names(List<Name> names) {
		validateDuplication(names);
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
}
