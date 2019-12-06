package ui;

import domain.RacingCar;

import java.util.List;

public interface UserInterface {
    public List<RacingCar> extractRacingCars();
    public int getCycles();
}
