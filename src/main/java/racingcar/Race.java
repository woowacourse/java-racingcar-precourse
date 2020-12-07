package racingcar;

import static racingcar.GameResult.getResult;
import static racingcar.Messages.MESSAGE_GAME_RESULT;
import static utils.PrintUtils.print;
import static utils.PrintUtils.printEmptyLine;

import java.util.List;
import utils.RandomUtils;

public class Race {

    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;
    public static final int MOVE = 4;

    public static GameResult start(List<Car> cars, int tryCount) {
        print(MESSAGE_GAME_RESULT);
        for (int i = 0; i < tryCount; i++) {
            cars.forEach(Race::moveCar);
            printEmptyLine();
        }
        return getResult(cars);
    }

    private static void moveCar(Car car) {
        if (isMove()) {
            car.moveForward();
        }
        car.printStatus();
    }

    private static boolean isMove() {
        // 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다
        return MOVE <= RandomUtils.nextInt(RANDOM_MIN, RANDOM_MAX);
    }
}
