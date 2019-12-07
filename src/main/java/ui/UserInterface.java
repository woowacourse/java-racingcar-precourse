package ui;

import domain.Raceable;

import java.util.List;

public interface UserInterface {
    List<Raceable> extractRacingCars();
    int getCycles();
}
