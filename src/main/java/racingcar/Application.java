package racingcar;

import racingcar.view.DefaultView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        DefaultView view = new DefaultView(new OutputView());
        view.render();
    }
}
