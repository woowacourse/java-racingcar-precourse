package util;

import domain.RacingCar;

import java.util.List;

public interface RacingPrinter {
    void printStartSign();
    void printStateOfRacingCar(RacingCar racingCar);
    void printWinners(List<RacingCar> winners);
}
