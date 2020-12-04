package racingcar;

public class InputCountCheck {

    public InputCountCheck() {

    }

    public static boolean checkInputCount(String input) {
        if (inputCountLessThanOne(input)) {
            System.out.println("[ERROR] 시도 횟수는 1 이상이여야 합니다.");
            return false;
        }
        return true;
    }

    public static boolean inputCountLessThanOne(String input) {
        int inputCount = Integer.parseInt(input);
        return inputCount < 1;
    }
}
