package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Input {
	static String errorMassage;
	public static String[] carNames() {
		String[] CarNameArray = null;
		boolean right = true;
		while (right) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String Carstirng = Console.readLine();
			CarNameArray = StringToArray(Carstirng);
			try {
				right = exception(CarNameArray);
			} catch (IllegalArgumentException e) {
				System.out.println(errorMassage);
				
			}
		}
		return CarNameArray;
	}
	
	
	private static String[] StringToArray(String str) {
		String[] nameArray = str.split(",");

		for (int i = 0; i < nameArray.length; i++) {
			String name = nameArray[i];
			nameArray[i] = name.trim();
		}
		return nameArray;
	}
	
	private static boolean exception(String[] arr) throws IllegalArgumentException {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > 5 || arr[i].length() == 0) {
				errorMassage = "[ERROR] 자동차이름은 5자 이하여야한다.";
				throw new IllegalArgumentException("[ERROR] 자동차이름은 5자 이하여야한다.");
			}
		}
		return false;
	}

	
	
	public static int tryCount() {
		int tryNumberInt = 0;
		String tryNumberString = null;
		boolean NotNumber = false, NotZero = false;

		while (!NotNumber || !NotZero) { 
			System.out.println("시도할 회수는 몇회인가요?");
			tryNumberString = Console.readLine();

			try {
				NotNumber = numberCheck(tryNumberString);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			}
			try {
				tryNumberInt = Integer.parseInt(tryNumberString);
				NotZero= zeroCheck(tryNumberInt);
			}catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 시도 횟수는 1이상이여야 한다.");
			}
		}
		return tryNumberInt;
	}
	
	private static boolean numberCheck(String str) throws IllegalArgumentException {
		boolean isNumber;
		if (str.chars().allMatch(Character::isDigit)) {
			isNumber = true;
			return isNumber;
		}
		throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");

	}
	private static boolean zeroCheck(int number) throws IllegalArgumentException {
		boolean isNotZero;
		if (number > 0){
			isNotZero = true;
			return isNotZero;
		}
		throw new IllegalArgumentException("[ERROR] 시도 횟수는 1이상이여야 한다.");
	}

}
