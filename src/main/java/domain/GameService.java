package domain;

import interfaces.GameServiceInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GameService implements GameServiceInterface {

    private final Console console;

    GameService() {
        console = new Console();
    }

    List<Car> getCarList() throws IOException {
        List<Car> carList = new ArrayList<>();
        Arrays.asList(getCars()).forEach(carName -> carList.add(new Car(carName)));

        return carList;
    }

    private String[] getCars() throws IOException {
        return console.readCars().split(REGEX);
    }

    int getRoundCount() throws IOException {
        return console.readRoundCount();
    }

    void roundStart() {
        console.writeRoundStartMessage();
    }

    void setRoundResult(List<Car> carList) {
        console.writeRoundResult(carList);
    }

    void makeWinnerList(List<Car> carList) {
        int max = maxPosition(carList);

        console.writeGameResult(carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList()));
    }

    private int maxPosition(List<Car> carList) {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(NOT_FOUND_MAXIMUM);
    }
}
