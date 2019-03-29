package domain.interfaces;

import domain.Car;

import java.util.List;

public interface UserInterface {
    String[] promptCarNames();
    int promptProgressCount();
    void notifyInvalidCarNamesInput();
    void notifyInvalidProgressCountInput();
    void printProgress(List<Car> cars);
    void printWinners(List<Car> cars);
}
