package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.exception.RacingCarErrorException;
import racingcar.model.Car;

/**
 * 주어진 결과를 출력하는 클래스
 */
public class OutputGuide {

    private static final String WINNER_IS = "최종 우승자: ";
    private static final String DELIMITER = ", ";
    private static final String NO_WINNERS_EXCEPTION_MESSAGE = "우승자가 존재하지 않습니다.";

    private final List<Car> cars;

    public OutputGuide(List<Car> cars) {
        this.cars = cars;
    }

    public void showResult() {
        StringBuilder stringBuilder = new StringBuilder();
        cars.stream()
            .filter(car -> car.getPosition() == findMaxMove())
            .forEach(car -> stringBuilder.append(car.getName()).append(DELIMITER));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(DELIMITER));
        System.out.println(WINNER_IS + stringBuilder.toString());
    }

    private int findMaxMove() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new RacingCarErrorException(NO_WINNERS_EXCEPTION_MESSAGE));
    }
}
