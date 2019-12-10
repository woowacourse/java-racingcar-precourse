package domain;

import exception.InvalidInputException;

public class TrialTimes {

    private static int MINIMUM_TRIAL_TIMES = 1;

    int trialTimes;

    public TrialTimes(String inputString) {
        try {
            trialTimes = Integer.parseInt(inputString);
            if (trialTimes < MINIMUM_TRIAL_TIMES) {
                throw new InvalidInputException(InvalidInputException.INVALID_TRIAL_TIME_EXCEPTION_MESSAGE);
            }
        } catch (NumberFormatException ne) {
            throw new InvalidInputException(InvalidInputException.NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public int getTrialTimes() {
        return trialTimes;
    }

}
