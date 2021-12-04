package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int PIVOT = 4;

    public static void tryMove(Car car) {
        if (canMove()) {
            car.goForward();
        }
    }

    private static boolean canMove() {
        return (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= PIVOT);
    }

    public static List<Car> decideWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxPosition = Referee.findMax(cars);
        for (Car car : cars) {
            winners=isWinner(winners, maxPosition, car);
        }
        return winners;
    }

    public static int findMax(List<Car> cars) {
        List<Integer> position = new ArrayList<>();
        for (Car car : cars) {
            position.add(car.getPosition());
        }
        return Collections.max(position);
    }

    private static List<Car> isWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
        return winners;
    }
}
