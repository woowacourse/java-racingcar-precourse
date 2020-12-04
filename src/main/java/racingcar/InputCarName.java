package racingcar;

import java.util.Arrays;

public class InputCarName {

    public static boolean inputCarName(String str) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] strList = str.split(",");
        if (InputCarNameCheck.checkInputCarName(strList)) {
            System.out.println(Arrays.toString(strList));
            return true;
        }
        System.out.println(Arrays.toString(strList));
        return false;
    }

    public static int inputCount(String str) {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            if (InputCountCheck.checkInputCount(str)) {
                return Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            return inputCount(str);
        }
        return Integer.parseInt(str);
    }
}
