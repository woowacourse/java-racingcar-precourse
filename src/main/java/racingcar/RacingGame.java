package racingcar;

import java.util.ArrayList;

public class RacingGame {

	private static final String QUESTION_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String QUESTION_TRY_NUM = "시도할 회수는 몇회인가요?";
	private static final String ERROR_MESSAGE_CHECK_STRING_IS_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";
	private static final String ERROR_MESSAGE_CHECK_NAME_RULE = "[ERROR] 자동차 이름의 길이는 1이상 5이하를 만족해야 한다.";
	private static final String WINNER_OUTPUT_MESSAGE = "최종 우승자";
	private static final String COMMA_SPACE = ", ";
	private static final String SPACE_COLON_SPACE = " : ";
	private static final int NAME_LENGTH_LIMIT = 5;

	private int totalTryNum;
	private Car[] cars;

	RacingGame() {
		init();
	}

	private boolean checkNoNameException(String carsName) {
		carsName = "," + carsName + ",";
		for (int i = 0; i < carsName.length() - 1; ++i) {
			String twoChar = carsName.substring(i, i + 2);
			if (twoChar.equals(",,")) {
				return false;
			}
		}
		return true;
	}

	private boolean checkNameLengthException(String carsName) {
		String[] carNameBucket = carsName.split(",");
		for (int i = 0; i < carNameBucket.length; ++i) {
			if (carNameBucket[i].length() > NAME_LENGTH_LIMIT) {
				return false;
			}
		}
		return true;
	}

	private boolean checkCarNameRule(String carsName) throws IllegalArgumentException {
		if (checkNoNameException(carsName) && checkNameLengthException(carsName))
			return true;
		throw new IllegalArgumentException();
	}

	private String[] getCarsNameInput() {
		boolean endCondition = false;
		String carsName = "";
		while (!endCondition) {
			System.out.println(QUESTION_CARS_NAME);
			carsName = camp.nextstep.edu.missionutils.Console.readLine();
			try {
				endCondition = checkCarNameRule(carsName);
			} catch (IllegalArgumentException e) {
				System.out.println(ERROR_MESSAGE_CHECK_NAME_RULE);
			}
		}
		return carsName.split(",");
	}

	private boolean checkStringIsNumber(String targetString) throws IllegalArgumentException {
		for (int i = 0; i < targetString.length(); ++i) {
			if (targetString.charAt(i) < '0' || targetString.charAt(i) > '9') {
				throw new IllegalArgumentException();
			}
		}
		return true;
	}

	private int getTryNumInput() {
		boolean endCondition = false;
		String totalTryNumInput = "";
		while (!endCondition) {
			System.out.println(QUESTION_TRY_NUM);
			totalTryNumInput = camp.nextstep.edu.missionutils.Console.readLine();
			try {
				endCondition = checkStringIsNumber(totalTryNumInput);
			} catch (IllegalArgumentException e) {
				System.out.println(ERROR_MESSAGE_CHECK_STRING_IS_NUMBER);
			}
		}
		return Integer.parseInt(totalTryNumInput);
	}

	private void makeCarInstance(String[] carNameBucket) {
		cars = new Car[carNameBucket.length];
		for (int i = 0; i < carNameBucket.length; ++i) {
			cars[i] = new Car(carNameBucket[i]);
		}
	}

	private void init() {
		String[] carNameBucket = getCarsNameInput();
		totalTryNum = getTryNumInput();
		makeCarInstance(carNameBucket);
	}

	private void moveAllCars() {
		for (int i = 0; i < cars.length; ++i) {
			cars[i].moveCar();
		}
	}

	private void printCurrentPositions() {
		for (int i = 0; i < cars.length; ++i) {
			System.out.printf("%s%s%s\n", cars[i].getName(), SPACE_COLON_SPACE,
				cars[i].getCurrentPositionVisualization());
		}
	}

	private void playOneCycle() {
		moveAllCars();
		printCurrentPositions();
	}

	private int getBestScore() {
		int bestScore = 0;
		for (int i = 0; i < cars.length; ++i) {
			if (cars[i].getPosition() > bestScore) {
				bestScore = cars[i].getPosition();
			}
		}
		return bestScore;
	}

	private ArrayList<Integer> getWinnersIndex() {
		int bestScore = getBestScore();
		ArrayList<Integer> winnersIndex = new ArrayList<>();
		for (int i = 0; i < cars.length; ++i) {
			if (bestScore == cars[i].getPosition()) {
				winnersIndex.add(i);
			}
		}
		return winnersIndex;
	}

	private String getWinnersName(ArrayList<Integer> winnersIndex) {
		StringBuilder winnersName = new StringBuilder();
		winnersName.append(cars[winnersIndex.get(0)].getName());
		for (int i = 1; i < winnersIndex.size(); ++i) {
			winnersName.append(COMMA_SPACE + cars[winnersIndex.get(i)].getName());
		}
		return winnersName.toString();
	}

	private void printWinners() {
		ArrayList<Integer> winnersIndex = getWinnersIndex();
		System.out.printf("%s%s%s%n", WINNER_OUTPUT_MESSAGE, SPACE_COLON_SPACE, getWinnersName(winnersIndex));
	}
}
