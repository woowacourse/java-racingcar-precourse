package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String getCarNameList() throws IOException {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return bufferedReader.readLine();
    }

    public static String getNumberOfAttempts() throws IOException {
        System.out.println(ASK_ATTEMPTS_MESSAGE);
        return bufferedReader.readLine();
    }
}