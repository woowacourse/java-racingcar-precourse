/*
 * @(#)RacingGame.java     1.0 2019.12.09
 *
 * Copyright (c) 2019 lxxjn0.
 */
package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 사용자로부터 자동차의 이름을 입력받고 게임을 진행 후 우승자를 출력하는 전반적인 진행을 담당하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.0 2019.12.09
 */
public class RacingGame {
	/**
	 * 가장 많이 이동한 횟수(furthestPosition)가 0(출발선)인 경우를 확인하기 위한 상수.
	 */
	private static final int STARTING_LINE = 0;

	/**
	 * 출력 형식을 위해 우승자들 중 첫번째 우승자를 선택할 때 사용하기 위한 상수.
	 */
	private static final int FIRST_OF_WINNER = 0;

	/**
	 * 시도 횟수가 1 이상의 정수인지 확인하기 위한 상수.
	 */
	private static final int MIN_ATTEMPT_NUMBER = 1;

	/**
	 * 자동차 이름의 최소 길이 조건에 만족하는지 확인하기 위한 상수.
	 */
	private static final int MIN_LEN_OF_CAR_NAME = 1;

	/**
	 * 자동차 이름의 최대 길이 조건에 만족하는지 확인하기 위한 상수.
	 */
	private static final int MAX_LEN_OF_CAR_NAME = 5;

	/**
	 * 문자열을 쉼표(,)를 기준으로 자를 때 사용하기 위한 상수.
	 */
	private static final String COMMA_DELIMITER = ",";

	/**
	 * 자동차의 이동한 위치를 표현할 때 사용하기 위한 상수.
	 */
	private static final String MOVING_BAR = "-";

	/**
	 * 자동차의 이름이 영문자 또는 숫자로만 이루어져 있는지 확인하기 위한 정규식 상수.
	 */
	private static final String CAR_NAME_FORMAT = "^[a-zA-Z0-9]*$";

	/**
	 * 자동차 이름을 입력받을 때 출력할 메시지 상수.
	 */
	private static final String INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	/**
	 * 자동차 이름의 길이에 오류가 존재할 경우 출력할 메시지 상수.
	 */
	private static final String INPUT_LENGTH_ERROR_MESSAGE = "경주할 자동차 이름은 5자 이하만 가능합니다. ";

	/**
	 * 자동차 이름의 형식에 오류가 존재할 경우 출력할 메시지 상수.
	 */
	private static final String INPUT_TYPE_ERROR_MESSAGE = "경주할 자동차 이름은 공백을 제외한 영문자와 숫자로만 작성 가능합니다. ";

	/**
	 * 자동차 이름에 중복이 존재할 경우 출력할 메시지 상수.
	 */
	private static final String INPUT_DUPLICATE_MESSAGE = "중복된 자동차 이름이 존재합니다. ";

	/**
	 * 시도 횟수를 입력할 때 오류가 발생할 경우 출력할 메시지 상수.
	 */
	private static final String WRONG_INPUT_MESSAGE = "잘못된 입력입니다. ";

	/**
	 * 재 입력을 요청할 때 출력할 메시지 상수.
	 */
	private static final String RE_ENTER_MESSAGE = "다시 입력해주세요.";

	/**
	 * 시도 횟수를 입력받을 때 출력할 메시지 상수.
	 */
	private static final String INPUT_ATTEMPT_REQUEST_MESSAGE = "시도할 회수는 몇 회인가요?";

	/**
	 * 실행 결과를 보여줄 때 출력할 메시지 상수.
	 */
	private static final String MOVE_RESULT_MESSAGE = "실행 결과";

	/**
	 * 이름에 대한 위치 결과를 구분하기 위한 상수.
	 */
	private static final String COLON = " : ";

	/**
	 * 모든 자동차 위치가 출발선에 위치할 경우 출력할 메시지 상수.
	 */
	private static final String NO_WINNER_EXIST_MESSAGE = "자동차들이 모두 출발선에 위치해 있습니다. 우승자가 존재하지 않습니다.";

	/**
	 * 최종 우승자들을 출력할 메시지 상수.
	 */
	private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

	/**
	 * 사용자로부터 입력받은 자동차의 이름을 저장하기 위한 String 변수.
	 */
	private String userInput;

	/**
	 * 사용자로부터 입력받은 시도 횟수를 저장하기 위한 int 변수.
	 */
	private int attemptNumber;

	/**
	 * 입력받은 자동차의 이름을 저장할 List 변수.
	 */
	private List<String> carNames;

	/**
	 * 생성한 Car 클래스의 객체들을 저장할 List 변수.
	 */
	private List<Car> cars;

	/**
	 * 사용자로부터 자동차의 이름을 받아오는 것부터 우승 결과까지 출력하는 전체 진행을 담당하는 메소드.
	 */
	public void run() {
		receiveCarNames();
		generateCarInstances();
		receiveAttemptNumber();
		System.out.println(" ");
		moveAndPrintResultForAttemptNumber();
		printRaceWinner();
	}

	/**
	 * 자동차의 이름을 입력받아 유효성을 검사 후, 유효하다면 carNames 문자열 리스트에 저장하는 메소드.
	 */
	private void receiveCarNames() {
		Scanner sc = new Scanner(System.in);

		do {
			carNames = new ArrayList<>();

			System.out.println(INPUT_REQUEST_MESSAGE);
			userInput = sc.nextLine();
			processUserInput();
		} while (!isValidInput());
	}

	/**
	 * 사용자로부터 입력받은 자동차 이름을 쉼표(,)를 기준으로 자르고, 앞과 뒤에 존재하는 불필요한 공백을 제거하는 메소드.
	 */
	private void processUserInput() {
		carNames = splitToCarNames();
		removeUnnecessarySpace();
	}

	/**
	 * 자동차의 이름을 쉼표(,)를 기준으로 잘라서 List로 반환하는 메소드.
	 *
	 * @return 자동차 이름이 저장된 List 반환.
	 */
	private List<String> splitToCarNames() {
		return Arrays.asList(userInput.split(COMMA_DELIMITER));
	}

	/**
	 * 자동차의 이름의 앞과 뒤에 존재하는 불필요한 공백을 제거하는 메소드.
	 */
	private void removeUnnecessarySpace() {
		for (int i = 0; i < carNames.size(); i++) {
			carNames.set(i, carNames.get(i).trim());
		}
	}

	/**
	 * 사용자로부터 입력받은 자동차의 이름이 유효한지 여부를 확인하는 메소드.
	 *
	 * @return 사용자로부터 입력받은 자동차의 이름이 유효하면 true 반환.
	 */
	private boolean isValidInput() {
		if (!isValidLength()) {
			System.out.println(INPUT_LENGTH_ERROR_MESSAGE + RE_ENTER_MESSAGE);
			return false;
		}
		if (!isValidFormat()) {
			System.out.println(INPUT_TYPE_ERROR_MESSAGE + RE_ENTER_MESSAGE);
			return false;
		}
		if (!isNoDuplication()) {
			System.out.println(INPUT_DUPLICATE_MESSAGE + RE_ENTER_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * 모든 자동차의 이름이 1자 이상 5자 이하인지 확인하는 메소드.
	 *
	 * @return 모든 자동차의 이름의 길이가 유효하면 true 반환.
	 */
	private boolean isValidLength() {
		for (String car : carNames) {
			if ((car.length() < MIN_LEN_OF_CAR_NAME) || (car.length() > MAX_LEN_OF_CAR_NAME)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 모든 자동차의 이름의 형식(공백이 존재하지 않는 숫자 혹은 영문자로 구성)이 유효한 지 확인하는 메소드.
	 *
	 * @return 모든 자동차의 이름의 형식이 유효하다면 true 반환.
	 */
	private boolean isValidFormat() {
		for (String car : carNames) {
			if (!Pattern.matches(CAR_NAME_FORMAT, car)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 동일한 자동차 이름이 중복되어 존재하는지 여부를 확인하는 메소드.
	 *
	 * @return 중복된 이름이 존재하지 않는 경우 true 반환.
	 */
	private boolean isNoDuplication() {
		HashSet<String> removedDuplicateCarNames = new HashSet<>(carNames);
		return (removedDuplicateCarNames.size() == carNames.size());
	}

	/**
	 * 유효함이 검증된 자동차의 이름으로 Car 클래스 객체를 생성하는 메소드.
	 */
	private void generateCarInstances() {
		cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	/**
	 * 사용자로부터 시도 횟수를 입력받고, 유효한지 여부도 확인하는 메소드.
	 */
	private void receiveAttemptNumber() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println(INPUT_ATTEMPT_REQUEST_MESSAGE);
				attemptNumber = sc.nextInt();
				isValidAttemptNumber();
				break;
			} catch (InputMismatchException e) {
				System.out.println(WRONG_INPUT_MESSAGE + RE_ENTER_MESSAGE);
				sc = new Scanner(System.in);
			}
		}
	}

	/**
	 * 입력이 정수로 확인된 이후, 해당 정수가 1 이상인지 확인하는 메소드.
	 *
	 * @throws InputMismatchException 1 이상의 정수가 아니라면 예외 발생.
	 */
	private void isValidAttemptNumber() throws InputMismatchException {
		if (!(attemptNumber >= MIN_ATTEMPT_NUMBER)) {
			throw new InputMismatchException();
		}
	}

	/**
	 * 입력받은 시도 횟수만큼 이동하면서, 매 번 실행 결과를 출력하는 메소드.
	 */
	private void moveAndPrintResultForAttemptNumber() {
		for (int i = 0; i < attemptNumber; i++) {
			moveAllTheCarsOnce();
			printMovingResult();
			System.out.println(" ");
		}
	}

	/**
	 * 모든 자동차들의 이동을 진행시키는 메소드.
	 */
	private void moveAllTheCarsOnce() {
		for (Car car : cars) {
			car.moveAndSetFurthestPosition();
		}
	}

	/**
	 * 자동차들의 진행이 끝나고 실행 결과를 출력하는 메소드.
	 */
	private void printMovingResult() {
		System.out.println(MOVE_RESULT_MESSAGE);
		for (Car car : cars) {
			System.out.println(car.getName() + COLON + toStringMovingBar(car.getPosition()));
		}
	}

	/**
	 * 자동차의 위치만큼 -(하이픈)을 붙여서 문자열로 반환하는 메소드.
	 *
	 * @param position 자동차의 현재 위치.
	 * @return 자동차의 위치만큼 -(하이픈)을 붙여 만든 문자열을 반환.
	 */
	private String toStringMovingBar(int position) {
		StringBuilder movingBar = new StringBuilder();

		for (int i = 0; i < position; i++) {
			movingBar.append(MOVING_BAR);
		}
		return movingBar.toString();
	}

	/**
	 * 우승한 자동차들의 이름을 출력하는 메소드.
	 */
	private void printRaceWinner() {
		if (isAllCarsOnStartingLine()) {
			System.out.println(NO_WINNER_EXIST_MESSAGE);
			return;
		}
		System.out.println(combineWinnerNames() + WINNER_RESULT_MESSAGE);
	}

	/**
	 * 모든 자동차가 이동하지 않고 출발선에 위치해 있는지 여부를 확인하는 메소드.
	 *
	 * @return 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)이 0이면 true 반환.
	 */
	private boolean isAllCarsOnStartingLine() {
		return (Car.getFurthestPosition() == STARTING_LINE);
	}

	/**
	 * 우승한 자동차들의 이름을 하나의 문자열로 합치는 메소드.
	 *
	 * @return 우승한 자동차들의 이름이 하나로 합쳐진 문자열을 반환.
	 */
	private String combineWinnerNames() {
		StringBuilder winnerNames = new StringBuilder();
		List<Car> winners = selectRaceWinner();

		winnerNames.append(winners.get(FIRST_OF_WINNER).getName());
		for (int i = FIRST_OF_WINNER + 1; i < winners.size(); i++) {
			winnerNames.append(COMMA_DELIMITER + " ").append(winners.get(i).getName());
		}
		return winnerNames.toString();
	}

	/**
	 * Car 클래스에 저장된 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)과 위치가 동일한 자동차들을 반환하는 메소드.
	 *
	 * @return 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)과 위치가 동일한 자동차 객체 List를 반환.
	 */
	private List<Car> selectRaceWinner() {
		List<Car> winners = new ArrayList<>();

		for (Car car : cars) {
			if (car.getPosition() == Car.getFurthestPosition()) {
				winners.add(car);
			}
		}
		return winners;
	}
}
