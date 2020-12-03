package racingcar;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    private String userNames;
    private String userTrialCount;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserTrialCount() {
        return this.userTrialCount;
    }

    public String getUserNames() {
        return this.userNames;
    }

    private void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    private void setUserTrialCount(String userTrialCount) {
        this.userTrialCount = userTrialCount;
    }


    public void parseUserNames() {
        String userNamesInput = null;
        try {
            System.out.println(Constants.PROMPT_USER_NAME);
            userNamesInput = scanner.nextLine();
            Validation.isValidUserNames(userNamesInput);

        } catch (Exception e) {
            System.err.println(Constants.ERR_USER_NAME);
            parseUserNames();
            return;
        }
        setUserNames(userNamesInput);
    }

    public void parseUserTrialCount() {
        try {
            System.out.println(Constants.PROMPT_USER_TRIAL_COUNT);
            this.userTrialCount = scanner.nextLine();
            Validation.isValidUserTrialCount(userTrialCount);

        } catch (Exception e) {
            System.err.println(Constants.ERR_USER_TRIAL_COUNT);
            parseUserTrialCount();
            return;
        }
        setUserTrialCount(userTrialCount);
    }
}
