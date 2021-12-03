package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;
import racingcar.Model.Car;
import racingcar.View.OutputView;

import java.util.List;

public class GameController {

    public void play(List<Car> cars) {
        for (Car car : cars) {
            moveOrNot(car);
        }
        OutputView.printExecutionResult(cars);
    }

    private void moveOrNot(Car car) {
        if (decideMoveOrNot()) {
            car.move();
        }
    }

    private boolean decideMoveOrNot() {
        int num = Randoms.pickNumberInRange(Constant.MINIMUM_NUMBER_OF_RANDOM, Constant.MAXIMUM_NUMBER_OF_RANDOM);
        return num >= Constant.NUMBER_FOR_MOVE;
    }
}
