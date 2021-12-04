package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private final List<Car> participants;
	private final int numberOfTrials;
	private int[] scoreBoard;

	Game() {
		List<String> carNames = getCarNamesFromUser();
		if (!validateCarNames(carNames)) {
			throw new IllegalArgumentException();
		}

		this.participants = carNames.stream().map(Car::new).collect(Collectors.toList());
		this.numberOfTrials = getNumberOfTrials();
		this.scoreBoard = new int[this.participants.size()];
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

	private List<Car> findWinner() {
		List<Integer> scoreBoard = Arrays.stream(this.scoreBoard).boxed().collect(Collectors.toList());
		int maxPosition = Collections.max(scoreBoard);
		List<Car> winners = new ArrayList<>();

		for (int i = 0; i < this.scoreBoard.length; i++) {
			if (this.scoreBoard[i] == maxPosition) {
				winners.add(this.participants.get(i));
			}
		}

		return winners;
	}

	private void printWinner() {
		List<Car> winners = findWinner();
		System.out.print("최종 우승자 : ");
		winners.get(0).printName();

		for (int i = 1; i < winners.size(); i++) {
			System.out.print(", ");
			winners.get(i).printName();
		}
	}

	public void start() {
		System.out.println("실행 결과");

		for (int i = 0; i < this.numberOfTrials; i++) {
			for (int j = 0; j < this.participants.size(); j++) {
				scoreBoard[j] += participants.get(j).move();
			}

			System.out.println();
		}

		printWinner();
	}
}
