package racingcar;

import java.util.ArrayList;

public class RacingGame {

	private static final String QUESTION_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
	private static final String QUESTION_TRY_NUM = "시도할 회수는 몇회인가요?\n";
	private static final String ERROR_MESSAGE_CHECK_STRING_IS_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.\n";
	private static final String ERROR_MESSAGE_CHECK_NAME_RULE = "[ERROR] 자동차 이름의 길이는 1이상 5이하를 만족해야 한다. "
		+ "그리고 중복되는 이름이 없어야 한다.\n";
	private static final String WINNER_OUTPUT_MESSAGE = "최종 우승자";
	private static final String AFTER_INIT_MESSAGE = "\n실행결과\n";
	private static final String COMMA_SPACE = ", ";
	private static final String SPACE_COLON_SPACE = " : ";

	private int totalTryNum;
	private Car[] cars;
	private RacingGameRule rule;

	RacingGame() {
		rule = new RacingGameRule();
	}

	private String[] getCarsNameInput(Player player) {
		boolean endCondition = false;
		String carsName = "";
		while (!endCondition) {
			carsName = player.askQuestionReturnAnswer(QUESTION_CARS_NAME);
			try {
				endCondition = rule.checkCarName(carsName);
			} catch (IllegalArgumentException e) {
				player.sendMessage(ERROR_MESSAGE_CHECK_NAME_RULE);
			}
		}
		return carsName.split(",");
	}

	private int getTryNumInput(Player player) {
		boolean endCondition = false;
		String totalTryNumInput = "";
		while (!endCondition) {
			totalTryNumInput = player.askQuestionReturnAnswer(QUESTION_TRY_NUM);
			try {
				endCondition = rule.checkTotalTryNum(totalTryNumInput);
			} catch (IllegalArgumentException e) {
				player.sendMessage(ERROR_MESSAGE_CHECK_STRING_IS_NUMBER);
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

	private void init(Player player) {
		String[] carNameBucket = getCarsNameInput(player);
		totalTryNum = getTryNumInput(player);
		makeCarInstance(carNameBucket);
		player.sendMessage(AFTER_INIT_MESSAGE);
	}

	private void moveAllCars() {
		for (int i = 0; i < cars.length; ++i) {
			cars[i].moveCar();
		}
	}

	private void printCurrentPositions(Player player) {
		for (int i = 0; i < cars.length; ++i) {
			player.sendMessage(
				cars[i].getName() + SPACE_COLON_SPACE + cars[i].getCurrentPositionVisualization() + "\n");
		}
		player.sendMessage("\n");
	}

	private void playOneCycle(Player player) {
		moveAllCars();
		printCurrentPositions(player);
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

	private void printWinners(Player player) {
		ArrayList<Integer> winnersIndex = getWinnersIndex();
		player.sendMessage(WINNER_OUTPUT_MESSAGE + SPACE_COLON_SPACE + getWinnersName(winnersIndex));
	}

	public void playRacingGame(Player player) {
		init(player);
		for (int cycle = 0; cycle < totalTryNum; ++cycle) {
			playOneCycle(player);
		}
		printWinners(player);
	}
}
