package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class GameSystem {
	private static final String DELIMITER = ",";
	private static final int MINIMUM_NUMBER_OF_ROUNDS = 1;
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NUMBER_OF_ROUNDS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 정수여야 합니다.";
	private static final String NON_POSITIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";
	private static final String REPLAY_OR_QUIT_INPUT_MESSAGE = "다시 시작하려면 1, 종료를 원하시면 2를 입력해주세요.";
	private static final String REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE = "[ERROR] 1 혹은 2만 입력 가능합니다.";

	private static String[] getCarNames(Scanner scanner) {
		return scanner.nextLine().split(DELIMITER, -1);
	}

	private static List<Car> getCarList(Scanner scanner) {
		return Arrays.stream(getCarNames(scanner))
				.map(String::trim)
				.map(Car::new)
				.collect(Collectors.toList());
	}

	private static Cars tryToCreateCars(Scanner scanner) {
		Cars cars;
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		try {
			cars = new Cars(getCarList(scanner));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			cars = null; // flag for while loop in the createCars method
		}
		return cars;
	}

	public static Cars createCars(Scanner scanner) {
		Cars cars;
		do {
			cars = tryToCreateCars(scanner);
		} while (cars == null);
		return cars;
	}

	private static void validateIntegerRounds(String rounds) throws IllegalArgumentException {
		try {
			Integer.parseInt(rounds);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NON_INTEGER_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE);
		}
	}

	private static void validatePositiveRounds(String rounds) throws IllegalArgumentException {
		int numberOfRoundsInput = Integer.parseInt(rounds);
		if (numberOfRoundsInput < MINIMUM_NUMBER_OF_ROUNDS) {
			throw new IllegalArgumentException(NON_POSITIVE_NUMBER_OF_ROUNDS_INPUT_ERROR_MESSAGE);
		}
	}

	private static int tryToGetRounds(Scanner scanner) {
		System.out.println(NUMBER_OF_ROUNDS_INPUT_MESSAGE);
		String rounds = scanner.nextLine();
		try {
			validateIntegerRounds(rounds);
			validatePositiveRounds(rounds);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			rounds = "0"; // flag for while loop in the getNumberOfRounds method
		}
		return Integer.parseInt(rounds);
	}

	public static int getRounds(Scanner scanner) {
		int rounds;
		do {
			rounds = tryToGetRounds(scanner);
		} while (rounds == 0);
		System.out.println();
		return rounds;
	}

	private static void validateIntegerReplayQuit(String replayQuit) throws IllegalArgumentException {
		try {
			Integer.parseInt(replayQuit);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
		}
	}

	private static void validateOneOrTwoReplayQuit(String replayQuit) throws IllegalArgumentException {
		int replayQuitInt = Integer.parseInt(replayQuit);
		if (replayQuitInt != 1 && replayQuitInt != 2) {
			throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
		}
	}

	private static int tryToGetReplayQuit(Scanner scanner) {
		System.out.println(REPLAY_OR_QUIT_INPUT_MESSAGE);
		String replayQuit = scanner.nextLine();
		try {
			validateIntegerReplayQuit(replayQuit);
			validateOneOrTwoReplayQuit(replayQuit);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			replayQuit = "0"; // flag for while loop in the getReplayOrQuitInput method
		}
		return Integer.parseInt(replayQuit);
	}

	private static int getReplayQuit(Scanner scanner) {
		int replayQuit;
		do {
			replayQuit = tryToGetReplayQuit(scanner);
		} while (replayQuit == 0);
		return replayQuit;
	}

	public static void decideReplayQuit(Scanner scanner) {
		int replayOrQuitInput = getReplayQuit(scanner);
		if (replayOrQuitInput == 1) {
			Application.main(null); // REPLAY
		}
		// OTHERWISE QUIT
	}
}
