package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String getCarNameList() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String getNumberOfAttempts() { // 시도 횟수를 물어보는 문자열을 출력하고, 터미널에서 입력한 문자열을 반환한다.
        System.out.println(ASK_ATTEMPTS_MESSAGE);
        return Console.readLine();
    }
}