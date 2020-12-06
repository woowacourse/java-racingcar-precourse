package domain;

import java.util.Arrays;

public class InputCarName {

    public static String inputCarName(String str) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] strList = str.split(",");
        if (InputCarNameCheck.checkInputCarName(strList)) {
            System.out.println(Arrays.toString(strList));
            return Arrays.toString(strList);
        }
        return "0";
    }
}
