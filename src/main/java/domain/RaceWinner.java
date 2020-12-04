package domain;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {
    List<Car> raceWinners = new ArrayList<>();

    public void addRaceWinner(Car car) {
        raceWinners.add(car);
    }

    public List<Car> getRaceWinners() {
        return raceWinners;
    }
}
