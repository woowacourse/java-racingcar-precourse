package domain.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 리스트를 가지고 우승자를 추출해주는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class Winner {
    public static final int INIT_POSITION_TO_COMPARE = -1;

    public static List<String> makeWinnersName(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : makeWinner(cars)) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    private static List<Car> makeWinner(List<Car> cars) {
        return cars.stream().filter(car -> car.isSameThan(makeWinnerCount(cars))).collect(Collectors.toList());
    }

    private static int makeWinnerCount(List<Car> cars) {
        int maxPosition = INIT_POSITION_TO_COMPARE;
        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }
        return maxPosition;
    }
}
