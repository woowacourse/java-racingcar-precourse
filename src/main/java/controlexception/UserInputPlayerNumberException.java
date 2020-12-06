package controlexception;

public class UserInputPlayerNumberException extends RuntimeException {
	static private int playerNumber;

	public UserInputPlayerNumberException(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	@Override
	public String getMessage() {
		return "[ERROR] 경기할 선수가 2명 미만입니다. 경기를 진행할 수 없습니다!";
	}
}
