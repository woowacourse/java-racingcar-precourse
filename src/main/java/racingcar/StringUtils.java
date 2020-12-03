package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class StringUtils {

    public static final String RUNNER_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_QUESTION = "시도할 회수는 몇회인가요?";
    public static final String ROUND_IS_INTEGER_ANNOUNCEMENT = "0 이상의 수를 입력해 주세요.";
    public static final char RUNNER_FORMAT = ',';
    public static final int RUNNER_STRING_LENGTH = 5;

    public String inputRunner;
    public static String[] runnerNameList;
    public String inputRoundCount;
    public static int roundCount;

    public StringUtils(Scanner promptInput) {
        System.out.println(RUNNER_ANNOUNCEMENT);
        this.inputRunner = promptInput.next();
        splitRacerNameByFormat();
        checkRacerNameDuplication(runnerNameList);
        checkRacerNameLengthValidation(runnerNameList);

        System.out.println(ROUND_QUESTION);
        this.inputRoundCount = promptInput.next();
        if (checkRoundCountValidation(inputRoundCount)) {
            roundCount = Integer.parseInt(inputRoundCount);
        }
//        System.out.println(RoundCount);
    }


    private String[] splitRacerNameByFormat() {
        String[] runners = inputRunner.split(String.valueOf(RUNNER_FORMAT), 0);
        runnerNameList = runners;
        return runners;
    }

    private boolean checkRacerNameDuplication(String[] inputArray) {
        HashSet<String> set = new HashSet<String>();
        for (String element : inputArray) {
            if (!set.add(element)) {
                System.out.println("duplication" + element);
                return true;
            }
        }
        return false;
    }

    private boolean checkRacerNameLengthValidation(String[] Runner) {
        for (String name : Runner) {
            if (name.length() > RUNNER_STRING_LENGTH) {
                System.out.println("Over character" + name);
                return false;
            }
        }
        return true;
    }

    private boolean checkRoundCountValidation(String inputRoundCount) {
        for (int i = 0; i < inputRoundCount.length(); i++) {
            if (!Character.isDigit(inputRoundCount.charAt(i))) {
                System.out.println(ROUND_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
            if (inputRoundCount.charAt(i) < 1) {
                System.out.println(ROUND_IS_INTEGER_ANNOUNCEMENT);
                return false;
            }
        }
        return true;
    }
}
