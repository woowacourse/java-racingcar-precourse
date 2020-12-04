package racingcar;

import static racingcar.MessageUtils.printMessageWithConstant;

import java.util.HashSet;
import java.util.Scanner;

public class InputUtils {

    public static String[] racerNameList;
    public static int lapCount;

    public String inputRacerName;
    public String inputLapCount;
    public HashSet<String> racerNameDuplicationCheckSet = new HashSet<String>();

    public InputUtils(Scanner promptInput) {
        printMessageWithConstant(new String[]{Constants.RACER_NAME_ANNOUNCEMENT});
        this.inputRacerName = promptInput.next();
        checkRacerStringFormatter();
        setSplitRacerNameByFormat();
        checkRacerNameValidation();

        printMessageWithConstant(new String[]{Constants.LAP_QUESTION});
        this.inputLapCount = promptInput.next();
        if (isLapCountValidation(inputLapCount)) {
            lapCount = Integer.parseInt(inputLapCount);
        }
    }

    private void checkRacerStringFormatter() {
        String isFormatter = inputRacerName.substring(0, 1);
        if (isFormatter.equals(",")) {
            ExceptionUtils.errorThrow(Constants.FORMATTER_ERROR_ANNOUNCEMENT);
        }
    }

    private void setSplitRacerNameByFormat() {
        String[] splitedRacerNameList = inputRacerName
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
            ExceptionUtils.errorThrow(Constants.DUPLICATION_ERROR_ANNOUNCEMENT);
        }
    }

    private void checkRacerNameLength(String name) {
        if (name.length() > Constants.RACER_NAME_LENGTH) {
            ExceptionUtils.errorThrow(Constants.NAME_OVER_LENGTH_ERROR_ANNOUNCEMENT);
        }
    }

    private boolean isLapCountValidation(String inputLapCount) {
        if (!isLapCountDataTypeValidation(inputLapCount)) {
            return false;
        }
        if (!isLapCountPositiveNumberValidation(inputLapCount)) {
            return false;
        }
        return true;
    }

    private boolean isLapCountDataTypeValidation(String inputLapCount) {
        for (int i = 0; i < inputLapCount.length(); i++) {
            if (!Character.isDigit(inputLapCount.charAt(i))) {
                ExceptionUtils.errorThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
            if (inputLapCount.charAt(i) < 1) {
                ExceptionUtils.errorThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
        }
        return true;
    }

    private boolean isLapCountPositiveNumberValidation(String inputLapCount) {
        int number = Integer.parseInt(inputLapCount);
        if (number <= 0) {
            ExceptionUtils.errorThrow(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
            return false;
        }
        return true;
    }
}
