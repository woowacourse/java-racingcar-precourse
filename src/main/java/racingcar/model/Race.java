package racingcar.model;

public class Race {
    private int numberOfRaces;
    private RacingCars racingCars;

    public Race(int numberOfRaces, RacingCars racingCars) {
        this.numberOfRaces = numberOfRaces;
        this.racingCars = racingCars;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
