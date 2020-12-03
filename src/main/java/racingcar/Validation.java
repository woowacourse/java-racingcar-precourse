package racingcar;

public class Validation {

    public static void isValidUserNames(String userNamesInput) {
        String[] users = userNamesInput.split(Constants.COMMA);

        if (users.length <= 1) {
            throw new IllegalArgumentException();
        }

        for (String user : users) {
            user = user.trim();

            if (user.length() > Constants.MAX_LENGTH_USER_NAME) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isValidUserTrialCount(String userTrialCount) {
        for (char num : userTrialCount.toCharArray()) {

            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
