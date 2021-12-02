package racingcar;

public class RacingGame {

	private static final String QUESTION_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String QUESTION_TRY_NUM = "시도할 회수는 몇회인가요?";
	private static final String ERROR_MESSAGE_CHECK_STRING_IS_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";

	private int totalTryNum;

	RacingGame() {
		getInput();
	}

	private String[] getCarsNameInput() {
		System.out.println(QUESTION_CARS_NAME);
		String carsName = camp.nextstep.edu.missionutils.Console.readLine();
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

	private void getInput() {
		String[] carNameBucket = getCarsNameInput();
		totalTryNum = getTryNumInput();

		System.out.println(carNameBucket);
		System.out.println(totalTryNum);
	}
}
