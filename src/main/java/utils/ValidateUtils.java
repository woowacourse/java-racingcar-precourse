package utils;

public class ValidateUtils {
    public static final String ERROR = "[ERROR]";
    public static final String INVALID_NAMES = "자동차 이름은 1글자 이상 글자 이하여야 합니다.";
    public static final String MORE_THAN_TWO_PLAYERS = "최소 2명의 PLAYER를 입력하세요.";

    public static boolean validateCarNames(String[] cars) {
        if (cars.length == 1) {
            System.out.println(ERROR + MORE_THAN_TWO_PLAYERS);
            return false;
        }

        for (String car : cars) {
            if (car.isEmpty() || car.length() > 5) {
                System.out.println(ERROR + INVALID_NAMES);
                return false;
            }
        }

        return true;
    }
}
