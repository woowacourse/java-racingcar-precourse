package racingcar;

import static racingcar.MessageUtils.printMessageWithConstant;

import java.util.HashSet;
import java.util.Scanner;

public class InputUtils {

    public static String[] racerNameList;
    public static int roundCount;

    public String inputRunner;
    public String inputRoundCount;
    public HashSet<String> racerNameDuplicationCheckSet = new HashSet<String>();

    public InputUtils(Scanner promptInput) {
        printMessageWithConstant(new String[]{Constants.RACER_NAME_ANNOUNCEMENT});
        this.inputRunner = promptInput.next();
        checkRacerStringFormatter();
        setSplitRacerNameByFormat();
        checkRacerNameValidation();

        printMessageWithConstant(new String[]{Constants.LAP_QUESTION});
        this.inputRoundCount = promptInput.next();
        if (isRoundCountValidation(inputRoundCount)) {
            roundCount = Integer.parseInt(inputRoundCount);
        }
    }

    private void checkRacerStringFormatter() {
        String isFormatter = inputRunner.substring(0, 1);
        if (isFormatter.equals(",")) {
            MessageUtils.errorExceptionThrow(Constants.FORMATTER_ERROR_ANNOUNCEMENT);
        }
    }

    private void setSplitRacerNameByFormat() {
        String[] splitedRacerNameList = inputRunner
            .split(String.valueOf(Constants.RACER_LIST_FORMAT), 0);
        racerNameList = splitedRacerNameList;
    }

    private void checkRacerNameValidation() {
        for (String name : racerNameList) {
            checkRacerNameDuplication(name);
            checkRacerNameLength(name);
        }
    }

    private void checkRacerNameDuplication(String name) {
        if (!racerNameDuplicationCheckSet.add(name)) {
            MessageUtils.errorExceptionThrow(Constants.DUPLICATION_ERROR_ANNOUNCEMENT);
        }
    }

    private void checkRacerNameLength(String name) {
        if (name.length() > Constants.RACER_NAME_LENGTH) {
            MessageUtils.errorExceptionThrow(Constants.NAME_OVER_LENGTH_ERROR_ANNOUNCEMENT);
        }
    }

    private boolean isRoundCountValidation(String inputRoundCount) {
        if (!isRoundCountDataTypeValidation(inputRoundCount)) {
            return false;
        }
        if (!isRoundCountPositiveNumberValidation(inputRoundCount)) {
            return false;
        }
        return true;
    }

    private boolean isRoundCountDataTypeValidation(String inputRoundCount) {
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
        return true;
    }

    private boolean isRoundCountPositiveNumberValidation(String inputRoundCount) {
        int number = Integer.parseInt(inputRoundCount);
        if (number <= 0) {
            MessageUtils.errorExceptionThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
            return false;
        }
        return true;
    }

}
