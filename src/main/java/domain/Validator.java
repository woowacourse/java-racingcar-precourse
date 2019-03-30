package domain;

public class Validator {

	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;

	public static boolean isInvalidUserName(String nameInput) {
		String[] names = nameInput.split(",");
		for (String name : names) {
			name = name.trim();
			if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
				System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
				return true;
			}
		}
		return false;
	}
}
