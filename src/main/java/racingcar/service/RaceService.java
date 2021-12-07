package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RacingCars;
import racingcar.util.Symbol;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    private Race race;

    public RacingCars createRacingCars(String[] name) {
        List<Car> racingCars = Arrays.stream(name).map(Car::new).collect(Collectors.toList());
        return new RacingCars(racingCars);
    }

    public void createRace(int numberOfRaces, RacingCars racingCars) {
        this.race = new Race(numberOfRaces, racingCars);
    }

    public String repeatRace() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < race.getNumberOfRaces(); i++) {
            RacingCars racingCars = race.getRacingCars();
            racingCars.moveForwardOrStop();
            stringBuilder.append(racingCars.getRacingCarsInfo());
            stringBuilder.append(Symbol.NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public String getRaceWinners() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> winners = race.getRacingCars().pickWinner();

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i));

            if (i < winners.size() - 1) {
                stringBuilder.append(Symbol.COMMA_SPACE);
            }
        }
        return stringBuilder.toString();
    }
}
