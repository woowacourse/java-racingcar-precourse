package racingcar;

public class RacingGame {

	private static final String QUESTION_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String QUESTION_TRY_NUM = "시도할 회수는 몇회인가요?";
	private static final String ERROR_MESSAGE_CHECK_STRING_IS_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";
	private static final String ERROR_MESSAGE_CHECK_NAME_RULE = "[ERROR] 자동차 이름의 길이는 1이상 5이하를 만족해야 한다.";
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
}
