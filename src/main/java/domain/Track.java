package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class Track {
    private final static int DEFAULT_GOAL_POSITION = 5;
    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();
    /* 경기가 진행중인지 아닌지에 대한 여부 */
    private RaceStatus raceState = RaceStatus.ONGOING;

    private int goal;

    private Track(String[] racers, int goal) {
        for (String racer : racers) {
            cars.add(new Car(racer));
        }
        this.goal = goal;
    }

    public Track(String[] racers) {
        this(racers, DEFAULT_GOAL_POSITION);
    }

    public boolean isEnd() {
        return raceState.now;
    }

    public void next() {
        for (Car car : cars) {
            int position = car.forwardOrStop();
            if (position > goal) {
                winners.add(car);
                raceState = RaceStatus.END;
            }
        }
    }

    public List<Car> getWinners() {
        return new ArrayList<>(winners);
    }

    public void excuteRaceUntilEnd() {
        while (raceState.now) {
            next();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }

    enum RaceStatus {
        ONGOING(true), END(false);
        private boolean now;

        RaceStatus(boolean status) {
            this.now = status;
        }
    }
}
