package racingcar;

import java.util.*;
import java.util.stream.Collectors;

import utils.InputManager;
import utils.OutPutManager;

public class CarRacingGame {
    private static final int INITIAL_VALUE = 0;

    private final RaceCars raceCars;
    private int raceRound;

    public CarRacingGame() {
        raceCars = new RaceCars();
        raceRound = INITIAL_VALUE;
    }

    public void inputInfoForPlayGame(Scanner scanner) {
        InputManager inputManager = new InputManager(scanner);

        raceCars.setRaceCars(inputManager.inputRaceCar());
        raceRound = inputManager.inputRaceRound();
    }

    public void startCarRacing() {
        Race race = new Race(raceCars, raceRound);
        race.runCarRace();
    }

    public void carRaceWinner() {
        List<Car> sortedCarList = raceCars.getRaceCars().stream()
                .sorted((a, b) -> b.getPosition() - a.getPosition())
                .collect(Collectors.toList());

        List<String> winners = new ArrayList<>();
        int maxPosition = sortedCarList.get(0).getPosition();

        for (Car car : sortedCarList) {
            if (maxPosition == car.getPosition()) {
                winners.add(car.getName());
            }
        }
        OutPutManager.carRaceWinnerPrint(winners);
    }
}
