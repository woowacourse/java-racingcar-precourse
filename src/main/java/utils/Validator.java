package utils;

import java.util.List;

public class Validator {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	
	public static boolean isMovable() {
		int random = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
		
		if (random >= 4) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isUseableCar(List<String> carNames) {
		if (carNames.size() <= 0) {
			return false;
		}
		
		for (String car : carNames) {
			if (car.length() < 1 || car.length() > 5) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isUseableTriedCnt(int triedCnt) {
		if (triedCnt <= 0) {
			return false;
		}
		return true;
	}
}
