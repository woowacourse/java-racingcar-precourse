package domain.racingcar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 우승한 자동차 리스트를 가지고 있는 객체
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class Winner {
    private static final int INIT_POSITION_TO_COMPARE = -1;

    private final List<Car> winners;

    public Winner(final List<Car> cars) {
        this.winners = cars.stream().filter(car -> car.isSameThan(makeWinnerPosition(cars))).collect(Collectors.toList());
    }

    public final List<String> makeWinnersName() {
        return this.winners.stream().map(Car::getName).collect(Collectors.toList());
    }

    private int makeWinnerPosition(final List<Car> cars) {
        int maxPosition = INIT_POSITION_TO_COMPARE;
        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }
        return maxPosition;
    }
}
