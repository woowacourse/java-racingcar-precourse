package racingcar;

import racingcar.controller.racingController;

public class Application {
    private static final racingController racingcontroller = new racingController();

    public static void main(String[] args) {
        racingcontroller.start();
    }
}
