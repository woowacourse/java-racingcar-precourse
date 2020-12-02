package utils;

import java.util.List;

public class ValidateUtils {

    public static void carNameLengthCheck(List<String> carNamesSplitList) {
        for (int i = 0; i < carNamesSplitList.size(); i++) {
            if (carNamesSplitList.get(i).length() > 5) {
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
