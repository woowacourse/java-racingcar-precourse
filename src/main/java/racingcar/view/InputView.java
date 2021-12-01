package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SC = new Scanner(System.in);

    public static String requirePlayersName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return SC.nextLine();
    }
}
