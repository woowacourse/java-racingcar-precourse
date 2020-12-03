package racingcar;

public class RacingGameException {

    public static String checkNameInputException(String carNameInput) throws Exception {
        if ("".equals(carNameInput)) {
            throw new NullPointerException();
        }
        if (CarNameDivider.divideName(carNameInput).equals("DuplicationName")) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (CarNameDivider.divideName(carNameInput).equals("NoName")) {
            throw new Exception();
        }

        return carNameInput;
    }

    public static int checkTimesInputException(String timesInput) throws Exception {
        int times = Integer.parseInt(timesInput);

        if (times == 0) {
            throw new IllegalAccessException();
        }
        if (times < 0) {
            throw new Exception("음수를 입력할 수 없음");
        }
        return times;
    }

    public static void printDuplicationInputMessage() {
        System.out.println("[ERROR] 하나의 자동차는 하나의 레인에만 참가할 수 있습니다.");
    }
    public static void printNoNameInputMessage() {
        System.out.println("[ERROR] 자동차의 이름은 공백일 수 없습니다.");
    }

    public static void printNameInputMessage() {
        System.out.println("[ERROR] 하나 이상의 자동차가 참가해야 합니다.");
    }

    public static void printInvalidInputMessage() {
        System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    public static void printZeroInputMessage() {
        System.out.println("[ERROR] 0보다 큰 숫자를 입력해야 한다");
    }

    public static void printMinusInputMessage() {
        System.out.println("[ERROR] 음수를 입력할 수 없다");
    }
}
