package racingcar;

import java.util.ArrayList;

public class RacingGamePrinter implements IRacingGamePrinter {
    private static final String INPUT_PLAYER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String ERROR_PLAYER_NAME = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.\n";

    @Override
    public void inputNames() {
        System.out.print(INPUT_PLAYER_NAME);
    }

    @Override
    public void errorInputPlayer() {
        System.out.print(ERROR_PLAYER_NAME);
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