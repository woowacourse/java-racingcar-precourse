package racingcar.view;

import racingcar.constant.SystemMessage;

public class OutputView {
    public static void printErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }
}
