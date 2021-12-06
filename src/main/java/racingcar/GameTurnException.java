package racingcar;

public class GameTurnException {
	private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
	private static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 0보다 커야 한다.";
	private String strGameTurn;

	public GameTurnException(String strGameTurn) {
		this.strGameTurn = strGameTurn;
	}

	public int setGameTurnWithoutException() {

		try {
			int intGameTurn = Integer.parseInt(strGameTurn);

			if (!isNumberPositive(intGameTurn)) {
				return 0;
			}

			return intGameTurn;
		} catch (IllegalArgumentException e) {
			System.out.println(NOT_NUMBER_ERROR_MESSAGE);
			return 0;
		}

	}

	private boolean isNumberPositive(int gameTurn) {

		try {

			if (gameTurn <= 0) {
				throw new IllegalArgumentException();
			}
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
			return false;
		}

	}
}
