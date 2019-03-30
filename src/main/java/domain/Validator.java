package domain;

import java.util.HashSet;
import java.util.Set;

public class Validator {

	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;

	/**
	 * 사용자가 유의미한 값이 사용 가능한지 확인
	 * @param nameInput 사용자가 입력한 user name (ex : name1,name2,name3)
	 * @return 이용할 수 없는 값일 경우 true, 그렇지 않을 경우 false를 반환
	 */
	public static boolean isInvalidUserName(String nameInput) {
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
		
		if(nameList.size() != names.length) {
			System.out.println("중복되는 name이 존재합니다. 다시 입력해주세요.");
			return true;
		}
		return false;
	}
}
