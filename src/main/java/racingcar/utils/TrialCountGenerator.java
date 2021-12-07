package racingcar.utils;

public class TrialCountGenerator {
	public static int generateTrialCount(String trialCount) {
		TrialCountValidation.isValidateTrialCount(trialCount);
		return Integer.parseInt(trialCount);
	}
}
