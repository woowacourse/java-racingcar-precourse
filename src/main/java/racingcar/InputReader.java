package racingcar;

import static racingcar.Validator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

	public static String[] returnCarNameList() {
		String[] nameList = new String[0];

		boolean isValid = false;
		while (!isValid) {
			String input = Console.readLine();
			nameList = input.split(",", -1);

			try {
				isValid = isValidCarNameList(nameList);
			} catch (IllegalArgumentException exception) {
				// TODO: 2021/12/02 메시지 출력 메서드로 추출
				System.out.println("[ERROR] " + exception.getMessage());
			}
		}

		return nameList;
	}

}
