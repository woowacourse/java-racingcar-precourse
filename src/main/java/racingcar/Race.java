package racingcar;

import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class Race {

    public static final int RANDOM_START = 0;
    public static final int RANDOM_END = 9;
    public static final int MOVE = 4;

    public static GameResult start(List<Car> cars, int tryCount) {
        // todo 각 차수별 실행 결과 구하기
        List<Car> winners = new ArrayList<>();

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            singleTry(cars);
        }

        return new GameResult(new Winners(winners));
    }

    private static void singleTry(List<Car> cars) {
        for (Car car : cars) {
            moveOrStay(car);
        }
        System.out.println();
    }

    private static void moveOrStay(Car car) {
        if (isMove()) {
            car.moveForward();
        }
        car.printStatus();
    }

    private static boolean isMove() {
        // 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다
        return MOVE <= RandomUtils.nextInt(RANDOM_START, RANDOM_END);
    }
}
