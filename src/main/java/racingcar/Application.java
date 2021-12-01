package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        String[] everyCarName = InputView.enterEveryCarName();
        for (String eachCarName : everyCarName) {
            System.out.println(eachCarName);
            if (eachCarName.length() > 5) {
                throw new IllegalArgumentException("차 이름이 5글자가 넘어감.");
            }
            if (eachCarName.isEmpty()) {
                throw new IllegalArgumentException("차 이름 중 null값 있음");
            }
        }
    }
}
