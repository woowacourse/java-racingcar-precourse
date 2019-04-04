package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class Track {
    private List<Car> cars = new ArrayList<>();
    private int maxPosition = 0;

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

    // TODO: String 대신 Car?
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
