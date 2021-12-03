package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private final List<Car> participants;
	private final int numberOfTrials;

	Game() {
		List<String> carNames = getCarNamesFromUser();
		if (!validateCarNames(carNames)) {
			throw new IllegalArgumentException();
		}

		participants = carNames.stream().map(Car::new).collect(Collectors.toList());
		numberOfTrials = getNumberOfTrials();
	}

	private List<String> getCarNamesFromUser() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputOfCarNames = Console.readLine();
		String[] names = inputOfCarNames.split(",");
		return Arrays.asList(names);
	}

	private int getNumberOfTrials() {
		System.out.println("시도할 회수는 몇회인가요?");
		String inputOfNumberOfTrials = Console.readLine();
		if (!validateNumberOfTrials(inputOfNumberOfTrials)) {
			throw new IllegalArgumentException();
		}

		return Integer.parseInt(inputOfNumberOfTrials);
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

	private boolean validateNumberOfTrials(String input) {
		for (int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) - '0';
			if (number < 0 || number > 9) {
				return false;
			}
		}

		return true;
	}

}
