package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 경주가 이루어지는 Track
 * @author delf
 */
public class Track {
    private List<Car> cars = new ArrayList<>();
    private int maxPosition = 0;

    public final static int MAX_TRY_COUNT = 1000;
    public final static int MIN_TRY_COUNT = 1;

    public Track(String[] racers) {
        for (String racer : racers) {
            cars.add(new Car(racer));
        }
    }

    public void next() {
        for (Car car : cars) {
            int position = car.forwardOrStop();
            maxPosition = Math.max(position, maxPosition);
        }
    }

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
