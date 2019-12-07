package ui;

import domain.RacingCar;

import java.util.List;

public interface UserInterface {
    List<RacingCar> extractRacingCars();
    int getCycles();
}
