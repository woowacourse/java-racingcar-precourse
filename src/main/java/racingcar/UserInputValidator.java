package racingcar;

public class UserInputValidator {

	public boolean checkNameLength(String name){
		if(name.length() > 6){
			return false;
		}

		return true;
	}

	public boolean checkInt(String trialTime){

		for(int i = 0; i < trialTime.length(); i++) {
			if ((trialTime.charAt(i) < '0') || (trialTime.charAt(i) > '9')){
				return false;
			}
		}
		return true;
	}
}
