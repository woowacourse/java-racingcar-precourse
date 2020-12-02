package racingcar;

import java.util.HashSet;
import java.util.Scanner;

public class StringUtils {

    public static final char runnerFormat = ',';
    public static final int runnerStringLength = 5;

    public String inputRunnerString;
    public String[] Runner;
    public int inputRoundCount;

    public StringUtils(Scanner promptInput) {
        this.inputRunnerString = promptInput.next();
    }

    public String[] splitRacerByFormat() {
        String[] runners = inputRunnerString.split(String.valueOf(runnerFormat), 0);
        this.Runner = runners;
        return runners;
    }

    private static boolean isDuplication(String[] inputArray) {
        HashSet<String> set = new HashSet<String>();
        for (String element : inputArray) {
            if (!set.add(element)) {
                System.out.println("duplication" + element);
                return true;
            }
        }
        return false;
    }

    private static boolean isValidationNameLength(String[] Runner) {
        for (String name : Runner) {
            if (name.length() > runnerStringLength) {
                System.out.println("Over character" + name);
                return false;
            }
        }
        System.out.println("OK");
        return true;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // Test

        StringUtils input = new StringUtils(scanner);
        input.splitRacerByFormat();
        isDuplication(input.Runner);
        isValidationNameLength(input.Runner);

    }
}
