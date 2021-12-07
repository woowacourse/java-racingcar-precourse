package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
	private List<Name> names;

	public Names(List<String> list) {
		this.names = list.stream()
			.map(Name::of)
			.collect(Collectors.toList());
	}

	public static Names from(List<String> list) {
		return new Names(list);
	}

	public List<Name> getNames() {
		return this.names;
	}
}
