package racingcar.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;

/**
 * 주어진 결과를 출력하는 클래스
 */
public class OutputGuide {

    private static final String WINNER_IS = "최종 우승자: ";
    private static final String SHOW_STATUS_LOG = "실행 결과";
    private static final String MORE_WINNERS = ", ";
    private final List<Car> cars;
    private final int moves;

    public OutputGuide(List<Car> cars, int moves) {
        this.cars = cars;
        this.moves = moves;
    }

    public void showResult() {
        raceStart();
        System.out.println(findWinner());
    }

    private void raceStart() {
        System.out.println(SHOW_STATUS_LOG);
        for (int i = 0; i < moves; i++) {
            race();
        }
    }

    private void race() {
        cars.forEach(Car::run);
        System.out.println();
    }

    private String findWinner() {
        int max = findMaxMove();
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(car -> {
            if (max == car.getPositionNumber()) {
                stringBuilder.append(car.getName()).append(MORE_WINNERS);
            }
        });
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(MORE_WINNERS));
        return WINNER_IS + stringBuilder.toString();
    }

    private int findMaxMove() {
        ArrayList<Integer> positions = new ArrayList<>();
        cars.forEach(car -> positions.add(car.getPositionNumber()));
        return Collections.max(positions);
    }
}
