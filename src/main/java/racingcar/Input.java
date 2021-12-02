package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String getCarName() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = bufferedReader.readLine();
        return input;
    }

    public static String getNumberOfAttempts() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = bufferedReader.readLine();
        return input;
    }
}
