package racingcar;

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
	private RacingGameRule rule;
	private RacingGameCarManager carManager;

	RacingGame() {
		rule = new RacingGameRule();
		carManager = new RacingGameCarManager();
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

	private void init(Player player) {
		String[] carNameBucket = getCarsNameInput(player);
		totalTryNum = getTryNumInput(player);
		carManager.makeCarInstance(carNameBucket);
		player.sendMessage(AFTER_INIT_MESSAGE);
	}

	private String getAllCarsCurrentPositionVisualizationData() {
		StringStringPair[] allCarsCurrentPositionData = carManager.getAllCarsCurrentPositionData();
		StringBuilder allCarsCurrentPositionVisualizationData = new StringBuilder();
		for (int i = 0; i < allCarsCurrentPositionData.length; ++i) {
			allCarsCurrentPositionVisualizationData.append(
				allCarsCurrentPositionData[i].key + SPACE_COLON_SPACE + allCarsCurrentPositionData[i].value);
		}
		allCarsCurrentPositionVisualizationData.append("\n");
		return allCarsCurrentPositionVisualizationData.toString();
	}

	private void playOneCycle(Player player) {
		carManager.moveAllCars();
		player.sendMessage(getAllCarsCurrentPositionVisualizationData());
	}

	private void sendWinnerNames(Player player) {
		String[] winnerNameBucket = carManager.getWinnerNameBucket();
		StringBuilder winnerNamesData = new StringBuilder();
		winnerNamesData.append(winnerNameBucket[0]);
		for (int i = 1; i < winnerNameBucket.length; ++i) {
			winnerNamesData.append(", " + winnerNameBucket[i]);
		}
		player.sendMessage(winnerNamesData.toString());
	}

	public void playRacingGame(Player player) {
		init(player);
		for (int cycle = 0; cycle < totalTryNum; ++cycle) {
			playOneCycle(player);
		}
		sendWinnerNames(player);
	}
}
