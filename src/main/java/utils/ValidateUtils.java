package utils;

import java.util.List;

public class ValidateUtils {
    private static final int DEFAULT_CAR_NAME_MAX = 5;

    public static void carNameLengthCheck(List<String> carNamesSplitList) {
        for (String s : carNamesSplitList) {
            if (s.length() > DEFAULT_CAR_NAME_MAX) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 아래로 입력 바랍니다.");
            }
        }
    }

    public static int checkTryCountParseInt(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            System.err.println("시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(tryCount);
    }
}
