package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SC = new Scanner(System.in);
    private static final String CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER = "시도할 회수는 몇회인가요?";

    public static String requirePlayersName() {
        System.out.println(CAR_NAMES);
        return SC.nextLine();
    }

    public static String requireTryNumber() {
        System.out.println(TRY_NUMBER);
        return SC.nextLine();
    }
}
