package racingcar;

import java.util.ArrayList;

public class RacingGamePrinter implements IRacingGamePrinter {
    private static final String INPUT_PLAYER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

    @Override
    public void inputNames() {
        System.out.print(INPUT_PLAYER_NAME);
    }

    @Override
    public void errorInputPlayer() {
    }

    @Override
    public void inputReps() {
    }

    @Override
    public void errorInputReps() {
    }

    @Override
    public void start() {
    }

    @Override
    public void status(ArrayList<Car> cars) {
    }

    @Override
    public void winner(ArrayList<Car> cars) {
    }
}