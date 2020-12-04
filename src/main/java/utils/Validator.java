package utils;

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
}
