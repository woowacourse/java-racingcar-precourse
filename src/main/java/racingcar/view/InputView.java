package racingcar;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    private String userNames;
    private String userTrialCount;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    private void setUserTrialCount(String userTrialCount) {
        this.userTrialCount = userTrialCount;
    }

    public String getUserTrialCount() {
        return this.userTrialCount;
    }

    public String getUserNames() {
        return this.userNames;
    }

    public void parseUserNames() {
        try {
            System.out.println(Constants.PROMPT_USER_NAME);
            setUserNames(scanner.nextLine());
            Validation.isValidUserNames(getUserNames());

        } catch (Exception e) {
            System.err.println(Constants.ERR_USER_NAME);
            parseUserNames();
            return;
        }
    }

    public void parseUserTrialCount() {
        try {
            System.out.println(Constants.PROMPT_USER_TRIAL_COUNT);
            setUserTrialCount(scanner.nextLine());
            Validation.isValidUserTrialCount(getUserTrialCount());

        } catch (Exception e) {
            System.err.println(Constants.ERR_USER_TRIAL_COUNT);
            parseUserTrialCount();
            return;
        }
    }
}
