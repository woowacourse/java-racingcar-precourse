package util;

import domain.Raceable;

import java.util.List;

public interface RacingPrinter {
    void printStartGameSign();
    void printStateOfRacingCar(Raceable raceable);
    void printWinners(List<Raceable> winners);

    void printOneCycleFinished();

    void printRequestForNames();

    void printRequestForCycles();
}
