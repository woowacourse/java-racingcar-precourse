package racingcar;

public class UserInputValidator {

	public static boolean checkNameLength(String[] names){

		for(String name : names){
			if(name.length() > 5){
				throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능하다.");
			}
		}

		return true;
	}

	public static boolean checkInt(String trialTime){

		for(int i = 0; i < trialTime.length(); i++) {
			if ((trialTime.charAt(i) < '0') || (trialTime.charAt(i) > '9')){
				throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
			}
		}
		return true;
	}
}
