package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class InputUtils {

    public static String[] racerNameList;
    public static int roundCount;

    public String inputRunner;
    public String inputRoundCount;
    public HashSet<String> runnerNameCheckSet = new HashSet<String>();

    public InputUtils(Scanner promptInput) {
        System.out.println(Constants.RACER_NAME_ANNOUNCEMENT);
        this.inputRunner = promptInput.next();
        splitRacerNameByFormat();
        checkRacerNameValidation(racerNameList);

        System.out.println(Constants.LAP_QUESTION);
        this.inputRoundCount = promptInput.next();
        if (checkRoundCountValidation(inputRoundCount)) {
            roundCount = Integer.parseInt(inputRoundCount);
        }
    }


    private String[] splitRacerNameByFormat() {
        String[] runners = inputRunner.split(String.valueOf(Constants.RACER_LIST_FORMAT), 0);
        racerNameList = runners;
        return runners;
    }

    private boolean checkRacerNameValidation(String[] names) {
        for (String name : names) {
            checkRacerNameDuplication(name);
            checkRacerNameLength(name);
        }
        return true;
    }

    private boolean checkRacerNameDuplication(String name) {
        if (!runnerNameCheckSet.add(name)) {
            MessageUtils.errorExceptionThrow(Constants.DUPLICATION_ERROR_ANNOUNCEMENT);
            return true;
        }
        return false;
    }

    private boolean checkRacerNameLength(String name) {
        if (name.length() > Constants.RACER_NAME_LENGTH) {
            MessageUtils.errorExceptionThrow(Constants.OVER_LENGTH_ERROR_ANNOUNCEMENT);
            return false;
        }
        return true;
    }

    private boolean checkRoundCountValidation(String inputRoundCount) {
        for (int i = 0; i < inputRoundCount.length(); i++) {
            if (!Character.isDigit(inputRoundCount.charAt(i))) {
                MessageUtils.errorExceptionThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
            if (inputRoundCount.charAt(i) < 1) {
                MessageUtils.errorExceptionThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
        }
        if (!checkRoundCountPositiveNumberValidation(inputRoundCount)) {
            return false;
        }
        return true;
    }

    private boolean checkRoundCountPositiveNumberValidation(String inputRoundCount) {
        int positiveNumberCheck = Integer.parseInt(inputRoundCount);
        if (positiveNumberCheck <= 0) {
            MessageUtils.errorExceptionThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
            return false;
        }
        return true;
    }

}
