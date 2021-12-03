package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private List<Car> participants;

	Game() {
		List<String> carNames = getCarNamesFromUser();
	}

	private List<String> getCarNamesFromUser() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputOfCarNames = Console.readLine();
		String[] names = inputOfCarNames.split(",");
		return Arrays.asList(names);
	}

	private boolean validateCarNames(List<String> names) {
		Set<String> setOfNames = new HashSet<>(names);
		if (names.size() != setOfNames.size()) {
			return false;
		}

		for (String name : setOfNames) {
			if (name.length() > 5) {
				return false;
			}
		}
		return true;
	}
}
