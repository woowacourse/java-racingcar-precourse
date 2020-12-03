package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.controller.RacingCarErrorException;
import racingcar.model.Car;

/**
 * 주어진 결과를 출력하는 클래스
 */
public class OutputGuide {

    private static final String WINNER_IS = "최종 우승자: ";
    private static final String SHOW_STATUS_LOG = "실행 결과";
    private static final String DELIMITER = ", ";
    private static final String NO_WINNERS_EXCEPTION_MESSAGE = "우승자가 존재하지 않습니다.";
    private static final int MIN = 0;

    private final List<Car> cars;
    private final int moves;

    public OutputGuide(List<Car> cars, int moves) {
        this.cars = cars;
        this.moves = moves;
    }

    public void showResult() {
        startRound();
        showWinner();
    }

    public void startRound() {
        System.out.println(SHOW_STATUS_LOG);
        IntStream.range(MIN,moves).forEach(value -> race());
    }

    private void race() {
        cars.forEach(Car::run);
        System.out.println();
    }

    private void showWinner() {
        int max = findMaxMove();
        StringBuilder stringBuilder = new StringBuilder();
        cars.stream()
            .filter(car -> car.getPosition() == max)
            .forEach(car -> stringBuilder.append(car.getName()).append(DELIMITER));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(DELIMITER));
        System.out.println(WINNER_IS + stringBuilder.toString());
    }

    private int findMaxMove() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(()->new RacingCarErrorException(NO_WINNERS_EXCEPTION_MESSAGE));
    }
}
