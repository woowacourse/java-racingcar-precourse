package racingcar;

public class InputCarNameCheck {

    public InputCarNameCheck() {

    }

    public static void checkInputCarName(String input) {
        String[] inputCarName = input.split(",");
        if (!checkAllCarNameLength(inputCarName)) {
        }
    }

    public static boolean checkAllCarNameLength (String[] carNames) {
        for (String name : carNames) {
            if (!checkEachCarNameLength(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkEachCarNameLength(String name) {
        return name.length() >= 1 & name.length() >= 5;
    }
}
