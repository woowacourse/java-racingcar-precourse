package domain;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;
	
	private static final int MAX_COUNT = 3;
	private static final int MIN_COUNT = 1;

	private static final String COUNT_PATTERN = "^[0-9]*$";

	/**
	 * 사용자가 유의미한 값이 사용 가능한지 확인
	 * @param nameInput 사용자가 입력한 user name (ex : name1,name2,name3)
	 * @return 이용할 수 없는 값일 경우 true, 그렇지 않을 경우 false를 반환
	 */
	public static boolean isInvalidUserName(String nameInput) {
		if (nameInput == null) {
			return true;
		}

		String[] names = nameInput.split(",");
		Set<String> nameList = new HashSet<>();
		for (String name : names) {
			name = name.trim();
			if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
				System.out.println("각 name은 1~5글자만 가능합니다. 다시 입력해주세요.");
				return true;
			}
			nameList.add(name);
		}

		if (nameList.size() != names.length) {
			System.out.println("중복되는 name이 존재합니다. 다시 입력해주세요.");
			return true;
		}
		return false;
	}

	public static boolean isInvalidCount(String inputtedCount) {
		if(inputtedCount == null) {
			System.out.println("입력된 값이 없습니다. 다시 입력해주세요.");
			return true;
		}
		
		if(inputtedCount.length() < MIN_COUNT || inputtedCount.length() > MAX_COUNT) {
			System.out.println("숫자가 너무 작거나 큽니다. 다시 입력해주세요.");
			return true;
		}
		
		if(!Pattern.matches(COUNT_PATTERN, inputtedCount)) {
			System.out.println("0 이상의 자연수만 입력 가능합니다. 다시 입력해주세요.");
			return true;
		}
		return false;
	}
}
