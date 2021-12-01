package racingcar;

import java.util.Arrays;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        String[] everyCarName = InputView.enterEveryCarName();
        Arrays.stream(everyCarName).forEach(eachCarName -> validateCarName(eachCarName));
        int tryCntAboutCarMoving = InputView.enterTryCnt();

        Car car = new Car("taehoon");
        for (int i = 0; i < 100; i++) {
            car.move();
        }
        System.out.println("car.moveThisDistance() = " + car.moveThisDistance());
        // for (int i = 0; i < tryCntAboutCarMoving; i++) {
        //     moveEveryCar();
        // }
    }

    private static void validateCarName(String eachCarName) { // TODO: 이 로직은 INputView 로 옮기는게 적절할거같음.
        if (eachCarName.length() > 5) {
            throw new IllegalArgumentException("차 이름이 5글자가 넘어감.");
        }
        if (eachCarName.isEmpty()) {
            throw new IllegalArgumentException("차 이름 중 null값 있음");
        }
    }
}
