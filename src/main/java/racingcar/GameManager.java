package racingcar;

import utils.RandomUtils;

import java.util.List;

public class GameManager {
    private final String GAME_RESULT_MESSAGE = "실행 결과";
    private final int START_INCLUSIVE_NUMBER = 0;
    private final int END_INCLUSIVE_NUMBER = 9;

    private boolean isGo() {
        int randomNumber = RandomUtils.nextInt(START_INCLUSIVE_NUMBER,END_INCLUSIVE_NUMBER);
        if (4 <= randomNumber) {
            return true; // GO
        }
        return false; // STOP
    }

    public void getResult(List<Car> cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        // for loop
    }

}
