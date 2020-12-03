package racingcar;

import domain.Car;
import utils.InputView;
import utils.Printer;
import utils.RandomDigitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceManager {
    private Race race;

    public RaceManager(Scanner scanner) {
        InputView inputView = new InputView(scanner);
        String[] names = inputView.inputName();
        List<Car> cars = createCars(names);
        int round = inputView.inputRound();
        race = new Race(cars, round);
    }

    private List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void startRace(){
        Printer.printRaceStart();
        RaceResult raceResult = race.startRace(new RandomDigitStrategy());
        announceResult(raceResult);
    }

    private void announceResult(RaceResult raceResult) {
        List<String> winnersName = raceResult.getWinnersName();
        Printer.printWinnerName(winnersName);
    }
}
