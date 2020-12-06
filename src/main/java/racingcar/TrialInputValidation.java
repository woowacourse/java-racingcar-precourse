package racingcar;

public class TrialInputValidation {
    private static final String ERROR_TRIAL_NUMBER = "[ERROR] 시도 횟수는 자연수여야 합니다.";

    public static int checkTrialInput(String userInput) {
        int trialInput = checkIntegerInput(userInput);
        checkNaturalNumber(trialInput);
        return trialInput;
    }

    private static int checkIntegerInput(String userInput) {
        int trialInput = 0;
        try {
            trialInput = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.err.println(ERROR_TRIAL_NUMBER);
            System.exit(0);
        }
        return trialInput;
    }

    private static void checkNaturalNumber(int trialInput) {
        try {
            if(trialInput <= 0) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            System.err.println(ERROR_TRIAL_NUMBER);
            System.exit(0);
        }
    }
}
