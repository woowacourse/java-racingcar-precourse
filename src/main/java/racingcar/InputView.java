package racingcar;

import java.util.Scanner;

public class InputView {
    private Scanner input = new Scanner(System.in);

    private static String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String ASK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public String askCarName() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return input.nextLine();
    }

    public String getAskNumberOfAttempts() {
        System.out.println(ASK_NUMBER_OF_ATTEMPTS);
        return input.nextLine();
    }
}
