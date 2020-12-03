package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class StringUtils {

    public static final String RACER_NAME_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String LAP_QUESTIION = "시도할 회수는 몇회인가요?";
    public static final String LAP_IS_INTEGER_ANNOUNCEMENT = "0 이상의 수를 입력해 주세요.";
    public static final char RACER_LIST_FORMAT = ',';
    public static final int RACER_NAME_LENGTH = 5;

    public static String[] racerNameList;
    public static int roundCount;

    public String inputRunner;
    public String inputRoundCount;
    public HashSet<String> runnerNameCheckSet = new HashSet<String>();

    public StringUtils(Scanner promptInput) {
        System.out.println(RACER_NAME_ANNOUNCEMENT);
        this.inputRunner = promptInput.next();
        splitRacerNameByFormat();
        checkRacerNameValidation(racerNameList);

        System.out.println(LAP_QUESTIION);
        this.inputRoundCount = promptInput.next();
        if (checkRoundCountValidation(inputRoundCount)) {
            roundCount = Integer.parseInt(inputRoundCount);
        }
    }


    private String[] splitRacerNameByFormat() {
        String[] runners = inputRunner.split(String.valueOf(RACER_LIST_FORMAT), 0);
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
            System.out.println("duplication" + name);
            return true;
        }
        return false;
    }

    private boolean checkRacerNameLength(String name) {
        if (name.length() > RACER_NAME_LENGTH) {
            System.out.println("Over character" + name);
            return false;
        }
        return true;
    }

    private boolean checkRoundCountValidation(String inputRoundCount) {
        for (int i = 0; i < inputRoundCount.length(); i++) {
            if (!Character.isDigit(inputRoundCount.charAt(i))) {
                System.out.println(LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
            if (inputRoundCount.charAt(i) < 1) {
                System.out.println(LAP_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
        }
        return true;
    }
}
