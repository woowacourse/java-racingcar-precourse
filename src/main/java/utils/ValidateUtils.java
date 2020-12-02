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
}
