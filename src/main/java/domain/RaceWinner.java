package domain;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {
    List<Car> raceWinners = new ArrayList<>();
    int maxPosition = 0;

    public void addRaceWinner(Car car) {
        raceWinners.add(car);
    }
}
