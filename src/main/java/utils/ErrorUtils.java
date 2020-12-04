package utils;

public class ErrorUtils {

    private static String errorMsg = "";
    private static final String MSG = "[ERROR] %s";

    private static void print(Object args) {
        System.out.println(String.format(MSG, args));
    }

    public static void printNameError() {
        errorMsg = "자동차의 이름은 5자를 넘을 수 없습니다.";
        print(errorMsg);
    }

    public static void printNumError() {
        errorMsg = "시도 횟수는 숫자여야 한다.";
        print(errorMsg);
    }

    public static void printNumError(int tryNum) {
        errorMsg = "0보다 큰 수를 입력해야 한다.";
        print(errorMsg);
    }
}
