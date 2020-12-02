package view;

import racingcar.Game;

public class OutputView {

    public static final String EXCEEDING_LENGTH_ERROR =
            "[ERROR] 이름은 " + Game.MAXIMUM_NAME_LENGTH + "글자 내로 만들어야한다.";
    public static final String NO_NAME_ERROR = "[ERROR] 최소 하나의 자동차 이름을 입력해야한다.";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
