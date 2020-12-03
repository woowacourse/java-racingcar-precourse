package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class StringUtils {

    public String inputRunner;
    public String inputRoundCount;
    public HashSet<String> runnerNameCheckSet = new HashSet<String>();

    public StringUtils(Scanner promptInput) {
        System.out.println(Constants.RACER_NAME_ANNOUNCEMENT);
        this.inputRunner = promptInput.next();
        splitRacerNameByFormat();
        checkRacerNameValidation(Constants.racerNameList);

        System.out.println(Constants.LAP_QUESTIION);
        this.inputRoundCount = promptInput.next();
        if (checkRoundCountValidation(inputRoundCount)) {
            Constants.roundCount = Integer.parseInt(inputRoundCount);
        }
    }


    private String[] splitRacerNameByFormat() {
        String[] runners = inputRunner.split(String.valueOf(Constants.RACER_LIST_FORMAT), 0);
        Constants.racerNameList = runners;
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
            System.out.println("duplication" + name);
            return true;
        }
        return false;
    }

    private boolean checkRacerNameLength(String name) {
        if (name.length() > Constants.RACER_NAME_LENGTH) {
            System.out.println("Over character" + name);
            return false;
        }
        return true;
    }

    private boolean checkRoundCountValidation(String inputRoundCount) {
        for (int i = 0; i < inputRoundCount.length(); i++) {
            if (!Character.isDigit(inputRoundCount.charAt(i))) {
                System.out.println(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
            if (inputRoundCount.charAt(i) < 1) {
                System.out.println(Constants.LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
        }
        return true;
    }
}
