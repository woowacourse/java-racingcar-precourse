package racingcar;

import java.util.Arrays;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        String[] everyCarName = InputView.enterEveryCarName();
        Arrays.stream(everyCarName).forEach(eachCarName -> validateCarName(eachCarName));
        int tryCntAboutCarMoving = InputView.enterTryCnt();

    }

    private static void validateCarName(String eachCarName) {
        if (eachCarName.length() > 5) {
            throw new IllegalArgumentException("차 이름이 5글자가 넘어감.");
        }
        if (eachCarName.isEmpty()) {
            throw new IllegalArgumentException("차 이름 중 null값 있음");
        }
    }
}
