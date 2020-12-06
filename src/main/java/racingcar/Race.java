package racingcar;

import static racingcar.GameResult.getResult;
import static utils.PrintUtils.print;

import java.util.List;
import utils.RandomUtils;

public class Race {

    public static final int RANDOM_START = 0;
    public static final int RANDOM_END = 9;
    public static final int MOVE = 4;

    public static GameResult start(List<Car> cars, int tryCount) {
        print("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            playSingleGame(cars);
        }

        return getResult(cars);
    }

    private static void playSingleGame(List<Car> cars) {
        for (Car car : cars) {
            driveOrStopCar(car);
        }
        System.out.println();
    }

    private static void driveOrStopCar(Car car) {
        if (isDrive()) {
            car.moveForward();
        }
        car.printStatus();
    }


    private static boolean isDrive() {
        // 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다
        return MOVE <= RandomUtils.nextInt(RANDOM_START, RANDOM_END);
    }
}
