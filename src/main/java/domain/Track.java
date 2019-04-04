package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 경주가 이루어지는 Track
 * @author delf
 */
public class Track {
    private List<Car> cars = new ArrayList<>();

    /* 가장 많이 이동한 자동차의 position */
    private int maxPosition = 0;

    public final static int MAX_TRY_COUNT = 1000;
    public final static int MIN_TRY_COUNT = 1;

    public Track(String[] racers) {
        for (String racer : racers) {
            cars.add(new Car(racer));
        }
    }

    /* 1회 시도에 해당하는 작업을 수행한다.
    * 트랙 위의 자동차들은 일정 확률에 따라 전진하거나 정지한다. */
    public void next() {
        for (Car car : cars) {
            int position = car.forwardOrStop();
            maxPosition = Math.max(position, maxPosition);
        }
    }

    /* 모든 시도가 끝나면 가장 많이 이동한 자동차의 선수 이름을 담은 리스트를 반환한다. */
    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isPositionOn(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }
}
