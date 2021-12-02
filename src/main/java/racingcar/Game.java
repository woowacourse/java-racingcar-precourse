package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> carList = new ArrayList<>();

    public void initialize() {
        // 자동차 이름 입력 받는 함수 호출

        // 시도할 회수 입력 받는 함수 호출
        int attemp = 0;

        start(attemp);
    }

    private void start(int attemp) {
        while (attemp > 0) {
            for (Car car : carList) {
                // 자동차별로 전진하는 함수 호출
            }

            attemp--;
        }
    }
}
