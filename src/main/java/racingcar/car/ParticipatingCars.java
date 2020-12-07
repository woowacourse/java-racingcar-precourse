package racingcar.car;

import racingcar.race.RacePreparation;

import java.util.List;

public class ParticipatingCars {
    private List<Car> cars;

    public ParticipatingCars(String[] allCarName) {
        CarNameValidation.validation(allCarName);
        RacePreparation racePreparation = new RacePreparation();
        this.cars = racePreparation.carRegistration(allCarName);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
